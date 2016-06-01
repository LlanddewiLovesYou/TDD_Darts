package com.stride;

public class Score {
    private int tally = 501;

    public int score() {
        return tally;
    }

    public void launch(String first, String second) {
        if (!"MISS".equals(first)) {
            this.tally -= 8;
        }
        if (!"MISS".equals(second)) {
            this.tally = 491;
        }
    }
}
