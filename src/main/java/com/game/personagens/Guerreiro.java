package main.java.com.game.personagens;


public class Guerreiro extends Personagem {

    public Guerreiro() {
        super(200, 0.1); // Guerreiro tem 200 de vida e 10% de chance de esquiva
    }

    @Override
    public int fornecerXP() {
        return 150; // Exemplo de XP fornecido pelo Guerreiro
    }

    @Override
    public void atacar(Personagem oponente) {
        System.out.println("Guerreiro atacando com força bruta!");
        if (arma != null) {
            golpear(oponente);
        }
    }
}

