package com.hopcierge.githubkoinktor.domain

import com.hopcierge.githubkoinktor.core.RepositoryApi
import com.hopcierge.githubkoinktor.data.model.GitHubRepo

class GitHubRepository (private val gitHubService: RepositoryApi) {
    suspend fun getUserRepos(username: String): List<GitHubRepo> {
        return gitHubService.getRepositories(username)
    }
}