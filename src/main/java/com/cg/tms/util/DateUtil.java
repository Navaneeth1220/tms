package com.cg.tms.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtil {

    private final String pattern = "dd/MM/yy";


    public LocalDate toDate(String text, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate date = LocalDate.parse(text, formatter);
        return date;
    }

    public LocalDate toDate(String text) {
        return toDate(text, pattern);
    }

    public String toText(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String text = formatter.format(date);
        return text;
    }

    public String toText(LocalDate date) {
        return toText( date, pattern);
    }


}
