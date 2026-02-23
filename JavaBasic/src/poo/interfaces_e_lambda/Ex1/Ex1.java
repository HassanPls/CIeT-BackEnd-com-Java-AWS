package poo.interfaces_e_lambda.Ex1;

import java.util.Scanner;

public class Ex1 {
    /* Escreva um código para enviar mensagens de marketing, para isso você deve ter a possibilidade de enviar a mesma mensagem para serviços diferentes, esses serviços devem ter um método para receber a mensagem como parâmetro, os serviços que devem estar disponíveis são:

    SMS;
    E-mail;
    Redes Sociais;
    WhatsApp; */
    
    private static Scanner Sc = new Scanner(System.in);
    public static void main(String[] args) {
        int option = -1;

        do {

            System.out.println("Escolha uma opção");
            System.out.println("0 - sair");
            System.out.println("1 - Rede Social");
            System.out.println("2 - Email");
            System.out.println("3 - SMS");
            System.out.println("4 - Whatsapp");

            option = Sc.nextInt();
            Sc.nextLine();
            
            System.out.println("Qual será a mensagem enviada? ");
            String message = Sc.nextLine();

            switch (option) {
                case 1 -> sendMessageSocialMidia(message);
                case 2 -> sendMessageEmail(message);
                case 3 -> sendMessageSMS(message);
                case 4 -> sendMessageWhatsapp(message);
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida");
            }
        } while (option != 0);

        Sc.close();
    
    }

    public static void sendMessageSocialMidia(String message) {
        SocialMidia socialMidia = new SocialMidia(message);
        socialMidia.sendMessage();
    }

    public static void sendMessageEmail(String message) {
        Email email = new Email(message);
        email.sendMessage();
    }

    public static void sendMessageSMS(String message) {
        SMS sms = new SMS(message);
        sms.sendMessage();
    }
    
    public static void sendMessageWhatsapp(String message) {
        Whatsapp whatsapp = new Whatsapp(message);
        whatsapp.sendMessage();
    }
}
