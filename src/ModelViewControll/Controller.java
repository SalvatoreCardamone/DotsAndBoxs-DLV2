package ModelViewControll;

import java.awt.Image;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import GameData.Dot;
import GameData.Line;


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
							System.out.println("SS");
							model.getListDots().get(i).switchImage();
							view.getDots().get(i).setIcon(new ImageIcon(model.getListDots().get(i).getImage()));
						}
						//Disable a Dot that is true
						else 
						{
							System.out.println("NN");
							model.getListDots().get(i).switchImage();
							view.getDots().get(i).setIcon(new ImageIcon(model.getListDots().get(i).getImage()));
						}
						
					}
				}

				
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
	
	
	public void checkLine() {
		//VOGLIO METTERE IL CONTROLOO QUI MA DEVO CAPIRE PRIMA COME
	}

}
