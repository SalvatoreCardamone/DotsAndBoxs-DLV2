package GameData;

public class Player {

	private int score;
	private boolean itsMyTurn;
	
	public Player(){
		this.score=0;
		this.itsMyTurn=false;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public boolean isItsMyTurn() {
		return itsMyTurn;
	}
	public void setItsMyTurn(boolean itsMyTurn) {
		this.itsMyTurn = itsMyTurn;
	}
	
	
}
