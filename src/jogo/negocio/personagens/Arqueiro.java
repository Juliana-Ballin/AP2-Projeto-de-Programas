package jogo.negocio.personagens;

public class Arqueiro extends Personagem {

    private static final long serialVersionUID = 4617393080081456939L;

	public Arqueiro(String nome, int pontosVida, int pontosAtaque, int mana) {
        super(nome, pontosVida, pontosAtaque, mana);
    }

    @Override
    public void atacar(Personagem alvo) {
        // Ataque do Arqueiro
        System.out.println(nome + " ataca " + alvo.getNome() + " com uma flecha!");
        alvo.setPontosVida(alvo.getPontosVida() - pontosAtaque);
    }

	@Override
	public void usarHabilidade(Personagem alvo) {
		// Habilidade especial do Arqueiro
		if(mana > 35) {
			System.out.println(nome + " usa sua habilidade especial: Chuva de Flechas!");
	        alvo.setPontosVida(alvo.getPontosVida() - (pontosAtaque + 50));
	        mana -= 35;
		} else {
			System.out.println("Mana insuficiente!");
		}
	}
}
