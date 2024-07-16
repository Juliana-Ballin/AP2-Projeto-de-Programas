package jogo.negocio.personagens;

import jogo.negocio.HabilidadeEspecial;
import jogo.negocio.Inventario;

public abstract class Personagem implements HabilidadeEspecial {
    protected String nome;
    protected int pontosVida;
    protected int pontosAtaque;
    protected Inventario inventario;

    public Personagem(String nome, int pontosVida, int pontosAtaque) {
        this.nome = nome;
        this.pontosVida = pontosVida;
        this.pontosAtaque = pontosAtaque;
        this.inventario = new Inventario();
    }

    public abstract void atacar(Personagem alvo);

    public String getNome() {
        return nome;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    public int getPontosAtaque() {
        return pontosAtaque;
    }

    public Inventario getInventario() {
        return inventario;
    }
}
