package com.stride.bed;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OuterBullseyeTest {
    @Test
    public void hasAFixedBedValue() {
        assertEquals(25, new OuterBullseye().bedScore());
    }
}
