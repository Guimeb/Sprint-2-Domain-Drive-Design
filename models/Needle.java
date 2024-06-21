package models;

public class Needle extends ForeignObj {
    public Needle() {
        super("Agulha", 4);
    }

    @Override
    public boolean attemptRemoval() {
        // Retirar com delicadeza: 80% de chance de sucesso
        return Math.random() < 0.8;
    }
}