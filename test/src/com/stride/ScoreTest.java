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
    public void shouldNotReduceScoreWhenAllLaunchesMiss() {
        score.launch("MISS", "MISS", "MISS");
        assertEquals(501, score.score());
    }

    @Test
    public void shouldReduceScoreForFirstLaunch() {
        score.launch("D4", "MISS", "MISS");
        assertEquals(493, score.score());
    }

    @Test
    public void shouldReduceScoreForSecondLaunch() {
        score.launch("MISS", "D5", "MISS");
        assertEquals(491, score.score());
    }

    @Test
    public void shouldReduceScoreForThirdLaunch() {
        score.launch("MISS", "MISS", "T4");
        assertEquals(489, score.score());
    }
}
