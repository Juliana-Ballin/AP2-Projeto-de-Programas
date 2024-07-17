package jogo.iu;

import jogo.negocio.Equipe;
import jogo.negocio.ListaEquipe;
//import jogo.negocio.Inventario;
import jogo.negocio.Item;
import jogo.negocio.personagens.*;
//import jogo.persistencia.EquipeDAO;
import jogo.persistencia.PersonagemDAO;
import java.util.Scanner;

public class ConsoleInterface {
    private static PersonagemDAO personagemDAO = new PersonagemDAO();
//    private static EquipeDAO equipeDAO = new EquipeDAO();
    private static Scanner scanner = new Scanner(System.in);
    private static ListaPersonagens listaPersonagens = new ListaPersonagens();
    private static ListaEquipe listaEquipes = new ListaEquipe();


    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Criar Personagem");
            System.out.println("2. Adicionar Item ao Inventário");
            System.out.println("3. Formar Equipe");
            System.out.println("4. Realizar Combate");
            System.out.println("5. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            try {
                switch (opcao) {
                    case 1:
                        criarPersonagem();
                        break;
                    case 2:
                        adicionarItemInventario();
                        break;
                    case 3:
                        formarEquipe();
                        break;
                    case 4:
                        realizarCombate();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private static void criarPersonagem() throws Exception {
        System.out.println("Digite o nome do personagem:");
        String nome = scanner.nextLine();
        System.out.println("Digite os pontos de vida:");
        int pontosVida = scanner.nextInt();
        System.out.println("Digite os pontos de ataque:");
        int pontosAtaque = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        System.out.println("Escolha a classe do personagem:");
        System.out.println("1. Guerreiro");
        System.out.println("2. Mago");
        System.out.println("3. Arqueiro");
        int classe = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        Personagem personagem = null;
        switch (classe) {
            case 1:
                personagem = new Guerreiro(nome, pontosVida, pontosAtaque);
                break;
            case 2:
                personagem = new Mago(nome, pontosVida, pontosAtaque);
                break;
            case 3:
                personagem = new Arqueiro(nome, pontosVida, pontosAtaque);
                break;
            default:
                System.out.println("Classe inválida.");
                return;
        }

        System.out.println("Salvando personagem");
		listaPersonagens.salvarPersonagem(personagem);
        System.out.println("Personagem criado com sucesso!");
    }

    private static void adicionarItemInventario() throws Exception {
        System.out.println("Digite o nome do personagem:");
        String nome = scanner.nextLine();
        Personagem personagem = personagemDAO.recuperar(nome);
        if (personagem == null) {
            System.out.println("Personagem não encontrado.");
            return;
        }

        System.out.println("Digite o nome do item:");
        String nomeItem = scanner.nextLine();
        Item item = new Item(nomeItem);
        personagem.getInventario().adicionarItem(item);
//        personagemDAO.salvar(listapersonagens);

        System.out.println("Item adicionado ao inventário!");
    }

    private static void formarEquipe() throws Exception {
        Equipe equipe = new Equipe();
        System.out.println("Digite o número de personagens na equipe:");
        int numPersonagens = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        for (int i = 0; i < numPersonagens; i++) {
            System.out.println("Digite o nome do personagem " + (i + 1) + ":");
            String nome = scanner.nextLine();
            Personagem personagem = personagemDAO.recuperar(nome);
            if (personagem == null) {
                System.out.println("Personagem não encontrado.");
                i--;
            } else {
                equipe.adicionarPersonagem(personagem);
            }
        }

        listaEquipes.salvarEquipe(equipe);
        System.out.println("Equipe formada com sucesso!");
    }

    private static void realizarCombate() throws Exception {
        System.out.println("Digite o nome do primeiro personagem:");
        String nome1 = scanner.nextLine();
        Personagem personagem1 = personagemDAO.recuperar(nome1);
        if (personagem1 == null) {
            System.out.println("Personagem não encontrado.");
            return;
        }

        System.out.println("Digite o nome do segundo personagem:");
        String nome2 = scanner.nextLine();
        Personagem personagem2 = personagemDAO.recuperar(nome2);
        if (personagem2 == null) {
            System.out.println("Personagem não encontrado.");
            return;
        }

        while (personagem1.getPontosVida() > 0 && personagem2.getPontosVida() > 0) {
            personagem1.atacar(personagem2);
            if (personagem2.getPontosVida() <= 0) {
                System.out.println(personagem1.getNome() + " venceu!");
                return;
            }

            personagem2.atacar(personagem1);
            if (personagem1.getPontosVida() <= 0) {
                System.out.println(personagem2.getNome() + " venceu!");
                return;
            }
        }
    }
}
