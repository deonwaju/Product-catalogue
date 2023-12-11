package com.deonolarewaju.product_catalogue.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatcher: AppDispatchers)

enum class AppDispatchers {
    DEFAULT, IO, MAIN, UNCONFINED
}