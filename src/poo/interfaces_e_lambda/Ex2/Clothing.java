package poo.interfaces_e_lambda.Ex2;

public record Clothing(double price) implements Tribute {

	@Override
	public double getTribute() {
        return price * 0.025;
	}
    
}
