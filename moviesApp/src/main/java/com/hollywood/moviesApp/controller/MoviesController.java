package com.hollywood.moviesApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hollywood.moviesApp.dtos.MovieDetailsDto;
import com.hollywood.moviesApp.dtos.MoviesDto;
import com.hollywood.moviesApp.entities.MoviesEntity;
import com.hollywood.moviesApp.response.MovieDetailsRest;
import com.hollywood.moviesApp.response.MoviesRest;
import com.hollywood.moviesApp.services.MoviesService;


@Controller
@RequestMapping("/")
public class MoviesController {

	@Autowired
	MoviesService moviesService;
	
	@GetMapping
	public String getMovies(Model model){
		List<MoviesRest> response=new ArrayList<MoviesRest>();
		List<MoviesDto> moviesList=moviesService.getMovies();
		for(MoviesDto dto:moviesList) {
			MoviesRest movie=new MoviesRest();
			movie.setMovie_code(dto.getMovie_code());
			movie.setMovie_title(dto.getMovie_title());
			movie.setMovie_language(dto.getMovie_language());
			movie.setMovie_location(dto.getMovie_location());
			response.add(movie);
		}
		model.addAttribute("movieList",response);
		return "index";
	}
	
	@GetMapping("/{code}")
	public ModelAndView getMoviesByCode(@PathVariable long code){
		ModelAndView mav = new ModelAndView("movie_details");
		MovieDetailsRest response=new MovieDetailsRest();
		MovieDetailsDto movie= moviesService.getMovieDetails(code);
		ModelMapper mapper = new ModelMapper();
		response=mapper.map(movie, MovieDetailsRest.class);
		
		mav.addObject("movieDetails",response);
		return mav;
	}
	
	@GetMapping("/search/{title}")
	public String searchMovieByTtile(@PathVariable String title,Model model){
		List<MoviesRest> response=new ArrayList<MoviesRest>();
		List<MoviesDto> searchedMovies=moviesService.searchMovieByTtile(title);
		ModelMapper mapper = new ModelMapper();
		for(MoviesDto dto:searchedMovies) {
			response.add(mapper.map(dto, MoviesRest.class));
		}
		model.addAttribute("movieList",response);
		return "searchResult";
	}
}
