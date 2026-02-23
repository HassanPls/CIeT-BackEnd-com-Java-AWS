package poo.interfaces_e_lambda.Aula3;

import poo.interfaces_e_lambda.Aula3.keyword.*;

public class Aula3 {
    public static void main(String[] args) {
        Client client = new Client();
        client.setName("Pedro");
        Client.setStaticName("Nome estático");
        System.out.println(client.getName());
        System.out.println(client.getStaticName());
        Client client2 = new Client();
        client2.setName("Bruno");
        System.out.println(client.getName());
        System.out.println(client.getStaticName());

    }
}
