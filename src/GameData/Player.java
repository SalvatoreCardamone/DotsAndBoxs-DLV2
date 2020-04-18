package GameData;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("punteggio")
public class Player {
	@Param(0)
	private int score;
	private boolean itsMyTurn;
	
	public Player(boolean itsMyTurn){
		this.score=0;
		this.itsMyTurn=itsMyTurn;
	}
	
	public Player(int score){
		this.score=score;
		this.itsMyTurn=false;
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
