package com.stride.models;

import static org.junit.Assert.assertEquals;

public class InnerRingThrowTest {
    @org.junit.Test
    public void shouldHaveAFixedScore() {
        assertEquals(50, new InnerRingThrow().score());
    }
}
