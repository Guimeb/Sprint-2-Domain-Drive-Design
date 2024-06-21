package models;

public class Knife extends ForeignObj {
    public Knife() {
        super("Faca", 3);
    }

    @Override //Alteando as chances de remoção
    public boolean attemptRemoval() {
        return Math.random() < 0.6;
    }
}