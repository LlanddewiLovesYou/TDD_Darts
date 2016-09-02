package com.stride.bed;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TripleTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldTripleAValidBedValue() {
        assertEquals(9, new Triple(3).bedScore());
    }

    @Test
    public void shouldRaiseExceptionWhenCreatedWithBedValueJustBelowMinimumInRange() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Throw bedScore must be in range 1..20");
        new Triple(0);
    }

    @Test
    public void shouldRaiseExceptionWhenCreatedWithBedValueJustAboveMaximumInRange() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Throw bedScore must be in range 1..20");
        new Triple(21);
    }
}
