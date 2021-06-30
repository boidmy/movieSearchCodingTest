package com.example.movie.di.component

import android.app.Application
import com.example.movie.MainApplication
import com.example.movie.di.module.ActivityBindingModule
import com.example.movie.di.module.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        RepositoryModule::class,
        ActivityBindingModule::class
    ]
)
interface ApplicationComponent: AndroidInjector<MainApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}