package com.hopcierge.githubkoinktor.domain

import com.hopcierge.githubkoinktor.data.model.GitHubRepo


class GetUserRepositoriesUseCase (private val repository: GitHubRepository) {
    suspend operator fun invoke(username: String): List<GitHubRepo> {
        return repository.getUserRepos(username)
    }
}