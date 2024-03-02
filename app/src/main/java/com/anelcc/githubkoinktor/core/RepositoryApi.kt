package com.anelcc.githubkoinktor.core

import com.anelcc.githubkoinktor.data.model.GitHubRepo

interface RepositoryApi {
    suspend fun getRepositories(username: String): List<GitHubRepo>
}