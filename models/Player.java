package models;

public class Player {
    private String nome;
    private Score score;
    private Timer timer;

    public Player(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public Score getScore() {
        return this.score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Timer getTimer() {
        return this.timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}