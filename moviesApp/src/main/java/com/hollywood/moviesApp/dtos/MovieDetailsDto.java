package com.hollywood.moviesApp.dtos;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieDetailsDto {
	private int movie_code;	
	
	private String movie_title;
	
	private String movie_language;
	
	private String movie_location;
	
	private String movie_plot; 	
	
	private String movie_posterUrl;
	
	private String movie_soundId; 
	
	private String movie_stillsId;
	
	private String movie_imdbId; 
	
	private String movie_listingType;
	
	private String movie_imdbRating; 
	
	private List<String> stills;
	
	private List<String> soundEffects;
	

}
