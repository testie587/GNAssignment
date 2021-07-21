package com.assigment.gracenote.Rest;

import com.assigment.gracenote.model.TheaterData;
import com.assigment.gracenote.repository.TheaterDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/theatersData")
public class TheaterController {

    @Autowired
    private TheaterDataRepository repo;



    @GetMapping(path="/all")
    public  List<TheaterData> getAll(){
        return this.repo.findAll();
    }

    @GetMapping(path="/{id}")
    public Optional<TheaterData> getAll(@PathVariable BigInteger id){
        return this.repo.findById(id);
    }

    @GetMapping(path="/chainname/{chainName}")
    public List<TheaterData> getAll(@PathVariable String chainName){
        return this.repo.findByChainName(chainName);
    }


}
