package poo.interfaces_e_lambda.Ex1;

public record Email(String message) implements Service {

	@Override
	public void sendMessage() {
		System.out.println("Enviando a seguinte mensagem para o Email: " + message);
	}
    
}
