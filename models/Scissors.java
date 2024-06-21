package models;

public class Scissors extends ForeignObj {
    public Scissors() {
        super("Tesoura", 2);
    }

    @Override //Alteando as chances de remoção
    public boolean attemptRemoval() {
        return Math.random() < 0.5;
    }
}