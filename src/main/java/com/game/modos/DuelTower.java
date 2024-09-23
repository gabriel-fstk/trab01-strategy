package main.java.com.game.modos;

import main.java.com.game.monstros.Monstro;
import main.java.com.game.personagens.Personagem;

import java.util.Random;

public class DuelTower {
    private int andarAtual;
    private Personagem jogador;

    public DuelTower(Personagem jogador) {
        this.jogador = jogador;
        this.andarAtual = 1;
    }

    public void iniciarDuelTower(String dificuldade) {
        System.out.println("Iniciando a DuelTower no modo " + dificuldade + "!");
        jogador.restaurarVida();

        while (andarAtual <= 10 && jogador.estaVivo()) {
            System.out.println("Subindo para o andar " + andarAtual + "!");
            Personagem oponente = criarOponente(dificuldade);
            lutar(oponente);

            if (jogador.estaVivo()) {
                andarAtual++;
            } else {
                System.out.println("Você foi derrotado na DuelTower.");
                break;
            }
        }

        if (jogador.estaVivo()) {
            System.out.println("Parabéns, você venceu a DuelTower!");
        }
    }

    private Personagem criarOponente(String dificuldade) {
        Random random = new Random();
        int nivelOponente = 1;

        switch (dificuldade.toLowerCase()) {
            case "facil":
                nivelOponente = random.nextInt(2) + 1; // Nível 1 ou 2
                break;
            case "normal":
                nivelOponente = random.nextInt(5) + 1; // Nível 1 a 5
                break;
            case "dificil":
                nivelOponente = jogador.nivel; // Mesmo nível do jogador
                break;
            case "impossivel":
                nivelOponente = jogador.nivel; // Mesmo nível e status
                // Poderíamos adicionar aqui status especiais, se necessário
                break;
        }

        return new Monstro(nivelOponente); // Um monstro como oponente, pode-se personalizar para outros personagens
    }

    private void lutar(Personagem oponente) {
        while (jogador.estaVivo() && oponente.estaVivo()) {
            jogador.golpear(oponente);
            if (oponente.estaVivo()) {
                oponente.golpear(jogador);
            }
        }
        if (oponente.estaVivo()) {
            System.out.println("O oponente venceu o duelo.");
        } else {
            System.out.println("Você venceu o duelo!");
            jogador.restaurarVida();
            jogador.ganharXP(oponente.fornecerXP());
        }
    }
}
