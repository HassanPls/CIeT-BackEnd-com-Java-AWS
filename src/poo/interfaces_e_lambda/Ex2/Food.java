package poo.interfaces_e_lambda.Ex2;

public record Food(double price) implements Tribute {

	@Override
	public double getTribute() {
        return price * 0.01;
	}
    
}
