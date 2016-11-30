package com.ichenab.kata.tennis;

import java.util.stream.IntStream;
import org.junit.Test;
import com.ichenab.kata.tennis.Player;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlayerTest {

	@Test
	public void scoresCanBeAddedToEachPlayer() {
		Player bob = new Player("Bob");
		Player alice = new Player("Alice");
		IntStream.rangeClosed(1, 3).forEach((Integer) -> {
			bob.winPoint();
		});
		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			alice.winPoint();
		});
		assertThat(bob, hasProperty("score", is(3)));
		assertThat(alice, hasProperty("score", is(4)));
	}

}
