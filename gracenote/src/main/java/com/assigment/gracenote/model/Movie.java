package com.assigment.gracenote.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private BigInteger id;

    @Column(name="movie_id" )
    private BigInteger movieId;

    @Column(name="movie_Title")
    private String movieTitle;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id")
    private Set<Theater> theaters;
}
