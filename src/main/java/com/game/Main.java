package main.java.com.game;

import java.util.Scanner;

import main.java.com.game.modos.DuelTower;
import main.java.com.game.modos.Farming;
import main.java.com.game.personagens.Arqueiro;
import main.java.com.game.personagens.Guerreiro;
import main.java.com.game.personagens.Mago;
import main.java.com.game.personagens.Personagem;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Escolha de classe do personagem
        System.out.println("Escolha sua classe:");
        System.out.println("1 - Guerreiro");
        System.out.println("2 - Mago");
        System.out.println("3 - Arqueiro");

        int escolhaClasse = scanner.nextInt();
        Personagem jogador;

        switch (escolhaClasse) {
            case 1:
                jogador = new Guerreiro();
                break;
            case 2:
                jogador = new Mago();
                break;
            case 3:
                jogador = new Arqueiro();
                break;
            default:
                System.out.println("Escolha invalida! Guerreiro sera a classe padrao.");
                jogador = new Guerreiro();
                break;
        }

        // Escolha da arma inicial
        jogador.escolherArma();

        // Contadores de estatísticas
        int totalMonstrosMortos = 0;
        int farmingConcluido = 0;
        int duelTowerConcluido = 0;

        // Loop de escolha de modos de jogo
        boolean jogando = true;

        while (jogando) {
            System.out.println("\nEscolha o modo de jogo:");
            System.out.println("1 - Farming");
            System.out.println("2 - DuelTower");
            System.out.println("3 - Trocar Arma");
            System.out.println("4 - Sair e exibir estatisticas");

            if (scanner.hasNextInt()) {
                int escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        // Modo Farming
                        System.out.println("Quantos monstros deseja enfrentar no Farming?");
                        int numMonstros = scanner.nextInt();
                        Farming farming = new Farming(jogador);
                        farming.iniciarFarming(numMonstros);

                        // Atualizar estatísticas
                        totalMonstrosMortos += numMonstros;
                        farmingConcluido++;
                        break;

                    case 2:
                        // Modo DuelTower
                        System.out.println("Escolha a dificuldade da DuelTower:");
                        System.out.println("1 - Fácil");
                        System.out.println("2 - Normal");
                        System.out.println("3 - Difícil");
                        System.out.println("4 - Impossível");

                        int dificuldade = scanner.nextInt();
                        String dificuldadeStr = "";

                        switch (dificuldade) {
                            case 1: dificuldadeStr = "facil"; break;
                            case 2: dificuldadeStr = "normal"; break;
                            case 3: dificuldadeStr = "dificil"; break;
                            case 4: dificuldadeStr = "impossivel"; break;
                            default:
                                System.out.println("Escolha invalida. DuelTower será jogada no modo normal.");
                                dificuldadeStr = "normal";
                                break;
                        }

                        DuelTower duelTower = new DuelTower(jogador);
                        duelTower.iniciarDuelTower(dificuldadeStr);

                        // Atualizar estatísticas
                        duelTowerConcluido++;
                        break;

                    case 3:
                        // Trocar arma durante a execução
                        jogador.escolherArma();
                        break;

                    case 4:
                        // Encerrar o jogo e exibir as estatísticas finais
                        jogando = false;
                        System.out.println("\nEstatisticas finais do jogo:");
                        System.out.println("Total de monstros mortos: " + totalMonstrosMortos);
                        System.out.println("Modos Farming concluídos: " + farmingConcluido);
                        System.out.println("Modos DuelTower concluídos: " + duelTowerConcluido);
                        break;

                    default:
                        System.out.println("Escolha invalida! Tente novamente.");
                        break;
                }
            } else {
                System.out.println("Entrada invalida! Tente novamente.");
                scanner.next(); // Limpa a entrada inválida
            }
        }

        scanner.close();
    }
}
