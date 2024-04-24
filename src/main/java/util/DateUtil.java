package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static Date stringToDate(String dateString) throws ParseException {
        return dateFormat.parse(dateString);
    }

    public static String dateToString(Date date) {
        return dateFormat.format(date);
    }
}
