package com.hollywood.moviesApp.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hollywood.moviesApp.dtos.MovieDetailsDto;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class MovieDetailsRest {

	
	private long movie_code;	
	
	@JsonProperty("Title")
	private String movie_title;
	
	@JsonProperty("Language")
	private String movie_language;
	
	@JsonProperty("Location")
	private String movie_location;
	
	@JsonProperty("Plot")
	private String movie_plot; 	
	
	@JsonProperty("Poster")
	private String movie_posterUrl;
	
	private String movie_soundId; 
	
	private String movie_stillsId;
	
	private String movie_imdbId; 
	
	@JsonProperty("ListingType")
	private String movie_listingType;
	
	private String movie_imdbRating;
	
	@JsonProperty("Stills")
	private List<String> stills;
	
	@JsonProperty("SoundEffects")
	private List<String> soundEffects;
}
