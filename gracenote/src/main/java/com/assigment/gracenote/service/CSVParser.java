package com.assigment.gracenote.service;

import com.assigment.gracenote.model.TheaterData;
import com.assigment.gracenote.utility.DateTimeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CSVParser implements DataParser{


    @Override
    public List<TheaterData> parse(String filePath) {

        List<TheaterData> theaterData = new ArrayList<>();

        try{

            File inputF = new File(filePath);
            InputStream inputFS = getClass().getClassLoader().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

            // skip the header of the csv

            theaterData = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
            br.close();
        } catch (IOException e) {
           System.out.println("error parsing the file: "+e);
        }

        return theaterData ;

    }


    Function<String, TheaterData> mapToItem = (record)->{
        String[] columns = record.split(",");
        TheaterData newRecord = new TheaterData();
        System.out.println(Arrays.toString(columns));
        newRecord = newRecord.builder()
                .chainId(new BigInteger(columns[0]))
                .chainName(columns[1])
                .theaterId(new BigInteger(columns[2]))
                .theaterName(columns[3])
                .movieId(new BigInteger(columns[4]))
                .movieTitle(columns[5])
                .date(DateTimeUtility.convertToDate(columns[6]))
                .showtime(columns[7])
                .attributes(columns.length == 9 ?columns[8]:null)
                .build();
        return newRecord;
    };
}
