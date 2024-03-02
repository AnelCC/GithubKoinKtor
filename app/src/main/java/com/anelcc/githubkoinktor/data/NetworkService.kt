package com.anelcc.githubkoinktor.data

import com.anelcc.githubkoinktor.core.RepositoryApi
import com.anelcc.githubkoinktor.data.model.GitHubRepo
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class NetworkService(private val httpClient: HttpClient) : RepositoryApi {
    override suspend fun getRepositories(username: String): List<GitHubRepo> {
        val url = "https://api.github.com/users/$username/repos"
        return httpClient.get(url).body()
    }
}
