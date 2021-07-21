package com.assigment.gracenote.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity(name="TheaterMovies")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="theater_movies")
public class TheaterMovies {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private BigInteger id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="movie_id")
    private Movie movie;

    private String showtime;

    private String attributes;

    @Column(name = "date")
    private Date date;

}
