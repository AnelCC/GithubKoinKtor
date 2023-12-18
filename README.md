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

References:

https://developer.android.com/training/dependency-injection
https://insert-koin.io/docs/quickstart/android/