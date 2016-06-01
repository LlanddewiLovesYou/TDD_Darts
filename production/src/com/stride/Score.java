package com.stride;

public class Score {
    private int tally = 501;

    public int score() {
        return tally;
    }

    public void launch(String first) {
        int score = extractScore(first);
        this.tally -= score;
    }

    private int extractScore(String value) {
        return Integer.parseInt(value.substring(1));
    }
}
