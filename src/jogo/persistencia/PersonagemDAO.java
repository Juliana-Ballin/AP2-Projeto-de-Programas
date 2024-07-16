package jogo.persistencia;

import jogo.negocio.personagens.Personagem;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonagemDAO implements Persistencia<Personagem> {
    private final String arquivo = "personagens.dat";

    @Override
    public void salvar(Personagem personagem) throws Exception {
        List<Personagem> personagens = listar();
        personagens.add(personagem);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            out.writeObject(personagens);
        }
    }

    @Override
    public Personagem recuperar(String nome) throws Exception {
        List<Personagem> personagens = listar();
        for (Personagem personagem : personagens) {
            if (personagem.getNome().equals(nome)) {
                return personagem;
            }
        }
        return null;
    }

    @Override
    public List<Personagem> listar() throws Exception {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<Personagem>) in.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
