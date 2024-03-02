package com.hopcierge.githubkoinktor.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hopcierge.githubkoinktor.data.model.GitHubRepo
import com.hopcierge.githubkoinktor.domain.GetUserRepositoriesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ReposViewModel (
    private val getUserReposUseCase: GetUserRepositoriesUseCase,
) : ViewModel() {
    private val _repositories = MutableStateFlow<List<GitHubRepo>>(emptyList())
    val repositories = _repositories.asStateFlow()

    private val _selectedRepository = MutableStateFlow<GitHubRepo?>(null)
    val selectedRepository = _selectedRepository.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    fun loadUserRepositories(username: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val repos = getUserReposUseCase(username)
                _repositories.value = repos
            } catch (e: Exception) {
                _error.value = e.message ?: "Unknown error occurred"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
