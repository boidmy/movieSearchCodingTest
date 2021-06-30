package com.example.movie.ui.movie

import androidx.lifecycle.ViewModel
import com.example.movie.di.custom.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MovieModule {
    @Binds
    @IntoMap
    @ViewModelKey(MovieSearchViewModel::class)
    abstract fun bindsMovieSearchViewModel(viewModel: MovieSearchViewModel): ViewModel
}