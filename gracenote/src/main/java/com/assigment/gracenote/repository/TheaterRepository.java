package com.assigment.gracenote.repository;


import com.assigment.gracenote.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;

public interface TheaterRepository extends JpaRepository<Theater, BigInteger> {

    @Query("Select t From Theater  t where t.theaterId =:theaterId")
    public Theater findByTheaterId(@Param("theaterId") BigInteger theaterId);

}