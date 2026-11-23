package com.bookora.core.common.android

import timber.log.Timber
import kotlin.reflect.KClass

internal fun Timber.DebugTree.addIgnoredClass(
    vararg classes: KClass<*>
) = apply {
    val fqcnIgnoreField = this::class.java.getDeclaredField("fqcnIgnore")
    fqcnIgnoreField.isAccessible = true
    val originList = fqcnIgnoreField.get(this) as List<*>
    val updatedList = originList + classes.map { it.java.name }
    fqcnIgnoreField.set(this, updatedList)
}