package models;


public class ForeignObj {
    private Type itemType;
    private int difficulty;
    private boolean stuck; // Variável para indicar se o objeto está preso ou não

    public enum Type {
        VIDRO(1),
        TESOURA(2),
        FACA(3);

        private final int difficultyLevel;

        Type(int difficultyLevel) {
            this.difficultyLevel = difficultyLevel;
        }

        public int getDifficultyLevel() {
            return difficultyLevel;
        }
    }

    public ForeignObj(Type itemType) {
        this.itemType = itemType;
        this.difficulty = itemType.getDifficultyLevel();
        this.stuck = true; // Por padrão, o objeto é inicialmente considerado preso
    }

    // Getters e setters
    public Type getItemType() {
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
}
