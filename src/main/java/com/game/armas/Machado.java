package main.java.com.game.armas;

public class Machado implements Arma {
    private int dano;
    private double precisao;
    private double critico;

    public Machado() {
        this.dano = 20;
        this.precisao = 0.75; // Menos preciso que outras armas
        this.critico = 0.1; // 10% de chance de crítico
    }

    @Override
    public void usarArma() {
        System.out.println("Lutando com um machado!");
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
        dano += 6; // Aumenta o dano em 6 a cada nível
        critico += 0.02; // Aumenta a chance de crítico em 2%
        System.out.println("O machado foi aprimorado! Dano: " + dano + ", Critico: " + critico);
    }
}
