package com.stride;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
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
        winnableScore = new Score(30);
    }

    @Test
    public void shouldHaveAnInitialScore() {
        Assert.assertEquals(501, score.score());
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
        Assert.assertEquals(expected, score.score());
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
        return new Object[]{
                new Object[]{null, "MISS", "MISS"},
                new Object[]{"MISS", null, "MISS"},
                new Object[]{"MISS", "MISS", null}
        };
    }

    @Test
    @Parameters(method = "nullParameters")
    public void shouldRejectNullParameters(String first, String second, String third) {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Null throw");
        score.turn(first, second, third);
    }

    @Test
    public void shouldAllowScoreToReachTwo() {
        winnableScore.turn("D14", "MISS", "MISS");
        Assert.assertEquals(2, winnableScore.score());
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

    @Test
    @Parameters({
            "T10,S1,PASS",
            "D14,D2,S1",
            "S1,D14,S2"
    })
    public void shouldEnsureRemainingThrowsArePassesWhenScoreIsBelowTwo(String first, String second, String third) {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Score below two, remaining throws must be passed on");
        winnableScore.turn(first, second, third);
    }

    @Test
    public void shouldBeAbleToConstructWithArbitraryScore() {
        Assert.assertEquals(30, winnableScore.score());
    }

    @Test
    @Parameters({
            "T8,D2,S1",
            "D10,S8,S3",
            "D14,S1,PASS"
    })
    public void resetScoreWhenScoreDropsBelowTwoAndNotZero(String first, String second, String third) {
        winnableScore.turn(first, second, third);
        Assert.assertEquals(30, winnableScore.score());
    }

    @Test
    @Parameters({
            "30,T10",
            "20,S20",
            "25,OR"
    })
    public void shouldResetScoreForFirstThrowThatDoesNotQualify(
            int startingScore, String first) {
        winnableScore = new Score(startingScore);
        winnableScore.turn(first, "PASS", "PASS");
        Assert.assertEquals(startingScore, winnableScore.score());
    }

    @Test
    @Parameters({
            "S16,S14,PASS",
            "S3,T9,PASS",
            "S5,OR,PASS",
            "S10,S10,S10",
            "S1,S2,T9",
            "S1,S4,OR"
    })
    public void shouldResetScoreWhenItReachesZeroAndButDoesNotQualify(String first, String second, String third) {
        winnableScore.turn(first, second, third);
        Assert.assertEquals(30, winnableScore.score());
    }

    @Test
    @Parameters({
            "20,D10,PASS,PASS",
            "50,IR,PASS,PASS",
            "30,S10,D10,PASS",
            "60,S10,IR,PASS",
            "30,S10,S10,D5",
            "60,S5,S5,IR"
    })
    public void shouldSetScoreToZeroWhenItQualifies(
            int startingScore, String first, String second, String third) {
        winnableScore = new Score(startingScore);
        winnableScore.turn(first, second, third);
        Assert.assertEquals(0, winnableScore.score());
    }
}