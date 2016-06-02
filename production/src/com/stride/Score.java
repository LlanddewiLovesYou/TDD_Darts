package com.stride;

public class Score {

    private static final String LAUNCH_MISS = "MISS";
    public static final String LAUNCH_DOUBLE = "D";
    public static final String LAUNCH_TRIPLE = "T";
    private static final String LAUNCH_OUTER_RING = "OR";
    private static final String LAUNCH_INNER_RING = "IR";

    private int tally = 501;

    public int score() {
        return tally;
    }

    public void launch(String first, String second, String third) {
        this.tally -= extractScore(first) + extractScore(second) + extractScore(third);
    }

    private int extractScore(String value) {
        if (LAUNCH_MISS.equals(value)) {
            return 0;
        } else if (LAUNCH_OUTER_RING.equals(value)) {
            return 25;
        } else if (LAUNCH_INNER_RING.equals(value)) {
            return 50;
        }
        String type = value.substring(0, 1);
        int multiplier = 1;
        if (LAUNCH_DOUBLE.equals(type)) {
            multiplier = 2;
        } else if (LAUNCH_TRIPLE.equals(type)) {
            multiplier = 3;
        }
        return Integer.parseInt(value.substring(1)) * multiplier;
    }
}
