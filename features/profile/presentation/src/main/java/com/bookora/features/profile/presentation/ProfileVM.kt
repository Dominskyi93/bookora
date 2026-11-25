package com.bookora.features.profile.presentation

import com.bookora.core.presentation.base.AbstractViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileVM @Inject constructor(
    private val appRouter: ProfileRouter,
) : AbstractViewModel() {

//    val reducer = getProfileUseCase()
//        .containerMap { it.toImmutableList() }
//        .containerToReducer(
//            initialState = ::StateImpl,
//            nextState = StateImpl::copy
//        )
//
//    val stateFlow: StateFlow<Container<State>> = reducer.stateFlow


//    interface State {
//        val profile: ImmutableList<UiProfile>
//        val showBottomSheet: Boolean
//        val newUserInfo: UserInfo?
//    }

//    data class StateImpl(
//        val originProfile: List<Profile>,
//        val showBottomSheets: Boolean = false,
//        val foundUserInfo: UserInfo? = null
//    ) : State {
//        override val chats: ImmutableList<UiChat> = originChats
//            .map { originChat ->
//                UiProfile(
//                    origin = originChat,
//                    isEnabled = !disabledChatIds.contains(originChat.id)
//                )
//            }.toImmutableList()
//        override val showBottomSheet: Boolean = showBottomSheets
//        override val newUserInfo: UserInfo? = foundUserInfo
//    }
}