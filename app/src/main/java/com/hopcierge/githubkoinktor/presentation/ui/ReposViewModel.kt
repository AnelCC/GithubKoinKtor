package com.hopcierge.githubkoinktor.presentation.ui

import androidx.lifecycle.ViewModel
import com.hopcierge.githubkoinktor.domain.GetUserRepositoriesUseCase

class ReposViewModel (
    private val getUserReposUseCase: GetUserRepositoriesUseCase,
) : ViewModel() {
}