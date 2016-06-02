package com.stride;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ScoreTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Score score;

    @Before
    public void setUp() throws Exception {
        score = new Score();
    }

    @Test
    public void shouldHaveAnInitialScore() {
        assertEquals(501, score.score());
    }

    @Test
    @Parameters({
            "501,PASS,PASS,PASS",
            "497,S4,PASS,PASS",
            "491,PASS,S10,PASS",
            "481,PASS,PASS,S20",
            "471,D3,D5,D7",
            "456,T3,T5,T7",
            "426,OR,OR,OR",
            "351,IR,IR,IR"
    })
    public void shouldReduceScoreAppropriately(int expected, String first, String second, String third) {
        score.launch(first, second, third);
        assertEquals(expected, score.score());
    }

    @Test
    public void shouldRejectLaunchesGreaterThan20() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid launch S21");
        score.launch("S21", "PASS", "PASS");
    }

    @Test
    public void shouldRejectLaunchesLessThan1() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid launch S0");
        score.launch("S0", "PASS", "PASS");
    }

    @Test
    public void shouldRejectPoorlyFormattedLaunch() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid launch INVALID");
        score.launch("INVALID", "PASS", "PASS");
    }

    @Test
    public void shouldRejectNullFirstLaunch() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Null launch");
        score.launch(null, "PASS", "PASS");
    }

    @Test
    public void shouldRejectNullSecondLaunch() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Null launch");
        score.launch("PASS", null, "PASS");
    }

    @Test
    public void shouldRejectNullThirdLaunch() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Null launch");
        score.launch("PASS", "PASS", null);
    }

    @Test
    public void shouldBeAbleToConstructWithArbitraryScore() {
        Score winnableScore = new Score(100);
        assertEquals(100, winnableScore.score());
    }
}
