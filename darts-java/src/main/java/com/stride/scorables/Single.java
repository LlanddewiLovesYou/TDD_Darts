package com.stride.scorables;

public class Single implements Scorable {
    private int score;

    public Single(int bedValue) {
        if (bedValue < 1 || bedValue > 20) {
            throw new IllegalArgumentException("Throw bedScore must be in range 1..20");
        }
        this.score = bedValue;
    }

    public int bedScore() {
        return score;
    }
}
