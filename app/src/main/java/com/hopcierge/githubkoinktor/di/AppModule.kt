package com.hopcierge.githubkoinktor.di

import com.hopcierge.githubkoinktor.core.RepositoryApi
import com.hopcierge.githubkoinktor.data.NetworkService
import com.hopcierge.githubkoinktor.domain.GetUserRepositoriesUseCase
import com.hopcierge.githubkoinktor.domain.GitHubRepository
import com.hopcierge.githubkoinktor.presentation.ui.ReposViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                })
            }
        }
    }

    single<RepositoryApi> { NetworkService(get()) }
}

val repositoryModule = module {
    single { GitHubRepository(get()) }
}

val domainModule = module {
    factory { GetUserRepositoriesUseCase(get()) }
}

val viewModelModule = module {
    viewModel { ReposViewModel (get()) }
}
