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
    public void shouldReduceScoreForFirstLaunch() {
        score.launch("D4", "MISS");
        assertEquals(493, score.score());
    }

    @Test
    public void shouldNotReduceScoreWhenFirstLaunchMisses() {
        score.launch("MISS", "MISS");
        assertEquals(501, score.score());
    }

    @Test
    public void shouldReduceScoreForSecondLaunch() {
        score.launch("MISS", "D5");
        assertEquals(491, score.score());
    }
}
