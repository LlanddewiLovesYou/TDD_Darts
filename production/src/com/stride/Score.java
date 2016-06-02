package com.stride;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Score {

    private static final Pattern SCORE_PATTERN = Pattern.compile("([SDT])(20|1[0-9]|[1-9])");

    private static final String LAUNCH_MISS = "MISS";
    private static final String LAUNCH_DOUBLE = "D";
    private static final String LAUNCH_TRIPLE = "T";
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

        Matcher matcher = SCORE_PATTERN.matcher(value);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(String.format("Invalid score %s", value));
        }

        final int amount = Integer.parseInt(value.substring(1));
        return amount * multiplier;
    }
}
