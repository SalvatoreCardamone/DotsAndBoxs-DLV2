package ModelViewControll;

import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import GameData.Dot;
import GameData.Line;


public class Controller extends Thread {

	private Thread thread;
	private Model model;
	private View view;
	private MouseListener mouse;
	
	public Controller(Model model, View view) throws IOException{
		this.model = model;
		this.view = view;
		this.thread= new Thread(this);
		this.thread.start();
		for(int i=0; i<this.model.getListDots().size(); i++) {
			this.view.addDot(this.model.getListDots().get(i).getImage(), this.model.getListDots().get(i).getX(), this.model.getListDots().get(i).getY());
		}
		Line a=new Line(new Dot(0,1), new Dot(1,1));
		this.view.addLine(a.getImage(),a.getStart().getX(),a.getStart().getY(), a.getEnd().getX(), a.getEnd().getY());
	}


	@Override
	public void run() {
		while(true) {
			mouse = new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					if(model.getHumanPlayer().isItsMyTurn()==true) {
						
					}
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			};
		}
	}
}
