package com.hollywood.moviesApp.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MoviesRest {
	private long movie_code;
	@JsonProperty("Title")
	private String movie_title;
	@JsonProperty("Language")
	private String movie_language;
	@JsonProperty("Location")
	private String movie_location;
}
