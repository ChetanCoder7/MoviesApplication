package com.hollywood.moviesApp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="SOUNDEFFECTS")
@Data
@NoArgsConstructor
public class SoundEffectsEntity implements Serializable {
    
	private static final long serialVersionUID = 7694439564064336005L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int se_code;
	
	
	@Column(name="MOVIE_SOUNDID",nullable=false,length=10)
	private String movie_soundId;
	
	@Column(nullable=false,length=100)
	private String movie_sounds;

}
