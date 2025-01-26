package com.onespan.android.interview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class mainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidIntermediateInterviewTheme {
                ScreenContent()
            }
        }
    }
}

@Composable
fun ScreenContent() { Scaffold(topBar = { TopBar() }, modifier = Modifier.fillMaxSize()) { innerPadding -> CatBreeds(modifier = Modifier.padding(innerPadding)) } }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(title = { Text(stringResource(R.string.app_name)) })
}

@Composable
fun CatBreeds(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(20) {
            Text(text = "Cat Breed ${it + 1}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenContentPreview() {
    AndroidIntermediateInterviewTheme {
        ScreenContent()
    }
}