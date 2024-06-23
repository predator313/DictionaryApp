package `in`.aamir.ashraf.mydictionary.feature_dictionary.presentation.component

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import `in`.aamir.ashraf.mydictionary.feature_dictionary.presentation.WordInfoViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ShowSnackBar(
    viewModel: WordInfoViewModel = hiltViewModel()
){
    val snackBarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = true) {
        //this is sideEffect handler this execute only once
        viewModel.eventFlow.collectLatest { event ->
            when(event) {
                is WordInfoViewModel.UIEvent.ShowSnackbar -> {
                    snackBarHostState.showSnackbar(
                        message = event.message
                    )
                }

            }
        }
    }
}

