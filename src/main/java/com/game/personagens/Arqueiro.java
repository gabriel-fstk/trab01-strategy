package main.java.com.game.personagens;


public class Arqueiro extends Personagem {

    public Arqueiro() {
        super(175, 0.3); // Arqueiro tem 175 de vida e 30% de chance de esquiva
    }

    @Override
    public int fornecerXP() {
        return 120; // Exemplo de XP fornecido pelo Arqueiro
    }

    @Override
    public void atacar(Personagem oponente) {
        System.out.println("Arqueiro disparando uma flecha!");
        if (arma != null) {
            golpear(oponente);
        }
    }
}


