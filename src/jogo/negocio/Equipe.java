package jogo.negocio;

import jogo.negocio.personagens.Personagem;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private List<Personagem> personagens;

    public Equipe() {
        this.personagens = new ArrayList<>();
    }

    public void adicionarPersonagem(Personagem personagem) {
        personagens.add(personagem);
    }

    public List<Personagem> getPersonagens() {
        return personagens;
    }
}
