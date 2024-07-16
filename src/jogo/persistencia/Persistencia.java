package jogo.persistencia;

import java.util.List;

public interface Persistencia<T> {
    void salvar(T t) throws Exception;
    T recuperar(String nome) throws Exception;
    List<T> listar() throws Exception;
}
