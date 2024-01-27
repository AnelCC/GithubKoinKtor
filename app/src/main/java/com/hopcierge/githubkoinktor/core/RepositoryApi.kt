package com.hopcierge.githubkoinktor.core

import com.hopcierge.githubkoinktor.data.model.GitHubRepo

interface RepositoryApi {
    suspend fun getRepositories(username: String): List<GitHubRepo>
}