package com.assigment.gracenote.repository;

import com.assigment.gracenote.model.Chain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;


public interface ChainRepository extends JpaRepository<Chain, BigInteger> {

    @Query("Select c From Chain  c where c.chainId =:chainId")
    public Chain findByChainId(@Param("chainId") BigInteger chainId);

}
