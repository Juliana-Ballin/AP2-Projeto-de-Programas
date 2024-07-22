package jogo.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import jogo.persistencia.EquipeDAO;

public class ListaEquipe implements Serializable {
    private static final long serialVersionUID = 1692973258550795890L;
    private ArrayList<Equipe> equipes = new ArrayList<>();
    private static EquipeDAO equipeDAO = new EquipeDAO();

    public ArrayList<Equipe> getEquipes() {
        return this.equipes;
    }

    public void salvarEquipe(Equipe equipe) throws Exception {
        equipes.add(equipe);
        equipeDAO.salvar(this);
    }
}
