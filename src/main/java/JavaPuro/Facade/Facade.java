package JavaPuro.Facade;

import JavaPuro.Facade.subsistema1.CrmService;
import JavaPuro.Facade.subsistema2.CepService;

public class Facade {
    public void migrarClient(String nome, String cep) {
        CepService cepService = CepService.getInstancia();
        String estado = cepService.recuperarEstado(cep);
        String cidade = cepService.recuperarCidade(cep);
        CrmService.gravarClient(nome, cep, estado, cidade);
    }
}
