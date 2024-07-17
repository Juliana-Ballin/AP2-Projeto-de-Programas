package jogo.negocio.personagens;

public class Arqueiro extends Personagem {
    private static final long serialVersionUID = 4617393080081456939L;

    public Arqueiro(String nome, int pontosVida, int pontosAtaque) {
        super(nome, pontosVida, pontosAtaque);
    }

    @Override
    public void atacar(Personagem alvo) {
        // Ataque do Arqueiro
        System.out.println(nome + " ataca " + alvo.getNome() + " com uma flecha!");
        alvo.setPontosVida(alvo.getPontosVida() - pontosAtaque);
    }

    @Override
    public void usarHabilidade() {
        // Habilidade especial do Arqueiro
        System.out.println(nome + " usa sua habilidade especial: Chuva de Flechas!");
    }
}
