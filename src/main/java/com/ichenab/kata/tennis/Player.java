package com.ichenab.kata.tennis;

import java.util.Arrays;
import java.util.List;

public class Player {

	public static final List<String> scoreDescription = Arrays.asList("zero", "fifteen", "thirty", "forty");

	private String name;
	private int score;

	public Player(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public String getScoreDescription(int score) {
		return scoreDescription.get(score);
	}

	public void winPoint() {
		this.score += 1;
	}

}
