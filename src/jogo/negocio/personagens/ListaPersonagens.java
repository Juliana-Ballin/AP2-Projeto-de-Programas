package jogo.negocio.personagens;

import java.io.Serializable;
import java.util.ArrayList;

import jogo.persistencia.PersonagemDAO;

public class ListaPersonagens implements Serializable {
	private static final long serialVersionUID = 3308306968453549378L;

	private ArrayList<Personagem> personagens = new ArrayList<Personagem>();
	
	private static PersonagemDAO personagemDAO = new PersonagemDAO();
	
	public ArrayList<Personagem> getPersonagens(){
		return this.personagens;
	}
	
	public void salvarPersonagem(Personagem personagem) throws Exception {
		personagens.add(personagem);
		personagemDAO.salvar(this);
	}
}
