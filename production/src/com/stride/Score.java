package com.stride;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Score {

    private static final Pattern SCORE_PATTERN = Pattern.compile("([SDT])(20|1[0-9]|[1-9])");

    private static final String LAUNCH_PASS = "PASS";
    private static final String LAUNCH_OUTER_RING = "OR";
    private static final String LAUNCH_INNER_RING = "IR";

    private static final Map<String, Integer> LAUNCH_WORDS = new HashMap<String, Integer>(){{
        this.put(LAUNCH_PASS, 0);
        this.put(LAUNCH_OUTER_RING, 25);
        this.put(LAUNCH_INNER_RING, 50);
    }};

    private static final String LAUNCH_SINGLE = "S";
    private static final String LAUNCH_DOUBLE = "D";
    private static final String LAUNCH_TRIPLE = "T";


    private static final Map<String, Integer> LAUNCH_MULTIPLIERS = new HashMap<String, Integer>() {{
        this.put(LAUNCH_SINGLE, 1);
        this.put(LAUNCH_DOUBLE, 2);
        this.put(LAUNCH_TRIPLE, 3);
    }};

    private int tally = 501;

    public Score() {}

    public Score(int tally) {
        this.tally = tally;
    }

    public int score() {
        return tally;
    }

    public void launch(String first, String second, String third) {
        ensureNonNullParameters(first, second, third);
        this.tally -= extractScore(first) + extractScore(second) + extractScore(third);
    }

    private void ensureNonNullParameters(String first, String second, String third) {
        if (first == null || second == null || third == null) {
            throw new IllegalArgumentException("Null launch");
        }
    }

    private int extractScore(String value) {
        if (LAUNCH_WORDS.containsKey(value)) {
            return LAUNCH_WORDS.get(value);
        }

        Matcher matcher = SCORE_PATTERN.matcher(value);
        validateLaunchValue(value, matcher);
        return Integer.parseInt(matcher.group(2)) * LAUNCH_MULTIPLIERS.get(matcher.group(1));
    }

    private void validateLaunchValue(String value, Matcher matcher) {
        if (!matcher.matches()) {
            throw new IllegalArgumentException(String.format("Invalid launch %s", value));
        }
    }
}
