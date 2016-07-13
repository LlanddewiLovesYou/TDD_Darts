package com.stride.bed;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class DoubleTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldDoubleAValidBedValue() {
        assertEquals(20, new Double(10).bedScore());
    }

    @Test
    public void shouldRaiseExceptionForBedValueJustBelowMinimumInRange() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Throw bedScore must be in range 1..20");
        new Double(0);
    }

    @Test
    public void shouldRaiseExceptionForBedValueJustAboveMaximumInRange() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Throw bedScore must be in range 1..20");
        new Double(21);
    }
}
