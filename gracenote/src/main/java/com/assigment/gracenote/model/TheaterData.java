package com.assigment.gracenote.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
/*

  * This is initial version model. this model is break down anc creates multiple models for optimization.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="theater_data")
public class TheaterData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private BigInteger id;

    @Column(name = "theater_id")
    private BigInteger theaterId;

    @Column(name = "chain_id")
    private BigInteger chainId;

    @Column(name = "chain_name")
    private String chainName;

    @Column(name = "theater_name")
    private String theaterName;

    @Column(name="movie_id")
    private BigInteger movieId;

    @Column(name = "movie_title")
    private String movieTitle;

    @Column(name = "date")
    private Date date;


    private String showtime;

    private String attributes;

}
