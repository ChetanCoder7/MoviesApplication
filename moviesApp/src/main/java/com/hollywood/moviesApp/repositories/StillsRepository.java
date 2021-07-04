package com.hollywood.moviesApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hollywood.moviesApp.entities.MoviesEntity;

@Repository
public interface StillsRepository extends JpaRepository<MoviesEntity,Long>{
	@Query(value="SELECT MOVIE_STILLS FROM STILLS WHERE MOVIE_STILLSID = :id",nativeQuery = true)
	List<String> findStillsByCode(@Param("id") String id);

}
