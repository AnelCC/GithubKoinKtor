package com.anelcc.githubkoinktor.domain

import com.anelcc.githubkoinktor.core.RepositoryApi
import com.anelcc.githubkoinktor.data.model.GitHubRepo

class GitHubRepository (private val gitHubService: RepositoryApi) {
    suspend fun getUserRepos(username: String): List<GitHubRepo> {
        return gitHubService.getRepositories(username)
    }
}