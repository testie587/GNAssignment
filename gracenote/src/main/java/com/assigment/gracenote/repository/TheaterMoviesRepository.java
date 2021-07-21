package com.assigment.gracenote.repository;

import com.assigment.gracenote.model.TheaterMovies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface TheaterMoviesRepository extends JpaRepository<TheaterMovies, BigInteger> {

    @Query("Select tm From TheaterMovies tm WHERE tm.theater.chain.chainName =:chainName")
    public List<TheaterMovies> findByChainName(@Param("chainName") String chainName);
}
