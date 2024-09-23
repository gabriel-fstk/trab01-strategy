package main.java.com.game.personagens;

import main.java.com.game.armas.Arco;
import main.java.com.game.armas.Arma;
import main.java.com.game.armas.Espada;
import main.java.com.game.armas.Faca;
import main.java.com.game.armas.Machado;

import java.util.Random;
import java.util.Scanner;

public abstract class Personagem {
    protected Arma arma;
    protected int vida;
    protected int vidaMaxima;
    protected double chanceEsquiva;
    public int nivel;
    protected int xpAtual;
    protected int xpNecessario;
    protected double multiplicadorXP = 1.5;

    public Personagem(int vida, double chanceEsquiva) {
        this.vida = vida;
        this.vidaMaxima = vida;
        this.chanceEsquiva = chanceEsquiva;
        this.nivel = 1;
        this.xpAtual = 0;
        this.xpNecessario = 200; // XP necessário para passar do nível 1 ao 2
    }

    public int getNivel() {
        return nivel; // Método para retornar o nível do personagem
    }

    public int getExperienciaFaltando() {
        return xpNecessario - xpAtual; // Calcula a experiência faltando para o próximo nível
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void escolherArma() {
        
            System.out.println("Escolha sua nova arma: ");
            System.out.println("1 - Espada");
            System.out.println("2 - Faca");
            System.out.println("3 - Arco e Flecha");
            System.out.println("4 - Machado");

            Scanner scanner = new Scanner(System.in);   
            int escolhaArma = scanner.nextInt();
            Arma novaArma;

            switch (escolhaArma) {
                case 1:
                    novaArma = new Espada();
                    break;
                case 2:
                    novaArma = new Faca();
                    break;
                case 3:
                    novaArma = new Arco();
                    break;
                case 4:
                    novaArma = new Machado();
                    break;
                default:
                    System.out.println("Arma invalida, mantendo a arma atual.");
                    novaArma = new Espada();
                    return; 
            }

            setArma(novaArma);
            System.out.println(getClass().getSimpleName() + " agora esta usando " + novaArma.getClass().getSimpleName());

    }

    public void golpear(Personagem oponente) {
        if (arma == null) {
            System.out.println("Sem arma para atacar.");
            return;
        }

        Random random = new Random();
        double chanceAcerto = random.nextDouble();
        boolean golpeCritico = random.nextDouble() <= arma.getCritico();

        if (chanceAcerto <= arma.getPrecisao()) {
            if (oponente.esquivar()) {
                System.out.println(oponente.getClass().getSimpleName() + " esquivou do ataque!");
            } else {
                int dano = arma.getDano();
                if (golpeCritico) {
                    dano *= 2; // Dano crítico é o dobro
                    System.out.println("Golpe [CRITICAL]!");
                }
                oponente.receberDano(dano);
                System.out.println(oponente.getClass().getSimpleName() + " sofreu " + dano + " de dano!");
            }
        } else {
            System.out.println("O ataque errou!");
        }
    }

    public boolean esquivar() {
        Random random = new Random();
        double chance = random.nextDouble();
        return chance <= this.chanceEsquiva;
    }

    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida <= 0) {
            System.out.println(getClass().getSimpleName() + " foi derrotado!");
            this.vida = 0;
        } else {
            System.out.println(getClass().getSimpleName() + " tem agora " + this.vida + " de vida.");
        }
    }

    public void regenerarVida() {
        int regeneracao = (int) (vidaMaxima * 0.1); // 10% da vida máxima
        vida += regeneracao;
        
        if (vida > vidaMaxima) {
            vida = vidaMaxima;
        }
        
        System.out.println("Vida regenerada! Vida atual: " + vida);

    }

    public void restaurarVida() {
        vida = vidaMaxima;
        System.out.println("Vida restaurada para o maximo: " + vidaMaxima);
    }
    

    public boolean estaVivo() {
        return this.vida > 0;
    }

    // Ganha XP e verifica se o personagem sobe de nível
    public void ganharXP(int xpGanho) {
        this.xpAtual += xpGanho;
        System.out.println(this.getClass().getSimpleName() + " ganhou " + xpGanho + " de XP.");

        while (xpAtual >= xpNecessario) {
            subirDeNivel();
        }
    }

    // Sobe de nível, aprimora arma e aumenta o XP necessário para o próximo nível
    public void subirDeNivel() {
        this.nivel++;
        xpAtual -= xpNecessario;
        xpNecessario *= multiplicadorXP;
        System.out.println(this.getClass().getSimpleName() + " subiu para o nivel " + nivel + "!");

        // Aprimorar arma
        if (arma != null) {
            arma.aprimorar();
            System.out.println("Sua " + arma.getClass().getSimpleName() + " foi aprimorada!");
        }
    }

    public abstract void atacar(Personagem oponente);

    public abstract int fornecerXP();
}
