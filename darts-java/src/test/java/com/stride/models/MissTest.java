package com.stride.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MissTest {
    @Test
    public void hasAScoreOfZero() {
        assertEquals(0, new Miss().score());
    }
}
