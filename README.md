# Catalogue App

## Overview

The Catalogue App is a Kotlin Jetpack Compose application that displays a variety of products. The app is built using MVVM (Model-View-ViewModel), MVI (Model-View-Intent), and follows a clean architecture pattern.

## Features

- Utilizes Jetpack Compose for building modern UIs.
- Implements MVVM and MVI architecture patterns for organized and scalable code.
- Integrates Android Architecture Components, such as ViewModel and Paging.
- Uses Dagger Hilt for dependency injection to enhance code modularity.
- Incorporates Retrofit for network requests and data retrieval.
- Integrates Room for local database storage.
- Implements swipe-to-refresh functionality using Accompanist library.
- Supports navigation using Navigation Compose and Hilt Navigation Compose.
- Utilizes Coil Compose for efficient image loading.

## Dependencies

### Jetpack Compose
- [androidx.navigation:navigation-compose:2.7.5](https://developer.android.com/jetpack/androidx/releases/navigation)
- [androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1](https://developer.android.com/jetpack/androidx/releases/lifecycle)
- [androidx.paging:paging-compose:1.0.0-alpha14](https://developer.android.com/jetpack/androidx/releases/paging)
- [androidx.compose.material:material:1.5.4](https://developer.android.com/jetpack/androidx/releases/compose-material)
- [io.coil-kt:coil-compose:2.4.0](https://coil-kt.github.io/coil/compose)

### Additional Compose Libraries
- [com.google.accompanist:accompanist-swiperefresh:0.24.2-alpha](https://github.com/google/accompanist)

### Dagger Hilt
- [com.google.dagger:hilt-android:2.49](https://dagger.dev/hilt/)
- [androidx.hilt:hilt-navigation-compose:1.1.0](https://dagger.dev/hilt/navigation-compose)

### Networking
- [com.squareup.retrofit2:retrofit:2.9.0](https://square.github.io/retrofit/)
- [com.squareup.retrofit2:converter-moshi:2.9.0](https://github.com/square/retrofit)
- [com.squareup.okhttp3:okhttp:5.0.0-alpha.3](https://square.github.io/okhttp/)
- [com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3](https://github.com/square/okhttp)
- [com.squareup.retrofit2:converter-gson:2.9.0](https://github.com/square/retrofit)

### JSON Parsing
- [com.google.code.gson:gson:2.9.0](https://github.com/google/gson)

### Room
- [androidx.room:room-runtime:2.6.1](https://developer.android.com/jetpack/androidx/releases/room)
- [androidx.room:room-ktx:2.4.2](https://developer.android.com/jetpack/androidx/releases/room)

## Build and Run

To build and run the project, follow these steps:

1. Clone the repository:

```bash
git clone https://github.com/your-username/CatalogueApp.git
```

## Contribution Guidelines
We welcome contributions! If you would like to contribute to the Catalogue App, please follow our contribution guidelines.

## MIT License

The Catalogue App is licensed under the
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

