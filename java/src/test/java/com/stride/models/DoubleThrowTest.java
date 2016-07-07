package com.stride.models;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class DoubleThrowTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldDoubleAValidScore() {
        assertEquals(20, new DoubleThrow(10).score());
    }

    @Test
    public void shouldRaiseExceptionForScoreJustBelowMinimumInRange() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Throw score must be in range 1..20");
        new DoubleThrow(0);
    }

    @Test
    public void shouldRaiseExceptionForScoreJustAboveMaximumInRange() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Throw score must be in range 1..20");
        new DoubleThrow(21);
    }
}
