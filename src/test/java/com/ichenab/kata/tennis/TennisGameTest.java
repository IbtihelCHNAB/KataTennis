package com.ichenab.kata.tennis;

import org.junit.Before;
import org.junit.Test;
import com.ichenab.kata.tennis.Player;
import com.ichenab.kata.tennis.TennisGame;
import static org.hamcrest.Matchers.*;
import java.util.stream.IntStream;
import static org.hamcrest.MatcherAssert.assertThat;

public class TennisGameTest {

	Player bob;
	Player alice;
	TennisGame tennis_game;

	@Before
	public void beforeGameTest() {
		bob = new Player("Bob");
		alice = new Player("Alice");
		tennis_game = new TennisGame(bob, alice);
	}

	@Test
	public void zeroShouldBeDescriptionFor0() {
		assertThat(tennis_game, hasProperty("score", is("zero, zero")));
	}

	@Test
	public void fifteenShouldBeDescriptionFor1() {
		bob.winPoint();
		assertThat(tennis_game, hasProperty("score", is("fifteen, zero")));
	}

	@Test
	public void thirtyShouldBeDescriptionFor2() {
		bob.winPoint();
		bob.winPoint();
		assertThat(tennis_game, hasProperty("score", is("thirty, zero")));
	}

	@Test
	public void fourtyShouldBeDescriptionFor3() {
		bob.winPoint();
		bob.winPoint();
		bob.winPoint();
		assertThat(tennis_game, hasProperty("score", is("forty, zero")));
	}

	@Test
	public void advantageShouldBeDescriptionWhenLeastThreePointsHaveBeenScoredByEachOneAndPlayerHasOnePointMoreThanHisOpponent() {
		IntStream.rangeClosed(1, 3).forEach((Integer) -> {
			bob.winPoint();
		});
		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			alice.winPoint();
		});
		assertThat(tennis_game, hasProperty("score", is("advantage Alice")));
	}

	@Test
	public void deuceShouldBeDescriptionWhenAtLeastThreePointsHaveBeenScoredByEachPlayerAndScoresAreEqual() {
		IntStream.rangeClosed(1, 3).forEach((Integer) -> {
			bob.winPoint();
		});
		IntStream.rangeClosed(1, 3).forEach((Integer) -> {
			alice.winPoint();
		});
		assertThat(tennis_game, hasProperty("score", is("deuce")));
		bob.winPoint();
		assertThat(tennis_game, hasProperty("score", is(not("deuce"))));
		alice.winPoint();
		assertThat(tennis_game, hasProperty("score", is("deuce")));
	}

	@Test
	public void gameShoudBeFinishedWhenTheWinnerHaveAtLeastFourPointsAndWithAtLeastTwoPointsMoreThanTheOpponent() {
		IntStream.rangeClosed(1, 3).forEach((Integer) -> {
			bob.winPoint();
		});
		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			alice.winPoint();
		});
		assertThat(tennis_game, hasProperty("score", is(not("Alice won"))));
		assertThat(tennis_game, hasProperty("score", is(not("Bob won"))));
		alice.winPoint();
		assertThat(tennis_game, hasProperty("score", is("Alice won")));
	}

}
