package poo.interfaces_e_lambda.Ex3;

public record Square(double side) implements GeometricForm {

	@Override
	public double getArea() {
		return side * side;
	}
    
}
