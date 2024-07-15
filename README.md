# AP2-Projeto-de-Programas

## Descrição:
Desafio de Programação em Java: Desenvolvimento de um Jogo de RPG
Você deve desenvolver um jogo de RPG (Role-Playing Game) em Java que implemente os seguintes requisitos. Cada requisito vale 1 ponto.Requisitos:
Implemente uma arquitetura em camadas separando a aplicação em pelo menos três camadas: apresentação, lógica de jogo e persistência.
Crie uma classe abstrata Personagem que contenha os atributos comuns como nome, pontos de vida e pontos de ataque. Inclua pelo menos um método abstrato atacar.
Crie classes que herdem de Personagem, como Guerreiro, Mago e Arqueiro, implementando o método abstrato atacar.
Crie uma interface HabilidadeEspecial com métodos usarHabilidade. As classes que representam personagens devem implementar esta interface para suas habilidades especiais.
Implemente o polimorfismo no método atacar, onde cada classe derivada de Personagem deve fornecer uma implementação específica deste método.
Crie uma classe Inventario que contenha uma lista de itens (use composição). A classe Personagem deve ter um objeto Inventario.
Crie uma classe Equipe que possua uma lista de personagens (agregação). Os personagens devem ser do tipo Personagem.
Implemente o tratamento de exceções para situações como tentar usar uma habilidade especial sem energia suficiente ou tentar adicionar itens duplicados no inventário.
Implemente uma camada de persistência que permita salvar e recuperar os dados dos personagens e da equipe em arquivos.
Implemente uma interface de console (linha de comando) que permita ao usuário criar personagens, adicionar itens ao inventário, formar equipes e realizar combates.

## Alunos:
- Juliana Ballin Lima - 2315310011 - jbl.snf23@uea.edu.br;
- Marcelo Heitor de Almeida Lira - mhdal.snf23@uea.edu.br 
