package main.java.com.game.personagens;

public class Mago extends Personagem {

    public Mago() {
        super(150, 0.2); // Mago tem 150 de vida e 20% de chance de esquiva
    }

    @Override
    public int fornecerXP() {
        return 100; // Exemplo de XP fornecido pelo Mago
    }

    @Override
    public void atacar(Personagem oponente) {
        System.out.println("Mago conjurando magia!");
        if (arma != null) {
            golpear(oponente);
        }
    }
}
