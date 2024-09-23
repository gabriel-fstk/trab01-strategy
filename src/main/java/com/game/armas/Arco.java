package main.java.com.game.armas;

public class Arco implements Arma {
    private int dano;
    private double precisao;
    private double critico;

    public Arco() {
        this.dano = 12;
        this.precisao = 0.85; // Boa precisão
        this.critico = 0.2; // 20% de chance de crítico
    }

    @Override
    public void usarArma() {
        System.out.println("Lutando com um arco!");
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
        dano += 4; // Aumenta o dano em 4 a cada nível
        critico += 0.04; // Aumenta a chance de crítico em 4%
        System.out.println("O arco foi aprimorado! Dano: " + dano + ", Crítico: " + critico);
    }
}
