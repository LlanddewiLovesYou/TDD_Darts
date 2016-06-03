package com.stride;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.converters.Param;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import javax.lang.model.type.NullType;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ScoreTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Score score;
    private Score winnableScore;

    @Before
    public void setUp() throws Exception {
        score = new Score();
        winnableScore = new Score(40);
    }

    @Test
    public void shouldHaveAnInitialScore() {
        assertEquals(501, score.score());
    }

    @Test
    @Parameters({
            "501,MISS,MISS,MISS",
            "501,PASS,PASS,PASS",
            "497,S4,MISS,MISS",
            "491,MISS,S10,MISS",
            "481,MISS,MISS,S20",
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
        score.launch("S21", "MISS", "MISS");
    }

    @Test
    public void shouldRejectLaunchesLessThan1() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid launch S0");
        score.launch("S0", "MISS", "MISS");
    }

    @Test
    public void shouldRejectPoorlyFormattedLaunch() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid launch INVALID");
        score.launch("INVALID", "MISS", "MISS");
    }

    public Object[] nullParameters() {
        return new Object[] {
                new Object[] { null, "MISS", "MISS" },
                new Object[] { "MISS", null, "MISS" },
                new Object[] { "MISS", "MISS", null }
        };
    }

    @Test
    @Parameters(method="nullParameters")
    public void shouldRejectNullFirstLaunch(String first, String second, String third) {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Null launch");
        score.launch(first, second, third);
    }

    @Test
    public void shouldBeAbleToConstructWithArbitraryScore() {
        assertEquals(40, winnableScore.score());
    }

    @Test
    public void shouldResetScoreWhenReducedToOne() {
        winnableScore.launch("T12", "D1", "S1");
        assertEquals(40, winnableScore.score());
    }

    @Test
    public void shouldAllowScoreToReachTwo() {
        winnableScore.launch("T12", "D1", "MISS");
        assertEquals(2, winnableScore.score());
    }

    @Test
    public void shouldSetScoreToZeroWhenItReachesZeroAndThirdLaunchIsADouble() {
        winnableScore.launch("T12", "D2", "MISS");
        assertEquals(0, winnableScore.score());
    }
}
