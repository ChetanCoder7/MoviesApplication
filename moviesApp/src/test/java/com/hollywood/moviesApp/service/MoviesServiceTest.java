package com.hollywood.moviesApp.service;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.hollywood.moviesApp.entities.MoviesEntity;
import com.hollywood.moviesApp.repositories.MoviesRegistory;
import com.hollywood.moviesApp.repositories.SoundEffetcsRepository;
import com.hollywood.moviesApp.repositories.StillsRepository;
import com.hollywood.moviesApp.services.MoviesService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MoviesServiceTest {

	@MockBean
	MoviesRegistory moviesRepo;
	@MockBean
	StillsRepository stillsRepo;
	
	@MockBean
	SoundEffetcsRepository soundRepo;
	
	@Test
	public void shouldReturnMoviesDetails() {
		long code=10;
		MoviesEntity entity=new MoviesEntity();
		
		ArrayList<String> sounds=new ArrayList<String>();
		sounds.add("RX6");
		sounds.add("SDDS"); 
		
		ArrayList<String> stills=new ArrayList<>();
		stills.add("https://i.imgur.com/i3aD05u.png");
		stills.add("https://i.imgur.com/ABinULO.gif");
		stills.add("https://i.imgur.com/Wflfyct.gif");
		
		Mockito.when(moviesRepo.getById(code)).thenReturn(entity);
		Mockito.when(stillsRepo.findStillsByCode("20")).thenReturn(sounds);
		Mockito.when(soundRepo.findSoundEffetcs("1")).thenReturn(stills);
		
	}
	

	
}
