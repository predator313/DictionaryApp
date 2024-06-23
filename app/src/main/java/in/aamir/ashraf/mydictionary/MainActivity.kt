package `in`.aamir.ashraf.mydictionary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import `in`.aamir.ashraf.mydictionary.feature_dictionary.presentation.WordInfoViewModel
import `in`.aamir.ashraf.mydictionary.feature_dictionary.presentation.component.HomeScreen
import `in`.aamir.ashraf.mydictionary.feature_dictionary.presentation.component.ShowSnackBar
import `in`.aamir.ashraf.mydictionary.ui.theme.MyDictionaryTheme
@AndroidEntryPoint

class MainActivity : ComponentActivity() {
    private val viewModel:WordInfoViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyDictionaryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowSnackBar()
                    HomeScreen(viewModel = viewModel, state = viewModel.state.value)
                }
            }
        }
    }
}

