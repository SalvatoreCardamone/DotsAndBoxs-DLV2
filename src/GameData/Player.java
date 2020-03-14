package GameData;

public class Player {

	private int score;
	private boolean itsMyTurn;
	
	public Player(boolean itsMyTurn){
		this.score=0;
		this.itsMyTurn=itsMyTurn;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public boolean getItsMyTurn() {
		return itsMyTurn;
	}
	public void setItsMyTurn(boolean itsMyTurn) {
		this.itsMyTurn = itsMyTurn;
	}
	
	
}
