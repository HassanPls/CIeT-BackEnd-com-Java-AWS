package poo.interfaces_e_lambda.Ex2;

public record Health(double price) implements Tribute {

	@Override
	public double getTribute() {
        return price * 0.015;
	}
    
}
