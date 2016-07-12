package com.stride.models;

public class ThrowTriple implements Scorable {
    private static final int MULTIPLIER = 3;

    private int score;

    public ThrowTriple(int score) {
        if (score < 1 || score > 20) {
            throw new IllegalArgumentException("Throw score must be in range 1..20");
        }
        this.score = score * MULTIPLIER;
    }

    public int score() {
        return score;
    }
}
