package com.stride.scorables;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class SingleTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldAllowValidScore() {
        assertEquals(5, new Single(5).bedScore());
    }

    @Test
    public void shouldRaiseExceptionForScoreJustBelowMinimum() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Throw bedScore must be in range 1..20");
        new Single(0);
    }

    @Test
    public void shouldRaiseExceptionForScoreJustAboveMaximum() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Throw bedScore must be in range 1..20");
        new Single(21);
    }
}
