package br.edu.ifsul.modelo;

import java.util.ArrayList;
import java.util.List;

public class FabricaObjeto {
    
    public static List<Pessoa> carregaPessoa() {
        List<Pessoa> lista = new ArrayList<>();
        Pessoa p = new Pessoa();
        p.setId(10);
        p.setNome("Carlos");
        p.setCpf("777.111.232-67");
        p.setTelefone("54991231400");
        p.setEmail("carlos@gmail.com");
        lista.add(p);
        return lista;
    }
    
}
