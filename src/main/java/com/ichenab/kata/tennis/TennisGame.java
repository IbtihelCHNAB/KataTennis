package com.ichenab.kata.tennis;

public class TennisGame {
	private Player player1;
	private Player player2;

	public TennisGame(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public String getScore() {
		if (player1.getScore() >= 3 && player2.getScore() >= 3) {
			if (Math.abs(player2.getScore() - player1.getScore()) >= 2) {
				return getWinner().getName() + " won";
			} else if (player1.getScore() == player2.getScore()) {
				return "deuce";
			} else {
				return "advantage " + getWinner().getName();
			}
		} else {
			return player1.getScoreDescription(player1.getScore()) + ", "
					+ player2.getScoreDescription(player2.getScore());
		}
	}

	public Player getWinner() {
		return (player1.getScore() > player2.getScore() ? player1 : player2);
	}
}
