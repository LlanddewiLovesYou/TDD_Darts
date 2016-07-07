package com.stride.models;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassTest {
    @Test
    public void hasAScoreOfZero() {
        assertEquals(0, new Pass().score());
    }
}
