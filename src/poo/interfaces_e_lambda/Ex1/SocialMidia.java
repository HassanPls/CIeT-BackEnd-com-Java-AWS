package poo.interfaces_e_lambda.Ex1;

public record SocialMidia(String message) implements Service {

	@Override
	public void sendMessage() {
		System.out.println("Enviando a seguinte mensagem para as Redes Sociais: " + message);
	}
    
}
