package com.stride.scorable;

public class Triple implements Scorable {
    public static final int MULTIPLIER = 3;

    private int score;

    public Triple(int bedValue) {
        if (bedValue < 1 || bedValue > 20) {
            throw new IllegalArgumentException("Throw bedScore must be in range 1..20");
        }
        this.score = bedValue * MULTIPLIER;
    }

    public int bedScore() {
        return score;
    }
}
