package poo.herança_e_polimorfismo.Ex1;

public class Ex1 {
    /* Crie uma hierarquia de classes para tratar os tipos de ingresso que podem ser comercializados em um cinema. O ingresso deve ter um valor, nome do filme e informar se é dublado ou legendado. A partir desse ingresso devem ser criados os tipos Meia entrada e ingresso família. Cada ingresso deve ter um método que retorna o seu valor real ( baseado no valor informado na criação do ingresso) para os de meia entrada o seu valor deve ser de metade do valor, para os ingressos família deve-se retornar o valor multiplicado pelo número de pessoas e fornecer um desconto de 5% quando o número de pessoas for maior que 3. */
    public static void main(String[] args) {
        Ticket halfTicket = new Half(20);
        Ticket familyTicket = new Family(20,3);
        Ticket familyTicket2 = new Family(20,4);

        System.out.println(halfTicket.getPrice());
        System.out.println(familyTicket.getPrice());
        System.out.println(familyTicket2.getPrice());
    }
}
