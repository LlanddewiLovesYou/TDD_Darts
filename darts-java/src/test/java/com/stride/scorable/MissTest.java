package com.stride.scorable;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MissTest {
    @Test
    public void hasAFixedBedValue() {
        Assert.assertEquals(0, new Miss().bedScore());
    }
}
