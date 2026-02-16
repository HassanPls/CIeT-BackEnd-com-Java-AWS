package poo.collections_e_classes_uteis.Aula4;

public class Aula4 {
    public static void main(String[] args) {
        /* for (Integer i = 0; i < 100; i++) {
            
        } */
       /* int i = null; */
       /* int[] i = new int[0]; */

        User user = new User("Pedro", 17);
        printValueUser(user);
        System.out.println(user);

        int  i = 0;
        printValue(i);
        System.out.println(i);
    }

    private static void printValue(final int i) {
        int ii = i;
        System.out.println(++ii);
        /* System.out.println(++i); */
    }

    private static void printValueUser(final User user) {
        System.out.println(user);
    }
}
