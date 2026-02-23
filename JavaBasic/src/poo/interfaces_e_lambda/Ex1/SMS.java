package poo.interfaces_e_lambda.Ex1;

public record SMS(String message) implements Service {

	@Override
	public void sendMessage() {
		System.out.println("Enviando a seguinte mensagem para o SMS: " + message);
	}
    
}
