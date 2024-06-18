package example.spring.core;

public class CricketMatchResult implements GreetingService {

	private String winningteam;
	private String losingTeam;
	private int winningMargin;
	private String winningType;
	
	public CricketMatchResult() {
		System.out.println("Inside CricketMatchResult()");
	}

	public CricketMatchResult(String winningteam, String losingTeam, int winningMargin, String winningType) {
		System.out.println("Inside CricketMatchResult(String,String,int,String)");
		this.winningteam = winningteam;
		this.losingTeam = losingTeam;
		this.winningMargin = winningMargin;
		this.winningType = winningType;
	}

	public CricketMatchResult(int winningMargin, String winningteam, String losingTeam, String winningType) {
		System.out.println("Inside CricketMatchResult(int,String,String,String)");
		this.winningMargin = winningMargin;
		this.winningteam = winningteam;
		this.losingTeam = losingTeam;
		this.winningType = winningType;
	}

	public String getWinningteam() {
		return winningteam;
	}

	public void setWinningteam(String winningteam) {
		System.out.println("Setting Winning Team....");
		this.winningteam = winningteam;
	}

	public String getLosingTeam() {
		return losingTeam;
	}

	public void setLosingTeam(String losingTeam) {
		this.losingTeam = losingTeam;
	}

	public int getWinningMargin() {
		return winningMargin;
	}

	public void setWinningMargin(int winningMargin) {
		this.winningMargin = winningMargin;
	}

	public String getWinningType() {
		return winningType;
	}

	public void setWinningType(String winningType) {
		this.winningType = winningType;
	}

	@Override
	public String toString() {
		return "CricketMatchResult [winningteam=" + winningteam + ", losingTeam=" + losingTeam + ", winningMargin="
				+ winningMargin + ", winningType=" + winningType + "]";
	}
	
	@Override
	public String sayGreeting() {
		// TODO Auto-generated method stub
		String greetingMessage = "Heartiest Congratulations to team " + winningteam + " for defeating team "
		+ losingTeam + " by " + winningMargin + " " + winningType;
		return greetingMessage;
	}

}
