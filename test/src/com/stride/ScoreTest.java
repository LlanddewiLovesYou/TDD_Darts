package com.stride;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreTest {

    @Test
    public void shouldHaveAnInitialScore() {
        assertEquals(501, new Score().score());
    }

    @Test
    public void shouldReduceScoreForFirstThrow() {
        Score score = new Score();
        score.launch("D4");
        assertEquals(493, score.score());
    }

    @Test
    public void shouldNotReduceScoreWhenFirstLaunchMisses() {
        Score score = new Score();
        score.launch("MISS");
        assertEquals(501, score.score());
    }
}
