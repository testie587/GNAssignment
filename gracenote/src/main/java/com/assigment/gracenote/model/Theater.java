package com.assigment.gracenote.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private BigInteger id;

    @Column(name ="theater_name")
    private String theaterName;

    @Column(name ="theater_id")
    private BigInteger theaterId;

    @Column(name ="chain_id" , insertable  = false , updatable = false)
    private BigInteger chainId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chain_id")
    @ToString.Exclude private Chain chain;



}
