package br.com.ifma.imobiliaria.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataConvert {

    public Date converterData(String data) {

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

        String[] arrayData = data.split("/");
        String datafmt = arrayData[2] + "-" + arrayData[1] + "-" + arrayData[0];

        try {
            return sdf1.parse(datafmt);
        } catch (ParseException e) {
            e.getMessage();
            return null;
        }
    }

}
