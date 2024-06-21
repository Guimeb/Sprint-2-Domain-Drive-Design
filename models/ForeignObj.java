package models;

public abstract class ForeignObj {
    private String itemType;
    private int difficulty;
    private boolean stuck;

    public ForeignObj(String itemType, int difficulty) {
        this.itemType = itemType;
        this.difficulty = difficulty;
        this.stuck = true; // Por padrão, o objeto é inicialmente considerado preso
    }

    // Getters e setters
    public String getItemType() {
        return itemType;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public boolean isStuck() {
        return stuck;
    }

    public void setStuck(boolean stuck) {
        this.stuck = stuck;
    }

    // Método abstrato para tentativa de remoção
    public abstract boolean attemptRemoval();
}
