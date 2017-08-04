package com.odde.bbuddy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by allenwang on 2017/8/3.
 */

public class Utils {
    public static Date parsingDateString(String s) {
        if (s == null) { return new Date(); }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date result = null;
        try {
            result = df.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }


}
