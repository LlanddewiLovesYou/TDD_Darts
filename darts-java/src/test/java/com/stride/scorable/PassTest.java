package com.stride.scorable;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassTest {
    @Test
    public void hasAFixedBedValue() {
        Assert.assertEquals(0, new Pass().bedScore());
    }
}
