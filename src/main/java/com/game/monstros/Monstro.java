package main.java.com.game.monstros;

import main.java.com.game.personagens.Personagem;
import java.util.Random;

public class Monstro extends Personagem {
    public Monstro(int nivel) {
        super(100 + (nivel * 10), 0.1); // Exemplo de vida e chance de esquiva
        this.nivel = nivel; // Atribui o nível ao monstro
    }

    public int fornecerXP() {
        return nivel * 50; // Exemplo de XP que o monstro fornece
    }

    @Override
    public void atacar(Personagem oponente) {
        System.out.println("Monstro atacando!");
        golpear(oponente);
    }

    @Override
    public void golpear(Personagem oponente) {
        Random random = new Random();
        if (random.nextDouble() <= this.chanceEsquiva) {
            System.out.println("O monstro errou o ataque!");
        } else {
            int dano = 10; // Exemplo de dano do monstro
            oponente.receberDano(dano);
            System.out.println("O monstro causou " + dano + " de dano!");
        }
    }
}
