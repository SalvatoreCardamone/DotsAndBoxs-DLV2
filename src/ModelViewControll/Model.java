package ModelViewControll;

import java.io.IOException;
import java.util.ArrayList;

import GameData.*;


public class Model {

	private Player humanPlayer;
	private Player aiPlayer;
	//List of all completed square in game
	private ArrayList<Square> listSquares;
	//list of all lines draw in game
	private ArrayList<Line> listLines;
	//list of all dots
	private ArrayList<Dot> listDots;
	private int quadranti;
	
	public Model(int x, int y) throws IOException {
		this.humanPlayer=new Player(true);
		this.aiPlayer= new Player(false);
		listSquares=new ArrayList<Square>();
		listLines= new ArrayList<Line>();
		listDots=new ArrayList<Dot>();
		loadDots(x,y);
		quadranti = (x-1) * (y-1);
	}
	
	public int getQuadranti() {
		return quadranti;
	}
	//ListDots Loading scheme
	public void loadDots(int x, int y) throws IOException {
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				listDots.add(new Dot(i,j));
			}
		}
	} 


	public Player getHumanPlayer() {
		return humanPlayer;
	}


	public void setHumanPlayer(Player humanPlayer) {
		this.humanPlayer = humanPlayer;
	}


	public Player getAiPlayer() {
		return aiPlayer;
	}


	public void setAiPlayer(Player aiPlayer) {
		this.aiPlayer = aiPlayer;
	}


	public ArrayList<Square> getListSquares() {
		return listSquares;
	}



	public ArrayList<Line> getListLines() {
		return listLines;
	}




	public ArrayList<Dot> getListDots() {
		return listDots;
	}


	public void addLine(Line A) {
		this.listLines.add(A);
	}
	
	public void addSquare(Square A) {
		this.listSquares.add(A);
	}
	
	public boolean alreadyExist(Line A) {
		for(int i=0; i<this.listLines.size(); i++) {
			if(this.listLines.get(i).equalsStart(A) && this.listLines.get(i).equalsEnd(A))
				return true;
		}
		return false;
	}
	
}
