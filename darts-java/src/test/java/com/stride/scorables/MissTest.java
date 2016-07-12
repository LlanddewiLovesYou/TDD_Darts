package com.stride.scorables;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MissTest {
    @Test
    public void hasAScoreOfZero() {
        Assert.assertEquals(0, new Miss().bedScore());
    }
}
