package com.hollywood.moviesApp.services;

import java.util.List;

import com.hollywood.moviesApp.dtos.MovieDetailsDto;
import com.hollywood.moviesApp.dtos.MoviesDto;


public interface MoviesService {
	List<MoviesDto> getMovies();

	MovieDetailsDto getMovieDetails(long code);

	List<MoviesDto> searchMovieByTtile(String title);

}
