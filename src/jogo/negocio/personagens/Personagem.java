package jogo.negocio.personagens;

import java.io.Serializable;

import jogo.negocio.HabilidadeEspecial;
import jogo.negocio.Inventario;

public abstract class Personagem implements HabilidadeEspecial<Personagem>, Serializable {
	private static final long serialVersionUID = 5189430522791887767L;
	protected String nome;
    protected int pontosVida;
    protected int pontosAtaque;
    protected int mana;
    protected Inventario inventario;

    public Personagem(String nome, int pontosVida, int pontosAtaque, int mana) {
        this.nome = nome;
        this.pontosVida = pontosVida;
        this.pontosAtaque = pontosAtaque;
        this.mana = mana;
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
    
    public int getMana() {
    	return mana;
    }

    public Inventario getInventario() {
        return inventario;
    }
    
    public abstract void usarHabilidade(Personagem alvo);
}
