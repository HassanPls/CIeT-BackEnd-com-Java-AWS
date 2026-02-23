package poo.interfaces_e_lambda.Ex3;

public record Rectangle(double height, double base) implements GeometricForm {

    @Override
    public double getArea() {
        return base * height;
    }

}
