package poo.collections_e_classes_uteis.Aula14;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Aula14 {
    public static void main(String[] args) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.HOUR));
        calendar.set(Calendar.YEAR, 2030);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss Z");
        String dateFormated = formatter.format(calendar.getTime());
        Date dateUnformated = formatter.parse(dateFormated);
        System.out.println(dateFormated);
        System.out.println(dateUnformated);
    }
}
