package jogo.negocio;

public interface HabilidadeEspecial<T> {
    void usarHabilidade(T alvo) throws Exception;
}