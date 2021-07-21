package com.assigment.gracenote.loaddata;

import com.assigment.gracenote.model.*;
import com.assigment.gracenote.repository.*;
import com.assigment.gracenote.service.DataParser;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class InitApp {

    private final TheaterDataRepository repo ;
    private final DataParser csvParser ;
    private final TheaterRepository theaterRepo;
    private final MovieRepository movieRepo;
    private final TheaterMoviesRepository theaterMovieRepo;
    private final ChainRepository chainRepo;

    public InitApp(TheaterDataRepository repo, DataParser csvParser,  MovieRepository movieRepo, TheaterMoviesRepository theaterMovieRepo, TheaterRepository theaterRepo, ChainRepository chainRepo){
        this.repo = repo;
        this.csvParser = csvParser;
        this.theaterRepo = theaterRepo;
        this.movieRepo = movieRepo;
        this.theaterMovieRepo = theaterMovieRepo;
        this.chainRepo = chainRepo;
        this.loadData();
        this.loadData2(); // this is for steps 4, 5, 6
    }

    @Transactional
    public void loadData(){
        String filePath = "theater_data.csv";

        List<TheaterData> theaterModels = this.csvParser.parse(filePath);

        for(TheaterData theater:theaterModels){
          this.repo.save(theater);  // save changes
        }

        this.repo.flush();          // flush changes to database
    }

    @Transactional
    public void loadData2(){
        String filePath = "theater_data.csv";

        List<TheaterData> csvRecords = this.csvParser.parse(filePath);

        for(TheaterData csvRecord: csvRecords){

            Chain chain = this.chainRepo.findByChainId(csvRecord.getChainId());

            if(chain == null){
                chain = new Chain().builder()
                        .chainId(csvRecord.getChainId())
                        .chainName(csvRecord.getChainName()).build();
                System.out.println("saving movie: ");
                this.chainRepo.saveAndFlush(chain);
                System.out.println("after saving movie: ");
            }


            Theater theater = this.theaterRepo.findByTheaterId(csvRecord.getTheaterId());

            if(theater == null) {

                theater = new Theater().builder()
                          .theaterId(csvRecord.getTheaterId())
                          .theaterName(csvRecord.getTheaterName())
                          .chain(chain).build();
                System.out.println("saving theater: ");
                this.theaterRepo.saveAndFlush(theater);
                System.out.println("after saving theater: ");
            }

            Movie movie = this.movieRepo.findByMovieId(csvRecord.getMovieId());

            if(movie == null){
                movie = new Movie().builder()
                        .movieId(csvRecord.getMovieId())
                        .movieTitle(csvRecord.getMovieTitle())
                        .build();
                System.out.println("saving movie: ");
                this.movieRepo.saveAndFlush(movie);
                System.out.println("after saving movie: ");
            }

            TheaterMovies theaterMovies = new TheaterMovies().builder()
                                          .theater(theater)
                                          .movie(movie)
                                          .date(csvRecord.getDate())
                                          .showtime(csvRecord.getShowtime())
                                          .attributes(csvRecord.getAttributes())
                                          .build();
            this.theaterMovieRepo.save(theaterMovies);

        }

        this.theaterMovieRepo.flush();



    }


}
