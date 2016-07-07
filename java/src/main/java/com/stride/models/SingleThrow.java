package com.stride.models;

public class SingleThrow {
    private int score;

    public SingleThrow(int score) {
        if (score < 1 || score > 20) {
            throw new IllegalArgumentException("Throw score must be in range 1..20");
        }
        this.score = score;
    }

    public int score() {
        return score;
    }
}
