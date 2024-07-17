package jogo.persistencia;

import jogo.negocio.personagens.Personagem;
import jogo.negocio.personagens.ListaPersonagens;
import java.io.*;

public class PersonagemDAO implements Persistencia<ListaPersonagens, Personagem> {
    private final String arquivo = "personagens.dat";

    @Override
    public void salvar(ListaPersonagens personagens) throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo))) {
        	System.out.println("Salvando...");
            out.writeObject(personagens);
            System.out.println("Salvo");
        }
    }

    @Override
    public Personagem recuperar(String nome) throws Exception {
        ListaPersonagens personagens = listar();
        for (int i = 0; i < personagens.getPersonagens().size(); i++) {
            if (personagens.getPersonagens().get(i).getNome().equals(nome)) {
                return personagens.getPersonagens().get(i);
            }
        }
        return null;
    }

	@Override
    public ListaPersonagens listar() throws Exception {
    	System.out.println("listando");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
        	System.out.println("Retornando valor");
            return (ListaPersonagens) in.readObject();
        } catch (FileNotFoundException e) {
            return new ListaPersonagens();
        }
    }
}
