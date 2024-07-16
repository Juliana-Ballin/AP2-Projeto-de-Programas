package jogo.persistencia;

import jogo.negocio.Equipe;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EquipeDAO implements Persistencia<Equipe> {
    private final String arquivo = "equipes.dat";

    @Override
    public void salvar(Equipe equipe) throws Exception {
        List<Equipe> equipes = listar();
        equipes.add(equipe);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            out.writeObject(equipes);
        }
    }

    @Override
    public Equipe recuperar(String nome) throws Exception {
        List<Equipe> equipes = listar();
        for (Equipe equipe : equipes) {
            // Primeiro personagem da equipe como identificador
            if (equipe.getPersonagens().get(0).getNome().equals(nome)) {
                return equipe;
            }
        }
        return null;
    }

    @Override
    public List<Equipe> listar() throws Exception {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<Equipe>) in.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
