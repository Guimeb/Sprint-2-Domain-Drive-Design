package models;

public class Knife extends ForeignObj {
    public Knife() {
        super("Faca", 3);
    }

    @Override
    public boolean attemptRemoval() {
        // Retirar com força: 60% de chance de sucesso
        return Math.random() < 0.6;
    }
}