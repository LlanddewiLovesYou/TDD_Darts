package com.stride;

public class Score {
    private int tally = 501;

    public int score() {
        return tally;
    }

    public void launch(String first, String second, String third) {
        if ("MISS".equals(first) && "MISS".equals(second) && !"MISS".equals(third)) {
            this.tally = 489;
        } else if ("MISS".equals(first) && !"MISS".equals(second)) {
            this.tally = 491;
        } else if (!"MISS".equals(first)) {
            this.tally = 493;
        }
    }
}
