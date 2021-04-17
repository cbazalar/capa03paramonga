package com.paramonga.capacitacion.domain;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

    private static String datePattern = "dd/MM/yyyy";

    public static Date obtenerFechaActual() {
        ZoneId zona = ZoneId.systemDefault();
        Date fechaActual =  Date.from(LocalDate.now().atStartOfDay(zona).toInstant());
        return fechaActual;
    }

    public static final String convertDateToString(Date aDate) {
        return getDateTime(datePattern, aDate);
    }

    public static final String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
            //log.error("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

}
