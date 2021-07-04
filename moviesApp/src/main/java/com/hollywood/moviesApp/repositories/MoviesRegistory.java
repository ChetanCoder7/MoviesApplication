package com.hollywood.moviesApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hollywood.moviesApp.entities.MoviesEntity;


@Repository
public interface MoviesRegistory extends JpaRepository<MoviesEntity,Long> {
	List<MoviesEntity> findAll(); 
	//List<MoviesEntity> findById(long id);

	@Query(value ="SELECT * FROM MOVIES WHERE MOVIE_TITLE LIKE %:title% ORDER BY MOVIE_TITLE",nativeQuery = true)
	List<MoviesEntity> searchMovie(@Param("title")String title);
}
