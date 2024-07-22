package jogo.persistencia;

import jogo.negocio.personagens.Personagem;
import jogo.negocio.ListaEquipe;
import jogo.negocio.Equipe;

import java.io.*;

public class EquipeDAO implements Persistencia<ListaEquipe, Equipe> {
    private final String arquivo = "equipes.dat";

    @Override
     public void salvar(ListaEquipe equipes) throws Exception {
    	try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo))) {
    		System.out.println("...");
            out.writeObject(equipes);
    	}
    }

    @Override
    public Equipe recuperar(String nome) throws Exception {
        ListaEquipe equipes = listar();
        for (Equipe equipe : equipes.getEquipes()) {
            // Primeiro personagem da equipe como identificador
            for (Personagem personagem : equipe.getPersonagens()) {
                if (personagem.getNome().equalsIgnoreCase(nome)) {
                    return equipe;
                }
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
