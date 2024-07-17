package jogo.persistencia;

public interface Persistencia<T, G> {
    void salvar(T t) throws Exception;
    G recuperar(String nome) throws Exception;
    T listar() throws Exception;
}
