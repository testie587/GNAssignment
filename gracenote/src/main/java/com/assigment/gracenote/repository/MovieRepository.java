package com.assigment.gracenote.repository;


import com.assigment.gracenote.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.math.BigInteger;


public interface MovieRepository extends JpaRepository<Movie, BigInteger> {

    @Query("Select m From Movie  m where m.movieId =:movieId")
    public Movie findByMovieId(@Param("movieId") BigInteger movieId);

}
