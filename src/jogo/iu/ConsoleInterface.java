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
        	System.out.println("\nEPIC GAME");
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
        System.out.println("Digite a mana:");
        int mana = scanner.nextInt();
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
                personagem = new Guerreiro(nome, pontosVida, pontosAtaque, mana);
                break;
            case 2:
                personagem = new Mago(nome, pontosVida, pontosAtaque, mana);
                break;
            case 3:
                personagem = new Arqueiro(nome, pontosVida, pontosAtaque, mana);
                break;
            default:
                System.out.println("Classe inválida.");
                return;
        }

		listaPersonagens.salvarPersonagem(personagem);
        System.out.println("Personagem criado com sucesso!");
    }

    private static void adicionarItemInventario() {
        System.out.println("Digite o nome do personagem:");
        String nome = scanner.nextLine();
        Personagem personagem = null;

        try {
            personagem = personagemDAO.recuperar(nome);
            if (personagem == null) {
                System.out.println("Personagem não encontrado.");
                return;
            }
        } catch (Exception e) {
            System.out.println("Erro ao recuperar o personagem: " + e.getMessage());
            return;
        }

        System.out.println("Digite o nome do item:");
        String nomeItem = scanner.nextLine();
        Item item = new Item(nomeItem);

        try {
            personagem.getInventario().adicionarItem(item);
            System.out.println("Item adicionado ao inventário!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar item: " + e.getMessage());
        }
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
            System.out.println(personagem1.getNome() + " está escolhendo um ataque:");
            System.out.println("1. Ataque normal");
            System.out.println("2. Habilidade especial");
            int tipo_ataque = scanner.nextInt();
            scanner.nextLine(); // Consumindo linha

            try {
                switch (tipo_ataque) {
                    case 1:
                        personagem1.atacar(personagem2);
                        if(personagem2.getPontosVida() > 0) {
                            System.out.println(personagem2.getNome() + " está com " + personagem2.getPontosVida() + " pontos de vida!");
                        }
                        break;
                    case 2:
                        personagem1.usarHabilidade(personagem2);
                        if(personagem2.getPontosVida() > 0) {
                            System.out.println(personagem2.getNome() + " está com " + personagem2.getPontosVida() + " pontos de vida!");
                        }
                        break;
                    default:
                        System.out.println("Ataque inválido");
                        return;
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                return;
            }

            if (personagem2.getPontosVida() <= 0) {
                System.out.println(personagem2.getNome() + " morreu!");
                System.out.println(personagem1.getNome() + " venceu!");
                return;
            }

            System.out.println(personagem2.getNome() + " está escolhendo um ataque:");
            System.out.println("1. Ataque normal");
            System.out.println("2. Habilidade especial");
            int tipo_ataque2 = scanner.nextInt();
            scanner.nextLine(); // Consumindo linha

            try {
                switch (tipo_ataque2) {
                    case 1:
                        personagem2.atacar(personagem1);
                        if(personagem1.getPontosVida() > 0) {
                            System.out.println(personagem1.getNome() + " está com " + personagem1.getPontosVida() + " pontos de vida!");
                        }
                        break;
                    case 2:
                        personagem2.usarHabilidade(personagem1);
                        if(personagem1.getPontosVida() > 0) {
                            System.out.println(personagem1.getNome() + " está com " + personagem1.getPontosVida() + " pontos de vida!");
                        }
                        break;
                    default:
                        System.out.println("Ataque inválido");
                        return;
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                return;
            }

            if (personagem1.getPontosVida() <= 0) {
                System.out.println(personagem1.getNome() + " morreu!");
                System.out.println(personagem2.getNome() + " venceu!");
                return;
            }
        }
    }
}