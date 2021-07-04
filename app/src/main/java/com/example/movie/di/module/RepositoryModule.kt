package com.example.movie.di.module

import com.example.movie.data.movie.MovieRepository
import com.example.movie.data.movie.MovieRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindsMovieRepository(repository: MovieRepositoryImpl): MovieRepository
}