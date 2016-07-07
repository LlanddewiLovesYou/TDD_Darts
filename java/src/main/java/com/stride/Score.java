package com.stride;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Score {

    private static final Pattern SCORE_PATTERN = Pattern.compile("([SDT])(20|1[0-9]|[1-9])");

    public static final int GROUP_SCORE = 2;
    public static final int GROUP_MULTIPLIER = 1;

    private static final String TURN_TYPE_MISS = "MISS";
    private static final String TURN_TYPE_PASS = "PASS";
    private static final String TURN_TYPE_OUTER_RING = "OR";
    private static final String TURN_TYPE_INNER_RING = "IR";

    private static final Map<String, Integer> TURN_TYPE_WORDS = new HashMap<String, Integer>() {{
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

    private static final Set<String> WINNING_TURN_MULTIPLIERS = new HashSet<String>() {{
        this.add(TURN_TYPE_DOUBLE);
        this.add(TURN_TYPE_INNER_RING);
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
        ensurePreconditions(first, second, third);

        int firstScore = extractScore(first);
        int secondScore = extractScore(second);

        ensureThereAreNoFurtherThrowsOnceScorePassesBelowTwo(firstScore, secondScore, second, third);

        int runningTally = this.tally;
        int[] throwScores = {firstScore, secondScore, extractScore(third)};
        String[] throwValues = {first, second, third};
        for (int i = 0; i < throwScores.length; i++) {
            runningTally -= throwScores[i];
            if (runningTally == 0 && isQualifyingThrow(throwValues[i])) {
                this.tally = runningTally;
                return;
            }
        }

        if (runningTally >= 2) {
            this.tally = runningTally;
        }
    }

    private void ensurePreconditions(String first, String second, String third) {
        ensureNonNullParameters(first, second, third);
        ensureThereIsAtLeastOneThrow(first, second, third);
        ensureNoEarlyPasses(first, second, third);
    }

    private void ensureThereAreNoFurtherThrowsOnceScorePassesBelowTwo(
            int firstScore, int secondScore, String secondValue, String thirdValue) {
        int tallyAfterFirstScore = this.tally - firstScore;
        if (tallyAfterFirstScore < 2 && !TURN_TYPE_PASS.equals(secondValue) ||
                tallyAfterFirstScore - secondScore < 2 && !TURN_TYPE_PASS.equals(thirdValue)) {
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

    private boolean isQualifyingThrow(String value) {
        if (TURN_TYPE_INNER_RING.equals(value)) {
            return true;
        }
        if (TURN_TYPE_WORDS.containsKey(value)) {
            return false;
        }
        Matcher matcher = SCORE_PATTERN.matcher(value);
        validateTurnValue(value, matcher);
        String turnMultiplier = matcher.group(1);
        return WINNING_TURN_MULTIPLIERS.contains(turnMultiplier);
    }

    private int extractScore(String value) {
        if (TURN_TYPE_WORDS.containsKey(value)) {
            return TURN_TYPE_WORDS.get(value);
        }

        Matcher matcher = SCORE_PATTERN.matcher(value);
        validateTurnValue(value, matcher);
        return Integer.parseInt(matcher.group(GROUP_SCORE)) * TURN_MULTIPLIERS.get(matcher.group(GROUP_MULTIPLIER));
    }

    private void validateTurnValue(String value, Matcher matcher) {
        if (!matcher.matches()) {
            throw new IllegalArgumentException(String.format("Invalid turn %s", value));
        }
    }
}