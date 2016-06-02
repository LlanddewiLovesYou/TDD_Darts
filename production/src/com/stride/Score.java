package com.stride;

public class Score {
    private int tally = 501;

    public int score() {
        return tally;
    }

    public void launch(String first, String second, String third) {
        this.tally -= extractScore(first) + extractScore(second) + extractScore(third);
    }

    private int extractScore(String value) {
        if ("MISS".equals(value)) {
            return 0;
        }
        String type = value.substring(0, 1);
        int multiplier = 1;
        if ("D".equals(type)) {
            multiplier = 2;
        }
        return Integer.parseInt(value.substring(1)) * multiplier;
    }
}
