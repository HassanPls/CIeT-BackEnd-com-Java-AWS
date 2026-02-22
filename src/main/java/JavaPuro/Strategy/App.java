package JavaPuro.Strategy;

public class App {
    public static void main(String[] args) {
        Comportamento normal = new ComportamentoNormal();
        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento ofensivo = new ComportamentoOfensivo();
        Robo robo = new Robo();
        robo.setComportamento(normal);
        robo.mover();

        System.out.println("===========");

        robo.setComportamento(defensivo);
        robo.mover();

        System.out.println("============");

        robo.setComportamento(ofensivo);
        robo.mover();
    }
}
