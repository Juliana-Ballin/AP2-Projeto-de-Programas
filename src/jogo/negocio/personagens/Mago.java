package jogo.negocio.personagens;

public class Mago extends Personagem {

    private static final long serialVersionUID = 7283492658013210645L;

	public Mago(String nome, int pontosVida, int pontosAtaque, int mana) {
        super(nome, pontosVida, pontosAtaque, mana);
    }

    @Override
    public void atacar(Personagem alvo) {
        // Ataque do Mago
        System.out.println(nome + " ataca " + alvo.getNome() + " com uma bola de fogo!");
        alvo.setPontosVida(alvo.getPontosVida() - pontosAtaque);
    }

    @Override
    public void usarHabilidade(Personagem alvo) throws Exception {
        if (mana > 50) {
            System.out.println(nome + " usa sua habilidade especial: Explosão Arcana!");
            alvo.setPontosVida(alvo.getPontosVida() - (pontosAtaque + 50));
            mana -= 50;
        } else {
            throw new Exception("Mana insuficiente!");
        }
    }
}