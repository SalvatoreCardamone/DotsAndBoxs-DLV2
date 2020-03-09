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
		
		for(int i=0; i<this.model.getListDots().size(); i++) 
			this.view.addDot(this.model.getListDots().get(i).getImage(), this.model.getListDots().get(i).getX(), this.model.getListDots().get(i).getY());
		
		Line a = new Line(new Dot(0,2), new Dot(0,3));
		view.addLine(a.getImage(),a.getStart().getX(),a.getStart().getY(), a.getEnd().getX(), a.getEnd().getY());
		
		Vector<Integer> V1 = new Vector<Integer>();
		Vector<Integer> V2 = new Vector<Integer>();
		
		//Prendo le coordinate dei jlabel
		for (JLabel l : view.getDots())
		{
			V1.add(l.getX()+25); //valore provvisorio, da modificare in base alle dim schermo
			V2.add(l.getY()+25); //valore provvisorio, da modificare in base alle dim schermo
		}
		
		//Le assegno ai dot
		for (int i=0; i<model.getListDots().size(); i++)
		{
			model.getListDots().get(i).setCenterX((double) V1.get(i));
			model.getListDots().get(i).setCenterY((double) V2.get(i));
		}
		
		mouse = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				for (int i=0; i<model.getListDots().size(); i++)
				{
					//se il dot non è stato selezionato, lo attivo e cambio l'icona
					if(model.getListDots().get(i).contains(e.getX(), e.getY())) {
						if (!(model.getListDots().get(i).isSelected()))
						{
							try { model.getListDots().get(i).setSelected(true);
							JOptionPane.showConfirmDialog(null, "Click on "+model.getListDots().get(i).getX()+","+model.getListDots().get(i).getY());
							ImageIcon img1 = new ImageIcon("Image"+File.separator+"selectDot.png");
							Image scaled1 = img1.getImage();
							scaled1 = scaled1.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
							view.getDots().get(i).setIcon(new ImageIcon(scaled1));
							}
							catch (IOException e1) { e1.printStackTrace(); }
						}
						else //lo disattivo e rimetto l'icona standard
						{
							try { model.getListDots().get(i).setSelected(false);
							JOptionPane.showConfirmDialog(null, "Click on "+model.getListDots().get(i).getX()+","+model.getListDots().get(i).getY());
							ImageIcon img1 = new ImageIcon("Image"+File.separator+"dot.png");
							Image scaled1 = img1.getImage();
							scaled1 = scaled1.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
							view.getDots().get(i).setIcon(new ImageIcon(scaled1));
							}
							catch (IOException e1) { e1.printStackTrace(); }
						}
						
					}
				}

				
				//controllo se ho selezionato 2 dot, in tal caso verifico se la linea è valida e la creo
				Dot start = null;
				Dot end = null;
				for (Dot d : model.getListDots())
				{
					if (d.isSelected())
						if(start == null)
							start = d;
						else if(end == null)
							end = d;
					
					
					if(start != null && end != null)
					{
						
						try { 
						Line a = new Line(start, end);
						if (a.isValid())
							view.addLine(a.getImage(),a.getStart().getX(),a.getStart().getY(), a.getEnd().getX(), a.getEnd().getY());
						} catch (IOException e2) { e2.printStackTrace(); }
						
						
						for (Dot d2 : model.getListDots())
							try {d2.setSelected(false);} catch (IOException e1) { e1.printStackTrace();}
						
						for (JLabel l : view.getDots())
						{
						ImageIcon img1 = new ImageIcon("Image"+File.separator+"dot.png");
						Image scaled1 = img1.getImage();
						scaled1 = scaled1.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
						l.setIcon(new ImageIcon(scaled1));
						}
						break;
					}
				}
				view.refreshScreen();
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

}
