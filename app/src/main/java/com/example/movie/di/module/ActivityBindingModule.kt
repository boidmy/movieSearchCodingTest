package com.example.movie.di.module

import com.example.movie.ui.movie.MovieSearchActivity
import com.example.movie.di.custom.ActivityScope
import com.example.movie.ui.movie.MovieModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MovieModule::class])
    abstract fun mainActivity(): MovieSearchActivity
}