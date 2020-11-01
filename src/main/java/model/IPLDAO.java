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
	public String highScore;
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
    public int overs;
    public int runsBowler;
    public int wickets;
    public String bestBowlingInInnings;
    public String averageBowler;
    public int economy;
    public double strikeRateBowler;
    public int fourWickets;
    public int fiveWickets;
    
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
        inningsBowler =  iplMostWIckets.innings;
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
