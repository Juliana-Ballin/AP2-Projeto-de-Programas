# AP2-Projeto-de-Programas

## Descrição:
Desafio de Programação em Java: 
Desenvolvimento de um Jogo de RPG
Você deve desenvolver um jogo de RPG (Role-Playing Game) em Java que implemente os seguintes requisitos. Cada requisito vale 1 ponto.
Requisitos:
1) Implemente uma arquitetura em camadas separando a aplicação em pelo menos três camadas: apresentação, lógica de jogo e persistência.
2) Crie uma classe abstrata Personagem que contenha os atributos comuns como nome, pontos de vida e pontos de ataque. Inclua pelo menos um método abstrato atacar.
3) Crie classes que herdem de Personagem, como Guerreiro, Mago e Arqueiro, implementando o método abstrato atacar.
4) Crie uma interface HabilidadeEspecial com métodos usarHabilidade. As classes que representam personagens devem implementar esta interface para suas habilidades especiais.
5) Implemente o polimorfismo no método atacar, onde cada classe derivada de Personagem deve fornecer uma implementação específica deste método.
6) Crie uma classe Inventario que contenha uma lista de itens (use composição). A classe Personagem deve ter um objeto Inventario.
7) Crie uma classe Equipe que possua uma lista de personagens (agregação). Os personagens devem ser do tipo Personagem.
8) Implemente o tratamento de exceções para situações como tentar usar uma habilidade especial sem energia suficiente ou tentar adicionar itens duplicados no inventário.
9) Implemente uma camada de persistência que permita salvar e recuperar os dados dos personagens e da equipe em arquivos.
10) Implemente uma interface de console (linha de comando) que permita ao usuário criar personagens, adicionar itens ao inventário, formar equipes e realizar combates.

## Alunos:
- Juliana Ballin Lima - 2315310011 - jbl.snf23@uea.edu.br;
- Marcelo Heitor de Almeida Lira - mhdal.snf23@uea.edu.br 
