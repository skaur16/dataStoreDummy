package com.sharan.datastoredummy

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.sharan.datastoredummy.dataStorage.StoreData
import com.sharan.datastoredummy.ui.theme.DataStoreDummyTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel : ViewModel by viewModels()

        setContent {
            DataStoreDummyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context = LocalContext.current
                    Data(viewModel, context)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Data(viewModel: ViewModel, context : Context) {

    val scope = rememberCoroutineScope()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(value = viewModel.str.value ,
                        onValueChange = {
                            viewModel.str.value = it
                        },
                        label = { Text(text = "Enter")}
                        )

        Button(onClick = {
                viewModel.setData(context)
        }) {
            Text(text = "Set Data")
        }
        Button(onClick = {
                viewModel.getData(context)
        })
        {
            Text(text = "Get Data")
        }
        if(viewModel.show.value){
            Text(text = viewModel.get.value)
        }

    }
}