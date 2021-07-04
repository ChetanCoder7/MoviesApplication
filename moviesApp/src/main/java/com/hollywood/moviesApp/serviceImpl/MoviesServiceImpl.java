package com.hollywood.moviesApp.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hollywood.moviesApp.dtos.MovieDetailsDto;
import com.hollywood.moviesApp.dtos.MoviesDto;
import com.hollywood.moviesApp.entities.MoviesEntity;
import com.hollywood.moviesApp.repositories.MoviesRegistory;
import com.hollywood.moviesApp.repositories.SoundEffetcsRepository;
import com.hollywood.moviesApp.repositories.StillsRepository;
import com.hollywood.moviesApp.response.MoviesRest;
import com.hollywood.moviesApp.services.MoviesService;

import lombok.extern.slf4j.Slf4j;



@Component
@Slf4j
public class MoviesServiceImpl implements MoviesService {

	@Autowired
	MoviesRegistory moviesRegistory;
	@Autowired
	StillsRepository stillsRepo;
	@Autowired
	SoundEffetcsRepository soundRepo;
	
	@Override
	public List<MoviesDto> getMovies() {
		List<MoviesDto> movies=new ArrayList<MoviesDto>();
		List<MoviesEntity> moviesEntities=moviesRegistory.findAll();
		
			for(MoviesEntity et:moviesEntities) {
				MoviesDto md=new MoviesDto();
				md.setMovie_code(et.getMovie_code());
				md.setMovie_title(et.getMovie_title());
				md.setMovie_language(et.getMovie_language());
				md.setMovie_location(et.getMovie_location());
				movies.add(md);
			}
		return movies;
	}
	
	@Override
	public MovieDetailsDto getMovieDetails(long code) {
		MovieDetailsDto movieDetails=new MovieDetailsDto();
		MoviesEntity entity= moviesRegistory.getById(code);
		ModelMapper mapper = new ModelMapper();
		movieDetails=mapper.map(entity, MovieDetailsDto.class);
		List<String> stills=stillsRepo.findStillsByCode(movieDetails.getMovie_stillsId());
		movieDetails.setStills(stills);
		List<String> sounds=soundRepo.findSoundEffetcs(movieDetails.getMovie_soundId());
		movieDetails.setSoundEffects(sounds);
		log.info(movieDetails.toString());
		return movieDetails;
	}

	@Override
	public List<MoviesDto> searchMovieByTtile(String title) {
		List<MoviesDto> movies=new ArrayList<MoviesDto>();
		List<MoviesEntity> movieEntities=moviesRegistory.searchMovie(title);
		ModelMapper mapper = new ModelMapper();
		for(MoviesEntity entity:movieEntities) {
			movies.add(mapper.map(entity, MoviesDto.class));
		}
		log.info("##search result: "+movies.toString());
		return movies;
	}


}
