package poo.collections_e_classes_uteis.Aula7;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Aula7 {
    public static void main(String[] args) {
        
        System.out.println("================");
        float value1 = 0.1f;
        float value2 = 0.2f;
        System.out.println(value1 + value2);
        System.out.println("================");

        System.out.println(2.00f - 1.1f);
        System.out.println(2.00f - 1.2f);
        System.out.println(2.00f - 1.3f);
        System.out.println(2.00f - 1.4f);
        System.out.println(2.00f - 1.5f);
        System.out.println(2.00f - 1.6f);
        System.out.println(2.00f - 1.7f);
        System.out.println(2.00f - 1.8f);

        System.out.println("================");

        BigDecimal value3 = new BigDecimal("0.1");
        BigDecimal value4 = new BigDecimal("0.2");
        System.out.println(value3.add(value4));
        System.out.println(value3.multiply(value4));
        BigDecimal value5 = new BigDecimal("56.36");
        BigDecimal value6 = new BigDecimal("99.34");
        System.out.println(value5.divide(value6, 2, RoundingMode.HALF_UP));
        System.out.println(value6.negate());
        System.out.println(value3.sqrt(new MathContext(2)));
        System.out.println("================");

        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.1")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.2")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.3")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.4")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.5")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.6")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.7")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.8")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.9")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("2.00")));
    }
}
