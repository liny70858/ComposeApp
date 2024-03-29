package com.example.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp(modifier = Modifier.fillMaxSize())
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val expanded= remember {
        mutableStateOf(false)
    }
    val expandedPadding=if (expanded.value) 48.dp else 5.dp
    Surface(color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 5.dp, horizontal = 10.dp)
    ) {
        Row(modifier = modifier.padding(24.dp)) {
            Column(modifier = modifier.weight(1f)
                .padding(bottom = expandedPadding)) {
                Text(text = "Hello !")
                Text(text = name)
            }
            ElevatedButton(onClick = {
            expanded.value=!expanded.value
            }) {
                Text(text =if (expanded.value)"show less" else "show more")
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier=Modifier, nameList: List<String> = listOf("World", "Compose")) {
    Column(modifier=modifier) {
        nameList.forEach {
            Greeting(name = it)
        }
    }
}

@Preview(showBackground = true, widthDp = 1200, heightDp =800)
@Composable
fun GreetingPreview() {
    ComposeAppTheme {
        MyApp()
    }
}