package com.onespan.android.interview.presentation.screens.detail

import androidx.lifecycle.ViewModel
import com.onespan.android.interview.domain.repository.CatsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(private val repository: CatsRepository) :
    ViewModel() {
}