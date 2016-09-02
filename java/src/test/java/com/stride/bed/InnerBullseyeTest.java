package com.stride.bed;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InnerBullseyeTest {
    @Test
    public void hasAFixedBedValue() {
        assertEquals(50, new InnerBullseye().bedScore());
    }
}
