package JavaPuro.Strategy;

public class ComportamentoOfensivo implements Comportamento{

    @Override
    public void mover() {
        System.out.println("Movendo-se ofensivamente");
    }

}
