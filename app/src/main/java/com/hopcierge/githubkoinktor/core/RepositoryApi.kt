package com.hopcierge.githubkoinktor.core

interface RepositoryApi {
    suspend fun getRepositories(username: String): Any
}