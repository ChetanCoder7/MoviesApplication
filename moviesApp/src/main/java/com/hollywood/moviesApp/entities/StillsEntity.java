package com.hollywood.moviesApp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="STILLS")
@Data
@NoArgsConstructor
public class StillsEntity implements Serializable {
	

	private static final long serialVersionUID = -6696748486119789444L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int stills_code;
	
	@Column(name="MOVIE_STILLSID",nullable=false,length=10)
	private String movie_stillsId; 
	
	@Column(nullable=false,length=512)
	private String movie_stills;
}
