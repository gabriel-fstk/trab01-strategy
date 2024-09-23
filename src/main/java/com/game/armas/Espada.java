package main.java.com.game.armas;

public class Espada implements Arma {
    private int dano;
    private double precisao;
    private double critico;

    public Espada() {
        this.dano = 15;
        this.precisao = 0.8;
        this.critico = 0.1; // 10% de chance de crítico
    }

    @Override
    public void usarArma() {
        System.out.println("Lutando com uma espada!");
    }

    @Override
    public double getPrecisao() {
        return precisao;
    }

    @Override
    public int getDano() {
        return dano;
    }

    @Override
    public double getCritico() {
        return critico;
    }

    @Override
    public void aprimorar() {
        dano += 5; // Aumenta o dano em 5 a cada nível
        critico += 0.05; // Aumenta a chance de crítico em 5%
        System.out.println("A espada foi aprimorada! Dano: " + dano + ", Critico: " + critico);
    }
}

