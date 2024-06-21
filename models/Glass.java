package models;

public class Glass extends ForeignObj {
    public Glass() {
        super("Vidro", 1);
    }

    @Override
    public boolean attemptRemoval() {
        // Retirar rápido: 70% de chance de sucesso
        return Math.random() < 0.7;
    }
}
