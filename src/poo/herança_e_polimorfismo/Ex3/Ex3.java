package poo.herança_e_polimorfismo.Ex3;

public class Ex3 {
    /* Escreve uma hierarquia de classes para criação de relógios para diferentes lugares do mundo, defina uma classe pai que tenha as propriedades Hora, minuto e segundo com seus respectivos getters e setters (atendendo as regras do funcionamento de um relógio) e um método que deverá retornar a hora no formato HH:MM:SS, a partir dessa classe crie 2 implementações, uma chamada relógio Americando e outra chamada relógio Brasileiro, lembrando que para o relógio americano não existem as horas de 13 até 24. Defina também na super classe um método que ficará por responsabilidade da classe que extende-la definir seu funcionamemnto, esse método deve receber um relógio ( independente da implementação) e deve-se extrair as informações dele e usa-la no objeto que recebeu para setar as novas informações do relógio. */
    public static void main(String[] args) {
        Clock brlClock = new BRLClock();
        brlClock.setSecond(0);
        brlClock.setMinute(0);
        brlClock.setHour(13);
        
        System.out.println(brlClock.getTime());
        System.out.println(new USAClock().convert(brlClock).getTime());
    }
}
