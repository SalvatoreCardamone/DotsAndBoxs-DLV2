package ModelViewControll;

import java.awt.Image;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import GameData.Dot;
import GameData.Line;
import GameData.Square;
import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;


public class Controller{

	private Model model;
	private View view;
	private MouseListener mouse;
	
	public Controller(Model model, View view) throws IOException{
		this.model = model;
		this.view = view;
		
		//Settings of Dots and their Circle
		for(int i=0; i<this.model.getListDots().size(); i++) 
			this.view.addDot(this.model.getListDots().get(i).getImage(), this.model.getListDots().get(i).getX(), this.model.getListDots().get(i).getY());
		/*Circle center calculator */
		for (int i=0; i<model.getListDots().size(); i++)
		{
			model.getListDots().get(i).setCenterX(view.getDots().get(i).getX() +(view.getDots().get(i).getWidth()/2));
			model.getListDots().get(i).setCenterY(view.getDots().get(i).getY() +(view.getDots().get(i).getHeight()/2) );
		}
		
	}
	
	
	public void start(Controller controller) {
		//Mouse
				mouse = new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						
						for (int i=0; i<model.getListDots().size(); i++) {
						
							//Active a Dot that is false
							if(model.getListDots().get(i).contains(e.getX(), e.getY())) {
								if (!(model.getListDots().get(i).isSelected()))
								{
									model.getListDots().get(i).switchImage();
									view.getDots().get(i).setIcon(new ImageIcon(model.getListDots().get(i).getImage()));
								}
								//Disable a Dot that is true
								else 
								{
									model.getListDots().get(i).switchImage();
									view.getDots().get(i).setIcon(new ImageIcon(model.getListDots().get(i).getImage()));
								}
								
							}
						}

						
						controller.checkDot();
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
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
			
				view.getGameInterface().addMouseListener(mouse);
	}
	
	public void checkDot() {
		//CHECK OF LINE
		Dot start = null;
		Dot end = null;
		for (Dot d : model.getListDots())
		{
			if (d.isSelected())
				if(start == null)
					start = d;
				else if(end == null)
					end = d;
			
			//IF WE HAVE 2 SELECTED DOTS
			if(start != null && end != null)
			{
				//Create a new Line
				try { 
				Line a = new Line(start, end);
				if (a.isValid())
					view.addLine(a.getImage(),a.getStart().getX(),a.getStart().getY(), a.getEnd().getX(), a.getEnd().getY());
					model.addLine(new Line(start, end));
					this.checkLine(model.getListLines().get(model.getListLines().size()-1));
				} catch (IOException e2) { e2.printStackTrace(); }
				
				//Set Dots at false
				for (int i=0; i<model.getListDots().size(); i++) {
					if(model.getListDots().get(i).isSelected()) {
						model.getListDots().get(i).switchImage();
						view.getDots().get(i).setIcon(new ImageIcon(model.getListDots().get(i).getImage()));
						view.refreshScreen();}
				}
				break; // non ho capito quale ciclo ferma ma qualcosa la ferma, me lo devi spiegare
			}
		}
	}
	
	public void checkLine(Line line) throws IOException {
	/*	Circle radar = new Circle();
		radar.setRadius(1.5);
		radar.setCenterX(line.getStart().getX());
		radar.setCenterY(line.getStart().getY());
		
		ArrayList<Line> temp= new ArrayList<Line>();
		for(int i=0; i<model.getListLines().size(); i++) {
			if(radar.contains(new Point2D(model.getListLines().get(i).getStart().getX(), model.getListLines().get(i).getStart().getY()))) {
				temp.add(model.getListLines().get(i));
			}
		}
		
		for(int i=0; i<temp.size(); i++) {
			if(line.getStart().getX()==temp.get(i).getStart().getX() && line.getStart().getY()==temp.get(i).getStart().getY()) {
				
				for(int j=0; j<temp.size(); j++) {
					if()
				}
			}
		}
		
	}*/
	}
}
