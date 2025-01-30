package com.onespan.android.interview.presentation.screens.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.onespan.android.interview.R
import com.onespan.android.interview.components.CatsTopAppBar
import com.onespan.android.interview.presentation.navigation.CatsScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navController: NavHostController,
    breed: String, viewModel: DetailScreenViewModel
) {

    Scaffold(
        topBar = {
            CatsTopAppBar(
                title = stringResource(id = R.string.details_screen),
                icon = Icons.AutoMirrored.Filled.ArrowBack,
                onBackArrowClicked = {
                    navController.navigate(CatsScreens.HomeScreen.name)
                }
            )
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = breed,
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color(0xFF6200EE)
                )
            }
        }
    }
}