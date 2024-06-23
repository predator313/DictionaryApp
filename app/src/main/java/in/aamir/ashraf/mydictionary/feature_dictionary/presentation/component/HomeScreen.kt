package `in`.aamir.ashraf.mydictionary.feature_dictionary.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import `in`.aamir.ashraf.mydictionary.feature_dictionary.presentation.WordInfoState
import `in`.aamir.ashraf.mydictionary.feature_dictionary.presentation.WordInfoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel:WordInfoViewModel,
    state:WordInfoState
){

    Scaffold{
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)){
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(it)
            ) {
                TextField(value = viewModel.searchQuery.value
                    , onValueChange = viewModel::onSearch,
                    placeholder = {
                        Text(text = "search....")
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ){
                    items(state.wordInfoItems.size){i->
                        val wordInfo = state.wordInfoItems[i]
                        if(i>0){
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                        WordInfoItem(wordInfo = wordInfo)

                        if(i<state.wordInfoItems.size-1){
                            Divider()
                        }
                    }
                }
            }
        }
    }
}

/*
The :: operator in Kotlin is called the "function reference" operator. It allows you to pass a function as a parameter without invoking it. In your case, viewModel::onSearch is a reference to the onSearch function in your WordInfoViewModel class.

Here’s how it works in your TextField:

value = viewModel.searchQuery.value: This sets the current value of the TextField to the searchQuery state in your viewModel.
onValueChange = viewModel::onSearch: This sets the onValueChange lambda to reference the onSearch function in your viewModel.
When the user types in the TextField, the onValueChange callback is triggered. Instead of defining a new lambda, you directly reference the onSearch function. This way, every time the text changes, viewModel.onSearch(newValue) is called, where newValue is the updated text from the TextField.

So, viewModel::onSearch is a shorthand to pass the onSearch function as a callback to the TextField's onValueChange parameter.
 */

