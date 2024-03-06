# Koin and ktor

## Koin
### What is dependency injection?

Dependency Injection (DI) is a software design pattern where a class receives its dependencies (other classes or objects) from an external source rather than creating them itself.
By following the principles of DI, you lay the groundwork for good app architecture. Implementing dependency injection provides you with the following advantages:

- Reusability of code
- Ease of refactoring
- Ease of testing

### 👀 What is koin android?
Koin is a lightweight dependency injection framework specifically designed for Kotlin applications, including those on Android. It provides a simple and pragmatic way to manage and inject dependencies, aiming for ease of use and reduced boilerplate compared to other DI frameworks.

Koin as a DI Framework:
Koin acts as a container for managing these dependencies, providing a way to register them and retrieve them when needed.
Key Features:
- Kotlin-centric: Koin is designed to be used with Kotlin, taking advantage of its features and syntax.
- Simplicity: It offers a straightforward API that's easier to learn and use, especially for developers new to DI.
- No Code Generation: Koin avoids code generation and reflection, resulting in faster build times and reduced potential issues.
- Reduced Boilerplate: Koin reduces the amount of code required for DI compared to other frameworks like Dagger or Hilt.

### 🧠 What Does Koin Do?
It helps you:
- Create and manage dependencies (like ViewModels, repositories, services)
- Inject dependencies into classes (Activity, Fragment, ViewModel, etc.)
- Scope objects (singleton, factory, etc.)
- Organize dependencies cleanly and testably.

### ✅ Benefits of Koin
- No annotations or code generation
- Lightweight and easy to learn
- Kotlin DSL for declaring dependencies
- Easy to use with ViewModels and Coroutines****

### 🛠️ When to Use Koin
- If you want simple DI with minimal boilerplate
- When building a Kotlin-first project
- If you prefer clarity over compile-time validation


## Example: Using Koin in Android

1. Add dependencies to build.gradle.kts

```Kotlin
// Core
implementation("io.insert-koin:koin-android:3.5.3")
// (Optional) for ViewModel
implementation("io.insert-koin:koin-androidx-viewmodel:3.5.3")
```
2. Define a Koin module
```Kotlin
val appModule = module {
    single { MyRepository() }
}
```

3. Initialize Koin in Application class
```Kotlin
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(appModule)
        }
    }
}
```
4. Inject in ViewModel
```Kotlin
class MyViewModel(private val repo: MyRepository) : ViewModel() {
    fun load() = repo.getData()
}
```
5. Use ViewModel in Fragment or Activity
```Kotlin
class MyFragment : Fragment() {
    private val viewModel: MyViewModel by viewModel()
}
```


| Koin Scope | Instance Type | Shared? | Use Case                    |
| ---------- | ------------- | ------- | --------------------------- |
| `single`   | Singleton     | ✅ Yes   | Repository, DB, API client  |
| `factory`  | Prototype     | ❌ No    | Adapter, Formatter, UseCase |


### 👀 What is Ktor android?
Ktor is a Kotlin framework for building asynchronous clients and servers, developed by JetBrains. On Android, we mostly use the Ktor client to make network calls.
Its seamless integration with coroutines and Kotlin's features, making it a powerful and flexible alternative to traditional networking libraries like Retrofit.


### 🔑 Key Features of Ktor for Android:
- Asynchronous and Kotlin-First: Ktor leverages Kotlin coroutines for asynchronous operations, enabling efficient handling of network requests without blocking the main thread.
- Lightweight and Modular: You can include only the modules you need, leading to a smaller dependency footprint.
- Multiplatform Support: Ktor is designed to be used across multiple platforms, including Android, iOS, JVM, and JavaScript. This allows you to share networking code between different platforms.
- Extensibility: Ktor is highly extensible, allowing you to add custom plugins for logging, content negotiation, and more.
- Flexible HTTP Client: Ktor provides fine-grained control over request building, logging, and custom pipelines, allowing you to tailor it to your specific needs.
- Benefits of Using Ktor in Android Development: Modern Asynchronous Programming: Ktor's coroutine-based approach simplifies asynchronous programming, making it easier to handle network requests efficiently.
- Seamless Kotlin Integration: Ktor's design aligns well with Kotlin's features, resulting in cleaner, more readable code.
- Multiplatform Compatibility: Ktor can be used in Kotlin Multiplatform Mobile projects, allowing you to share networking code between Android and iOS applications.
- Flexibility and Control: Ktor's modular architecture and extensibility allow you to customize it to your specific needs.
- Backed by JetBrains: Being developed by JetBrains, Ktor benefits from the expertise and support of the Kotlin creators.


📦 Ktor Android Dependency

```Kotlin
implementation("io.ktor:ktor-client-android:2.3.5")
implementation("io.ktor:ktor-client-content-negotiation:2.3.5")
implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.5")
```

⚡️ Create the HTTP Client

```Kotlin
val client = HttpClient(Android) {
    install(ContentNegotiation) {
        json()
    }
}
```

🛜 Make a network call 

```Kotlin
suspend fun getUserRepos(username: String): List<GitHubRepo> {
    return client.get("https://api.github.com/users/$username/repos").body()
}
```

🧐 Use in a ViewModel or Coroutine

```Kotlin
viewModelScope.launch {
    val repos = getUserRepos("AnelCC")
    Log.d("Repos", repos.toString())
}
```

## 💡 Why Use Ktor on Android?
💬 Clean DSL for requests (get, post, put, etc.)
⚡️ Fully coroutine-based (no callbacks!)
🔄 Built-in JSON serialization via kotlinx.serialization
🌍 Multiplatform-ready (can reuse for KMM projects)
🔒 Supports auth, headers, logging, retries, etc.


🆚 Ktor Android vs Retrofit
| Feature        | Ktor Android         | Retrofit                 |
| -------------- | -------------------  | ------------------------ |
| DSL-style      | ✅ Yes               | ❌ No (uses annotations) |
| Coroutines     | ✅ Native            | ✅ With adapter          |
| JSON Support   | ✅ Built-in          | ✅ Needs converter       |
| KMM Support    | ✅ Yes               | ❌ No                    |
| Learning Curve | Medium               | Easy                     |
| Flexibility    | ✅ More customizable | Limited but simple       |


References:
- https://ktor.io/
- https://ktor.io/docs/client-create-new-application.html#new-project
- https://developer.android.com/training/dependency-injection
- https://insert-koin.io/docs/quickstart/android/