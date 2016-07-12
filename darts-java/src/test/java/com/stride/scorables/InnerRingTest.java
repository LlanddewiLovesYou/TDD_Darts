package com.stride.scorables;

import static org.junit.Assert.assertEquals;

public class InnerRingTest {
    @org.junit.Test
    public void shouldHaveAFixedScore() {
        assertEquals(50, new InnerRing().score());
    }
}
