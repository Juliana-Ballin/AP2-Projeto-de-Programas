package jogo.negocio.personagens;

public class Guerreiro extends Personagem {

	private static final long serialVersionUID = 6068439488695556121L;

	public Guerreiro(String nome, int pontosVida, int pontosAtaque, int mana) {
        super(nome, pontosVida, pontosAtaque, mana);
        System.out.println("Guerreiro criado");
    }

    @Override
    public void atacar(Personagem alvo) {
        // Ataque do Guerreiro
        System.out.println(nome + " ataca " + alvo.getNome() + " com uma espada!");
        alvo.setPontosVida(alvo.getPontosVida() - pontosAtaque);
    }

    @Override
    public void usarHabilidade(Personagem alvo) throws Exception {
        if (mana > 20) {
            System.out.println(nome + " usa sua habilidade especial: Fúria do Guerreiro!");
            alvo.setPontosVida(alvo.getPontosVida() - (pontosAtaque + 50));
            mana -= 20;
        } else {
            throw new Exception("Mana insuficiente!");
        }
    }
}