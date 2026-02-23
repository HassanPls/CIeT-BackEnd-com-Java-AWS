package JavaPuro.Facade.subsistema2;

public class CepService {
    private static CepService instancia = new CepService();

    private CepService() {
        super();
    }

    public static CepService getInstancia() {
        return instancia;
    }

    public String recuperarCidade(String cep) {
        return "São Paulo";
    }

    public String recuperarEstado(String cep) {
        return "SP";
    }
}
