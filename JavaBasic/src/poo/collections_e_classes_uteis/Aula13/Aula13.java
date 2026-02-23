package poo.collections_e_classes_uteis.Aula13;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Aula13 {
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
        System.out.println(date);
        System.out.println(formatter.format(date));

        Date date2 = new Date(System.currentTimeMillis() - 999999999999L);
        System.out.println(date2);

        Date date3 = new Date();
        date3.setYear(99);
        date3.setHours(22);
        System.out.println(date3);

        System.out.println(date2.before(date3));
        System.out.println(date2.after(date3));
    }
}
