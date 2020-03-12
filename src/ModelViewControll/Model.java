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

	
	public Model(int x, int y) throws IOException {
		this.humanPlayer=new Player();
		this.aiPlayer= new Player();
		listSquares=new ArrayList<Square>();
		listLines= new ArrayList<Line>();
		listDots=new ArrayList<Dot>();
		loadDots(x,y);
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
	
}
