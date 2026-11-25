package com.bookora.features.library.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.bookora.core.theme.Dimens
import com.bookora.core.theme.Shapes
import com.bookora.features.library.domain.entities.Book
import com.bookora.navigation.dsl.ScreenScope
import com.bookora.navigation.dsl.ScreenToolbar

fun ScreenScope.libraryScreen() {
    val viewModel: LibraryVM = viewModel(LibraryVM::class)

    toolbar = ScreenToolbar.Default()

    content {
        LibraryScreenContent(viewModel = viewModel)
    }
}

@Composable
fun LibraryScreenContent(
    modifier: Modifier = Modifier,
    viewModel: LibraryVM
) {
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val books by viewModel.books.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = Dimens.MediumPadding)
    ) {
        when {
            isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            books.isEmpty() -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No books found")
                }
            }

            else -> {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(Dimens.SmallPadding),
                    contentPadding = PaddingValues(bottom = Dimens.MediumPadding)
                ) {
                    items(
                        items = books,
                        key = { it.key },
                        contentType = { "book" }
                    ) { book ->
                        BookItem(book = book)
                    }
                }
            }
        }
    }
}

@Composable
fun BookItem(
    book: Book,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = Shapes.SmallRoundedCornerShape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimens.SmallPadding),
            horizontalArrangement = Arrangement.spacedBy(Dimens.MediumPadding)
        ) {
            AsyncImage(
                model = book.coverI
                    .takeIf { it > 0 }
                    ?.let { "https://covers.openlibrary.org/b/id/$it-M.jpg" },
                contentDescription = book.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(
                        width = Dimens.BookCoverSize.first,
                        height = Dimens.BookCoverSize.second
                    )
                    .clip(Shapes.ExtraSmallRoundedCornerShape),
//                placeholder = painterResource(R.drawable.book_placeholder),
//                error = painterResource(R.drawable.book_placeholder)
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(Dimens.ExtraSmallPadding)
            ) {
                Text(
                    text = book.title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = book.authorName.joinToString(", ")
                        .ifBlank { "Unknown author" },
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = book.firstPublishYear
                        .takeIf { it > 0 }
                        ?.let { "Published: $it" }
                        ?: "Publication year unknown",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}