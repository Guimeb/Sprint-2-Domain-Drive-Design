package models;

public class Glass extends ForeignObj {
    public Glass() {
        super("Vidro", 1);
    }

    @Override //Alteando as chances de remoção
    public boolean attemptRemoval() {
        return Math.random() < 0.7;
    }
}
