package com.stride;

public class Score {
    private int tally = 501;

    public int score() {
        return tally;
    }

    public void launch(String first, String second) {
        int score = extractScore(first) + extractScore(second);
        this.tally -= score;
    }

    private int extractScore(String value) {
        if ("MISS".equals(value)) {
            return 0;
        }
        return Integer.parseInt(value.substring(1));
    }
}
