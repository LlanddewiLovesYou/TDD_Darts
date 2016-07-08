package com.stride.models;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class ThrowSingleTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldAllowValidScore() {
        assertEquals(5, new SingleThrow(5).score());
    }

    @Test
    public void shouldRaiseExceptionForScoreJustBelowMinimum() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Throw score must be in range 1..20");
        new SingleThrow(0);
    }

    @Test
    public void shouldRaiseExceptionForScoreJustAboveMaximum() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Throw score must be in range 1..20");
        new SingleThrow(21);
    }
}
