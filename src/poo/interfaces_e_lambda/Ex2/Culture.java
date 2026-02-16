package poo.interfaces_e_lambda.Ex2;

public record Culture(double price) implements Tribute {

	@Override
	public double getTribute() {
        return price * 0.04;
	}
    
}
