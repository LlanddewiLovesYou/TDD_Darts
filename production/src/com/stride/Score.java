package com.stride;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Score {

    private static final Pattern SCORE_PATTERN = Pattern.compile("([SDT])(20|1[0-9]|[1-9])");

    private static final String TURN_TYPE_MISS = "MISS";
    private static final String TURN_TYPE_PASS = "PASS";
    private static final String TURN_TYPE_OUTER_RING = "OR";
    private static final String TURN_TYPE_INNER_RING = "IR";

    private static final Map<String, Integer> TURN_TYPE_WORDS = new HashMap<String, Integer>(){{
        this.put(TURN_TYPE_MISS, 0);
        this.put(TURN_TYPE_PASS, 0);
        this.put(TURN_TYPE_OUTER_RING, 25);
        this.put(TURN_TYPE_INNER_RING, 50);
    }};

    private static final String TURN_TYPE_SINGLE = "S";
    private static final String TURN_TYPE_DOUBLE = "D";
    private static final String TURN_TYPE_TRIPLE = "T";


    private static final Map<String, Integer> TURN_MULTIPLIERS = new HashMap<String, Integer>() {{
        this.put(TURN_TYPE_SINGLE, 1);
        this.put(TURN_TYPE_DOUBLE, 2);
        this.put(TURN_TYPE_TRIPLE, 3);
    }};

    private int tally;

    public Score() {
        this(501);
    }

    public Score(int tally) {
        this.tally = tally;
    }

    public int score() {
        return tally;
    }

    public void turn(String first, String second, String third) {
        ensureNonNullParameters(first, second, third);
        ensureThereIsAtLeastOneThrow(first, second, third);
        ensureNoEarlyPasses(first, second, third);

        int firstScore = extractScore(first);
        int secondScore = extractScore(second);

        ensureThereAreNoFurtherThrowsOnceScorePassesBelowTwo(second, third, firstScore, secondScore);

        int runningTally = this.tally - firstScore;
        if (runningTally == 0 && !isEndingThrow(first)) {
            return;
        }

        int score = firstScore + secondScore + extractScore(third);

        int newTally = this.tally - score;
        if (newTally >= 2 || newTally == 0) {
            this.tally = newTally;
        }
    }

    private boolean isEndingThrow(String first) {
        return false;
    }

    private void ensureThereAreNoFurtherThrowsOnceScorePassesBelowTwo(String second, String third, int firstScore, int secondScore) {
        int tallyAfterFirstScore = this.tally - firstScore;
        if(tallyAfterFirstScore < 2 && !TURN_TYPE_PASS.equals(second) ||
                tallyAfterFirstScore - secondScore < 2 && !TURN_TYPE_PASS.equals(third)) {
            throw new IllegalArgumentException("Score below two, remaining throws must be passed on");
        }
    }

    private void ensureNoEarlyPasses(String first, String second, String third) {
        if (TURN_TYPE_PASS.equals(first) && !TURN_TYPE_PASS.equals(second) ||
                TURN_TYPE_PASS.equals(second) && !TURN_TYPE_PASS.equals(third)) {
            throw new IllegalArgumentException("Unexpected pass when there are later scoring throws");
        }
    }

    private void ensureThereIsAtLeastOneThrow(String first, String second, String third) {
        if (TURN_TYPE_PASS.equals(first) && TURN_TYPE_PASS.equals(second) && TURN_TYPE_PASS.equals(third)) {
            throw new IllegalArgumentException("Expected at least one throw");
        }
    }

    private void ensureNonNullParameters(String first, String second, String third) {
        if (first == null || second == null || third == null) {
            throw new IllegalArgumentException("Null throw");
        }
    }

    private int extractScore(String value) {
        if (TURN_TYPE_WORDS.containsKey(value)) {
            return TURN_TYPE_WORDS.get(value);
        }

        Matcher matcher = SCORE_PATTERN.matcher(value);
        validateTurnValue(value, matcher);
        return Integer.parseInt(matcher.group(2)) * TURN_MULTIPLIERS.get(matcher.group(1));
    }

    private void validateTurnValue(String value, Matcher matcher) {
        if (!matcher.matches()) {
            throw new IllegalArgumentException(String.format("Invalid turn %s", value));
        }
    }
}
