package com.stride;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreTest {

    private Score score;

    @Before
    public void setUp() throws Exception {
        score = new Score();
    }

    @Test
    public void shouldHaveAnInitialScore() {
        assertEquals(501, score.score());
    }

    @Test
    public void shouldReduceScoreForFirstSingleScoringLaunch() {
        score.launch("S4");
        assertEquals(497, score.score());
    }

    @Test
    public void shouldNotReduceScoreWhenFirstLaunchIsAMiss() {
        score.launch("MISS");
        assertEquals(501, score.score());
    }
}
