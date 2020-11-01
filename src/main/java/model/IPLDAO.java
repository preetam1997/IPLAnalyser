package model;

import iplanalysis.IPLMostRuns;
import iplanalysis.IPLMostWIckets;

public class IPLDAO {
	public int position;
	public String player;
	public int matches;
	public int innings;
	public int notOut;
	public int runs;
	public int highScore;
	public double average;
	public int ballsFaced;
	public double strikeRate;
	public int centuries;
	public int halfCenturies;
	public int fours;
	public int sixes;

	public int positionBowler;
	public String playerBowler;
	

	public int matchesBowler;
	public int inningsBowler;
	public double overs;
	public int runsBowler;
	public int wickets;
	public String bestBowlingInInnings;
	public double averageBowler;
	public double economy;
	public double strikeRateBowler;
	public int fourWickets;
	public int fiveWickets;

	public int getFours() {
		return fours;
	}

	public void setFours(int fours) {
		this.fours = fours;
	}

	public int getSixes() {
		return sixes;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public double getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(double strikeRate) {
		this.strikeRate = strikeRate;
	}

	public void setSixes(int sixes) {
		this.sixes = sixes;
	}

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	public double getStrikeRateBowler() {
		return strikeRateBowler;
	}
	public double getAverageBowler() {
		return averageBowler;
	}

	public int getCenturies() {
		return centuries;
	}

	public int getHalfCenturies() {
		return halfCenturies;
	}

	public int getWickets() {
		return wickets;
	}

	public IPLDAO(IPLMostRuns iplMostRuns) {
		position = iplMostRuns.position;
		player = iplMostRuns.player;
		matches = iplMostRuns.matches;
		innings = iplMostRuns.innings;
		notOut = iplMostRuns.notOut;
		runs = iplMostRuns.runs;
		highScore = iplMostRuns.highScore;
		average = iplMostRuns.average;
		ballsFaced = iplMostRuns.ballsFaced;
		strikeRate = iplMostRuns.strikeRate;
		centuries = iplMostRuns.centuries;
		halfCenturies = iplMostRuns.halfCenturies;
		fours = iplMostRuns.fours;
		sixes = iplMostRuns.sixes;
	}

	public IPLDAO(IPLMostWIckets iplMostWIckets) {
		positionBowler = iplMostWIckets.position;
		playerBowler = iplMostWIckets.player;
		matchesBowler = iplMostWIckets.matches;
		inningsBowler = iplMostWIckets.innings;
		overs = iplMostWIckets.overs;
		runsBowler = iplMostWIckets.runs;
		wickets = iplMostWIckets.wickets;
		bestBowlingInInnings = iplMostWIckets.bestBowlingInInnings;
		averageBowler = iplMostWIckets.average;
		economy = iplMostWIckets.economy;
		strikeRateBowler = iplMostWIckets.strikeRate;
		fourWickets = iplMostWIckets.fourWickets;
		fiveWickets = iplMostWIckets.fiveWickets;
	}

}
