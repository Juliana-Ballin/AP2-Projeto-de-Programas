package jogo.persistencia;

import jogo.negocio.personagens.Personagem;
import jogo.negocio.personagens.ListaPersonagens;
import java.io.*;

public class PersonagemDAO implements Persistencia<ListaPersonagens, Personagem> {
    private final String arquivo = "personagens.dat";

    @Override
    public void salvar(ListaPersonagens personagens) throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            out.writeObject(personagens);
        }
    }

    @Override
    public Personagem recuperar(String nome) throws Exception {
        ListaPersonagens personagens = listar();
        for (Personagem p : personagens.getPersonagens()) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public ListaPersonagens listar() throws Exception {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (ListaPersonagens) in.readObject();
        } catch (FileNotFoundException e) {
            return new ListaPersonagens();
        }
    }
}
