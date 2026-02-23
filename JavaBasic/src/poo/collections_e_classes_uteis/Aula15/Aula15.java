package poo.collections_e_classes_uteis.Aula15;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Aula15 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(formatter.format(localDate));

        String strDate = "22/12/2015";
        LocalDate localDate2 = LocalDate.parse(strDate, formatter);
        System.out.println(localDate2);
        System.out.println(localDate2.plus(50, ChronoUnit.DAYS));
        //System.out.println(date.plusDays(50));

        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("hh:mm:ss");
        System.out.println(formatter2.format(localTime));
        
        LocalDateTime localDateTime = localDate.atTime(localTime);
        System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(localDateTime));

        Date date = Date.from(localDateTime.toInstant(ZoneOffset.ofHours(-3)));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        ZoneId zoneId = calendar.getTimeZone().toZoneId();
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(calendar.toInstant(), zoneId);
        System.out.println(localDateTime2);

        System.out.println(Duration.between(localDateTime, localDateTime2).toMillis());

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        //offsetDateTime = offsetDateTime.withOffsetSameInstant(ZoneOffset.UTC);
        System.out.println(offsetDateTime);
        System.out.println(offsetDateTime.toEpochSecond());

        OffsetDateTime offsetDateTime2 = OffsetDateTime.now();
        OffsetDateTime offsetDateTime3 = offsetDateTime2.withOffsetSameInstant(ZoneOffset.UTC);
        System.out.println(offsetDateTime2.isEqual(offsetDateTime3));
    }
}
