package models;

public class Score {
    private int score;

    public Score() {
        this.score = 0;
    }

    public void incrementScore() {
        this.score++;
    }

    public void decrementScore() {
        if (this.score > 0) {
            this.score--;
        }
    }

    //Getter e setter
    public int getScore() {
        return this.score;
    }
}
