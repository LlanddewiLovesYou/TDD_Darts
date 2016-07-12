package com.stride.scorables;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TripleTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldTripleAValidBedScore() {
        assertEquals(9, new Triple(3).bedScore());
    }

    @Test
    public void shouldRaiseExceptionWhenCreatedWithBedScoreJustBelowMinimumInRange() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Throw bedScore must be in range 1..20");
        new Triple(0);
    }

    @Test
    public void shouldRaiseExceptionWhenCreatedWithBedScoreJustAboveMaximumInRange() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Throw bedScore must be in range 1..20");
        new Triple(21);
    }
}
