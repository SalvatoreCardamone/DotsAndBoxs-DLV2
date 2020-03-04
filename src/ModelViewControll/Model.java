package ModelViewControll;

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

	
	public Model() {
		this.humanPlayer=new Player();
		this.aiPlayer= new Player();
		listSquares=new ArrayList<Square>();
		listLines= new ArrayList<Line>();
		listDots=new ArrayList<Dot>();
	}
	
	
	//ListDots Loading scheme
	public void loadDots(int x, int y) {
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				listDots.add(new Dot(i,j));
			}
		}
	}
	
	
}
