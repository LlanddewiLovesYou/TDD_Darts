package com.stride.models;

import static org.junit.Assert.assertEquals;

public class ThrowInnerRingTest {
    @org.junit.Test
    public void shouldHaveAFixedScore() {
        assertEquals(50, new ThrowInnerRing().score());
    }
}
