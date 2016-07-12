package com.stride.scorables;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InnerBullseyeTest {
    @Test
    public void hasAFixedBedScore() {
        assertEquals(50, new InnerBullseye().bedScore());
    }
}
