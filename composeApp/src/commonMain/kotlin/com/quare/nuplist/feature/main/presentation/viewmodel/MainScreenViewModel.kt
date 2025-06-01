package com.quare.nuplist.feature.main.presentation.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quare.nuplist.feature.main.domain.MainScreenUiAction
import com.quare.nuplist.feature.main.domain.MainScreenUiEvent
import com.quare.nuplist.feature.main.domain.state.MainScreenUiState
import com.quare.nuplist.feature.main.presentation.model.BottomNavRoute
import com.quare.nuplist.feature.main.presentation.model.BottomNavigationItemModel
import com.quare.nuplist.feature.main.presentation.model.BottomNavigationItemPresentationModel
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import nuplist.composeapp.generated.resources.Res
import nuplist.composeapp.generated.resources.guests
import nuplist.composeapp.generated.resources.home

class MainScreenViewModel(
    private val supabaseClient: SupabaseClient,
) : ViewModel() {

    private val _state: MutableStateFlow<MainScreenUiState> = MutableStateFlow(
        MainScreenUiState(null)
    )
    val state: StateFlow<MainScreenUiState> = _state

    private val routes: List<BottomNavRoute> = listOf(
        BottomNavRoute.Home,
        BottomNavRoute.GuessList,
    )

    private val _uiAction: MutableSharedFlow<MainScreenUiAction> = MutableSharedFlow()
    val uiAction: SharedFlow<MainScreenUiAction> = _uiAction

    val bottomNavigationItemModels: List<BottomNavigationItemModel<Any>> =
        routes.map { it.toBottomNavHost() }

    fun dispatchUiEvent(event: MainScreenUiEvent) {
        when (event) {
            MainScreenUiEvent.ProfilePictureClicked -> emitAction(MainScreenUiAction.NavigateToProfile)

            MainScreenUiEvent.AddGuestClicked -> emitAction(MainScreenUiAction.NavigateToAddGuest)
            is MainScreenUiEvent.BottomNavItemClicked -> emitAction(
                MainScreenUiAction.NavigateToBottomRoute(
                    event.route
                )
            )

            MainScreenUiEvent.LogoutClick -> viewModelScope.launch {
                supabaseClient.auth.signOut()
            }

        }
    }

    private fun emitAction(action: MainScreenUiAction) {
        viewModelScope.launch {
            _uiAction.emit(action)
        }
    }

    private fun BottomNavRoute.toBottomNavHost(): BottomNavigationItemModel<Any> =
        BottomNavigationItemModel(
            route = this,
            presentationModel = when (this) {
                BottomNavRoute.Home -> BottomNavigationItemPresentationModel(
                    title = Res.string.home,
                    icon = Icons.Default.Home,
                )

                BottomNavRoute.GuessList -> BottomNavigationItemPresentationModel(
                    title = Res.string.guests,
                    icon = Icons.AutoMirrored.Default.List,
                )
            }
        )

}
