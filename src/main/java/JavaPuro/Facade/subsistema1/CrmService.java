package JavaPuro.Facade.subsistema1;

public class CrmService {

    private CrmService() {
        super();
    }

    public static void gravarClient(String nome, String cep, String estado, String cidade) {
        System.out.println("Client salvo no sistema de CRM.");
    }
}   
