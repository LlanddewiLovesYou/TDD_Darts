package com.stride;

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
        score.launch("S4", "MISS");
        assertEquals(497, score.score());
    }

    @Test
    public void shouldNotReduceScoreWhenAllLaunchesMiss() {
        score.launch("MISS", "MISS");
        assertEquals(501, score.score());
    }

    @Test
    public void shouldReduceScoreForSecondSingleScoringLaunch() {
        score.launch("MISS", "S10");
        assertEquals(491, score.score());
    }
}
