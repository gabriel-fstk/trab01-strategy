package main.java.com.game.modos;

import main.java.com.game.monstros.Monstro;
import main.java.com.game.personagens.Personagem;

import java.util.Random;

public class Farming {
    private Personagem jogador;

    public Farming(Personagem jogador) {
        this.jogador = jogador;
    }

    public void iniciarFarming(int numMonstros) {
        Random random = new Random();
        jogador.restaurarVida();
        for (int i = 1; i <= numMonstros; i++) {
            System.out.println("Enfrentando o monstro " + i);
            Monstro monstro = new Monstro(random.nextInt(jogador.getNivel()) + 1); // Gera um monstro com nível aleatório baseado no jogador
            lutarContraMonstro(monstro);
        }

        System.out.println("Nivel atual: " + jogador.getNivel());
        System.out.println("Experiencia faltando para o proximo nivel: " + jogador.getExperienciaFaltando());
    }
    private void lutarContraMonstro(Monstro monstro) {
        while (jogador.estaVivo() && monstro.estaVivo()) {
            jogador.golpear(monstro);
            if (monstro.estaVivo()) {
                monstro.golpear(jogador);
            }
        }
    
        if (!monstro.estaVivo()) {
            jogador.ganharXP(monstro.fornecerXP());
            jogador.restaurarVida();
            System.out.println("Voce derrotou o monstro e ganhou " + monstro.fornecerXP() + " XP!");
        } else {
            System.out.println("Voce foi derrotado pelo monstro.");
        }
    }
    
}
