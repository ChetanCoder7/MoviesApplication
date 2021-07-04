package com.hollywood.moviesApp.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MoviesControllerTest {
	 @Autowired
	 private MockMvc mockMvc;

	
	@Test
	public void getMovies() throws Exception{
		 mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
         .andExpect(status().isOk());
		
	}
	
	@Test
	public void getMoviesByCode() throws Exception{
		 mockMvc.perform(MockMvcRequestBuilders.get("/").param("code","1").accept(MediaType.APPLICATION_JSON))
         .andExpect(status().isOk());
		
	}
	
	@Test
	public void searchMovies() throws Exception{
		 mockMvc.perform(MockMvcRequestBuilders.get("/search/").param("title","Harry").accept(MediaType.APPLICATION_JSON))
         .andExpect(status().isOk());
		
	}
}
