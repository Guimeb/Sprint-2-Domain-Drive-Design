package models;

public class Scissors extends ForeignObj {
    public Scissors() {
        super("Tesoura", 2);
    }

    @Override
    public boolean attemptRemoval() {
        // Retirar com precisão: 50% de chance de sucesso
        return Math.random() < 0.5;
    }
}