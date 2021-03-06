package com.app.fetchretrovit.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.fetchretrovit.config.RetrofitBuilder

class MovieViewModel : ViewModel() {
    val movieRepository: MovieRepository

    init {
        val movieAPI = RetrofitBuilder.createRetrofit().create(MovieAPI::class.java)
        movieRepository =
            MovieRepository(movieAPI)
    }
val movieess = mutableListOf<Movie>(
    Movie(),
    Movie(),
    Movie(),
    Movie(),
    Movie(),
    Movie(),
    Movie()
)
    val movie: LiveData<Movie> = movieRepository.movie
    val allMovie : LiveData<List<Movie>> = movieRepository.movieList
//    val allMovie : MutableLiveData<List<Movie>> = MutableLiveData(movieess)
//    val allMovie : MutableLiveData<List<Movie>> = movieRepository.movieList
    fun getMovie(id: String) {
        movieRepository.getMovie(id)
    }

    fun getAllMovie(){
        movieRepository.getAllMovie()
    }

    fun saveMovie(movie: Movie){
        movieRepository.saveMovie(movie)
    }
}