package jogo.persistencia;

import jogo.negocio.ListaEquipe;
import jogo.negocio.Equipe;

import java.io.*;

public class EquipeDAO implements Persistencia<ListaEquipe, Equipe> {
    private final String arquivo = "equipes.dat";

    @Override
     public void salvar(ListaEquipe equipes) throws Exception {
    	try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo))) {
    		System.out.println("Salvando...");
            out.writeObject(equipes);
    	}
    }

    @Override
    public Equipe recuperar(String nome) throws Exception {
        ListaEquipe equipes = listar();
        for (int i = 0; i < equipes.getEquipes().size(); i++) {
            // Primeiro personagem da equipe como identificador
            if (equipes.getEquipes().get(i).getPersonagens().get(i).getNome().equals(nome)) {
                return equipes.getEquipes().get(i);
            }
        }
        return null;
    }

    @Override
    public ListaEquipe listar() throws Exception {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (ListaEquipe) in.readObject();
        } catch (FileNotFoundException e) {
            return new ListaEquipe();
        }
    }
}
