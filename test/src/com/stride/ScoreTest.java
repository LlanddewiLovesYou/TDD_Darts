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
            "497,S4,MISS,MISS",
            "491,MISS,S10,MISS",
            "481,MISS,MISS,S20",
            "499,S1,S1,PASS",
            "500,S1,PASS,PASS",
            "471,D3,D5,D7",
            "456,T3,T5,T7",
            "426,OR,OR,OR",
            "351,IR,IR,IR"
    })
    public void shouldReduceScoreAppropriately(int expected, String first, String second, String third) {
        score.turn(first, second, third);
        assertEquals(expected, score.score());
    }

    @Test
    public void shouldRejectTurnsWhoseScoreIsGreaterThan20() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid turn S21");
        score.turn("S21", "MISS", "MISS");
    }

    @Test
    public void shouldRejectThrowsLessThan1() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid turn S0");
        score.turn("S0", "MISS", "MISS");
    }

    @Test
    public void shouldRejectPoorlyFormattedTurn() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid turn INVALID");
        score.turn("INVALID", "MISS", "MISS");
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
    public void shouldRejectNullFirstThrowInTurn(String first, String second, String third) {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Null turn");
        score.turn(first, second, third);
    }

    @Test
    public void shouldBeAbleToConstructWithArbitraryScore() {
        assertEquals(40, winnableScore.score());
    }

    @Test
    @Parameters({
            "T12,D1,S1",
            "D10,S8,S13",
            "D19,S1,PASS"
    })
    public void resetScore(String first, String second, String third) {
        winnableScore.turn(first, second, third);
        assertEquals(40, winnableScore.score());
    }

    @Test
    public void shouldAllowScoreToReachTwo() {
        winnableScore.turn("T12", "D1", "MISS");
        assertEquals(2, winnableScore.score());
    }

    @Test
    public void shouldSetScoreToZeroWhenItReachesZeroAndThirdThrowIsADouble() {
        winnableScore.turn("T10", "S8", "D1");
        assertEquals(0, winnableScore.score());
    }

    @Test
    public void expectAtLeastOneThrow() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Expected at least one throw");
        score.turn("PASS", "PASS", "PASS");
    }

    @Test
    @Parameters({
            "PASS,T1,T1",
            "PASS,T1,PASS",
            "T1,PASS,T1",
            "PASS,PASS,T1"
    })
    public void shouldRejectPassesWhenThereAreLaterThrows(String first, String second, String third) {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Unexpected pass when there are later scoring throws");
        score.turn(first, second, third);
    }
}
