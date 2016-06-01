package com.stride;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreTest {

    @Test
    public void shouldHaveAnInitialScore() {
        assertEquals(501, new Score().score());
    }

}
