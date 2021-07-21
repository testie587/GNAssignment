package com.assigment.gracenote.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

/*
 *  This model is refactored from original model TheaterData for normalization and eliminate
 *      duplicate data.
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Chain {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private BigInteger id;

    @Column(name="chain_name")
    private String chainName;

    @Column(name="chain_id")
    private BigInteger chainId;

   /* @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id")
    private List<Theater> theaterList;

    */


}
