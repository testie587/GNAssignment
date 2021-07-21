package com.assigment.gracenote.repository;


import com.assigment.gracenote.model.TheaterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public interface TheaterDataRepository extends JpaRepository<TheaterData, BigInteger> {

    @Query("Select t From TheaterData  t where t.chainName =:chainName")
    public List<TheaterData> findByChainName(@Param("chainName") String chainName);

}
