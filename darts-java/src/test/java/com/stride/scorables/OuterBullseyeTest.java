package com.stride.scorables;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OuterBullseyeTest {
    @Test
    public void shouldHaveAFixedScore() {
        assertEquals(25, new OuterBullseye().score());
    }
}
