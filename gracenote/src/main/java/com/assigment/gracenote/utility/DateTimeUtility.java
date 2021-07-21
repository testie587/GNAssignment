package com.assigment.gracenote.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public  class DateTimeUtility {


    public static Date convertToDate(String stringDate){

        Date date = null;
        try{
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            date = format.parse(stringDate);
        }catch (Exception e){
            System.out.println("failed to parse date: "+e);
        }
        return date;
    }

}
