package com.hollywood.moviesApp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="MOVIES")
@Data
@NoArgsConstructor
public class MoviesEntity implements Serializable{
	

	private static final long serialVersionUID = -2723914217736093632L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long movie_code;
	
	@Column(name="",nullable=false,length=100)
	private String movie_title;
	
	@Column(nullable=false,length=30)
	private String movie_language;
	
	@Column(nullable=false,length=30)
	private String movie_location;
	
	@Column(nullable=false,length=512)
	private String movie_plot; 	
	
	@Column(name="MOVIE_POSTERURL",nullable=false,length=512)
	private String movie_posterUrl;
	
	@Column(name="MOVIE_SOUNDID",nullable=false)
	private String movie_soundId; 
	
	@Column(name="MOVIE_STILLSID",nullable=false)
	private String movie_stillsId;
	
	@Column(name="MOVIE_IMDBID",nullable=false,length=15)
	private String movie_imdbId; 
	
	@Column(name="MOVIE_LISTINGTYPE",nullable=false,length=50)
	private String movie_listingType;
	
	@Column(name="MOVIE_IMDBRATING",nullable=false,length=10)
	private String movie_imdbRating; 	

}
