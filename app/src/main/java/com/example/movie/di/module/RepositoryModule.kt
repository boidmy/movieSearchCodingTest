package com.example.movie.di.module

import com.example.movie.data.movie.MovieRepository
import com.example.movie.data.movie.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsMovieRepository(repository: MovieRepositoryImpl): MovieRepository
}