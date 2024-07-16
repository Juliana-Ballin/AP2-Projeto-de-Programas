package jogo.negocio.personagens;

public class Guerreiro extends Personagem {

    public Guerreiro(String nome, int pontosVida, int pontosAtaque) {
        super(nome, pontosVida, pontosAtaque);
    }

    @Override
    public void atacar(Personagem alvo) {
        // Ataque do Guerreiro
        System.out.println(nome + " ataca " + alvo.getNome() + " com uma espada!");
        alvo.setPontosVida(alvo.getPontosVida() - pontosAtaque);
    }

    @Override
    public void usarHabilidade() {
        // Habilidade especial do Guerreiro
        System.out.println(nome + " usa sua habilidade especial: Fúria do Guerreiro!");
    }
}
