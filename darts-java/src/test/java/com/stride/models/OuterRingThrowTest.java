package com.stride.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OuterRingThrowTest {
    @Test
    public void shouldHaveAFixedScore() {
        assertEquals(25, new OuterRingThrow().score());
    }
}
