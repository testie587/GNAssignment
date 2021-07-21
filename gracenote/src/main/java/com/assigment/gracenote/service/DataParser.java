package com.assigment.gracenote.service;

import com.assigment.gracenote.model.TheaterData;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;


public interface DataParser {

    public List<TheaterData> parse(String filePath);
}
