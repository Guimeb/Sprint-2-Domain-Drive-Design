package models;

public class Needle extends ForeignObj {
    public Needle() {
        super("Agulha", 4);
    }

    @Override //Alteando as chances de remoção
    public boolean attemptRemoval() {
        return Math.random() < 0.8;
    }
}