package com.stride.models;

public class ThrowDouble implements Scorable {
    public static final int MULTIPLIER = 2;

    private int score;

    public ThrowDouble(int score) {
        if (score < 1 || score > 20) {
            throw new IllegalArgumentException("Throw score must be in range 1..20");
        }
        this.score = score * MULTIPLIER;
    }

    public int score() {
        return score;
    }
}