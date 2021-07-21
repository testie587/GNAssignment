package com.assigment.gracenote.Rest;

import com.assigment.gracenote.model.Chain;
import com.assigment.gracenote.model.Movie;
import com.assigment.gracenote.model.Theater;
import com.assigment.gracenote.model.TheaterMovies;
import com.assigment.gracenote.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/theaters/refactor")
public class RefactorTheaterData {


    @Autowired
    private  TheaterRepository theaterRepo;

    @Autowired
    private  MovieRepository movieRepo;

    @Autowired
    private  TheaterMoviesRepository theaterMovieRepo;

    @Autowired
    private  ChainRepository chainRepo;

    @GetMapping(path="/chain/all")
    public List<Chain> getAll(){
        return this.chainRepo.findAll();
    }


    @GetMapping(path="/movie/all")
    public List<Movie> getAllMovies(){
        return this.movieRepo.findAll();
    }

    @GetMapping(path="/theater/all")
    public List<Theater> getAllTheaters(){
        return this.theaterRepo.findAll();
    }

    @GetMapping(path="/theaterMovies/all")
    public List<TheaterMovies> getAlltheaterMovies(){
        return this.theaterMovieRepo.findAll();
    }

    @GetMapping(path="/theaterMovies/chain/{chainName}")               // this is final end point to get the expected result
    public List<TheaterMovies> getTheaterMoviesByChain(@PathVariable String chainName){
        return this.theaterMovieRepo.findByChainName(chainName);
    }
}
