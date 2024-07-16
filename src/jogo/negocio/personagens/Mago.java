package jogo.negocio.personagens;

public class Mago extends Personagem {

    public Mago(String nome, int pontosVida, int pontosAtaque) {
        super(nome, pontosVida, pontosAtaque);
    }

    @Override
    public void atacar(Personagem alvo) {
        // Ataque do Mago
        System.out.println(nome + " ataca " + alvo.getNome() + " com uma bola de fogo!");
        alvo.setPontosVida(alvo.getPontosVida() - pontosAtaque);
    }

    @Override
    public void usarHabilidade() {
        // Habilidade especial do Mago
        System.out.println(nome + " usa sua habilidade especial: Explosão Arcana!");
    }
}
