package com.hollywood.moviesApp.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MoviesDto {
	
	private long movie_code;
	private String movie_title;
	private String movie_language;
	private String movie_location;

}
