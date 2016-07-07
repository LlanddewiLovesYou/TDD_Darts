package com.stride.models;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TripleThrowTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldTripleAValidScore() {
        assertEquals(9, new TripleThrow(3).score());
    }

    @Test
    public void shouldRaiseExceptionWhenCreatedWithScoreJustBelowMinimumInRange() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Throw score must be in range 1..20");
        new TripleThrow(0);
    }

    @Test
    public void shouldRaiseExceptionWhenCreatedWithScoreJustAboveMaximumInRange() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Throw score must be in range 1..20");
        new TripleThrow(21);
    }
}
