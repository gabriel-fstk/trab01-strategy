package main.java.com.game.armas;

public class Faca implements Arma {
    private int dano;
    private double precisao;
    private double critico;

    public Faca() {
        this.dano = 10;
        this.precisao = 0.9; // Alta precis�o
        this.critico = 0.15; // 15% de chance de cr�tico
    }

    @Override
    public void usarArma() {
        System.out.println("Lutando com uma faca!");
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
        dano += 3; // Aumenta o dano em 3 a cada n�vel
        critico += 0.03; // Aumenta a chance de cr�tico em 3%
        System.out.println("A faca foi aprimorada! Dano: " + dano + ", Critico: " + critico);
    }
}
