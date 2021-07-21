package com.assigment.gracenote;

import com.assigment.gracenote.repository.TheaterRepository;
import com.assigment.gracenote.service.DataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GracenoteApplication {


    public static void main(String[] args) {
        SpringApplication.run(GracenoteApplication.class, args);

    }



}
