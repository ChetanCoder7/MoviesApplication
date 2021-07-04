package com.hollywood.moviesApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hollywood.moviesApp.entities.MoviesEntity;

@Repository
public interface SoundEffetcsRepository extends JpaRepository<MoviesEntity,Long> {
	
	@Query(value ="SELECT MOVIE_SOUNDS FROM SOUNDEFFECTS WHERE MOVIE_SOUNDID =:id",nativeQuery = true)
	List<String> findSoundEffetcs(@Param("id")String movie_soundId);

}
