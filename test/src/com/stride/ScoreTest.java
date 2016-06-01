package com.stride;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreTest {

    @Test
    public void shouldHaveAnInitialScore() {
        assertEquals(501, new Score().score());
    }

    @Test
    public void shouldReduceScoreForFirstSingleLaunch() {
        Score score = new Score();
        score.launch("S4");
        assertEquals(497, score.score());
    }
}
