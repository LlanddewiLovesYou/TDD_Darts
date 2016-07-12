package com.stride.scorables;

public class Single implements Scorable {
    private int score;

    public Single(int score) {
        if (score < 1 || score > 20) {
            throw new IllegalArgumentException("Throw score must be in range 1..20");
        }
        this.score = score;
    }

    public int score() {
        return score;
    }
}
