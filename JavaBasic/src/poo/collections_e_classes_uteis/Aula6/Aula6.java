package poo.collections_e_classes_uteis.Aula6;

import java.time.Duration;
import java.time.OffsetDateTime;

public class Aula6 {
    public static void main(String[] args) {

        /* OffsetDateTime StringStart = OffsetDateTime.now();
        String stringConcat = "value";
        for (int i = 0; i < 500_000; i++) {
            stringConcat += i;
            if(i % 100_000 == 0) System.out.println(i);
        }
        OffsetDateTime StringEnd = OffsetDateTime.now();
        System.out.printf("String (singlethread): %s\n", Duration.between(StringStart, StringEnd).toMillis());

        OffsetDateTime builderStart = OffsetDateTime.now();
        StringBuilder builderConcat = new StringBuilder();
        for (int i = 0; i < 500_000; i++) {
            builderConcat.append(i);
        }
        
        OffsetDateTime builderEnd = OffsetDateTime.now();
        System.out.printf("StringBuilder (singlethread): %s\n", Duration.between(builderStart, builderEnd).toMillis());
        
        OffsetDateTime bufferStart = OffsetDateTime.now();
        StringBuffer bufferConcat = new StringBuffer();
        for (int i = 0; i < 500_000; i++) {
            bufferConcat.append(i);
        }
        
        OffsetDateTime bufferEnd = OffsetDateTime.now();
        System.out.printf("StringBuffer (multithread): %s\n", Duration.between(bufferStart, bufferEnd).toMillis()); */

        StringBuilder builder = new StringBuilder("1234567890");
        System.out.println(builder.delete(0, 3));
        System.out.println(builder.deleteCharAt(3));
        System.out.println(builder.reverse());
        System.out.println(builder.isEmpty());
        System.out.println(builder.lastIndexOf("7"));
        System.out.println(builder.insert(5, "a"));
        System.out.println(builder.length());
        builder.setLength(5);
        System.out.println(builder);
    }
}
