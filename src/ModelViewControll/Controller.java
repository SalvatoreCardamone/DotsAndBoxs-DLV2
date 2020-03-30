package ModelViewControll;


import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import GameData.Dot;
import GameData.Line;
import GameData.Square;
import GameData.Square.Giocatore;
import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;

public class Controller{

	private Model model;
	private View view;
	private MouseListener mouse;
	private static Handler handler;
	
	public Controller(Model model, View view) throws IOException{
		handler = new DesktopHandler(new DLV2DesktopService("/home/marco/git/DotsAndBoxs-DLV2/dlv2"));
		
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
						view.getScoreAi().setText(Integer.toString(model.getAiPlayer().getScore()));
						view.getScorePlayer().setText(Integer.toString(model.getHumanPlayer().getScore()));
						
						//HIGHLIGHT TURN
						if (model.getHumanPlayer().getItsMyTurn())
						{
							view.getPlayerBar().setBackground(Color.YELLOW);
							view.getAiBar().setBackground(Color.WHITE);
						}
						else if(model.getAiPlayer().getItsMyTurn())
						{
							view.getPlayerBar().setBackground(Color.WHITE);
							view.getAiBar().setBackground(Color.YELLOW);
							
							//START AI
							InputProgram facts= new ASPInputProgram();
					
							try {
								
							
							for(Dot d : model.getListDots())
								facts.addObjectInput(new Dot(d.getX(),d.getY()));
							
							for(Line l : model.getListLines())
								facts.addObjectInput(new Line(l.getStart(),l.getEnd()));
							
								
							
							
							} catch (Exception e1) { e1.printStackTrace(); } 
							
							handler.addProgram(facts);
							InputProgram encoding= new ASPInputProgram();
							encoding.addFilesPath("DotsBoxsIA.txt");
							handler.addProgram(encoding);
							
							Output o =  handler.startSync();
							AnswerSets answers = (AnswerSets) o;
							
							for(AnswerSet a:answers.getAnswersets()) {
								
									System.out.println(a);
									
							}
							
						}
						
						
						//END OF GAME
						if(model.getQuadranti()==model.getListSquares().size())
						{
							if(model.getHumanPlayer().getScore() > model.getAiPlayer().getScore())
								JOptionPane.showConfirmDialog(null, "YOU WIN!", "Congratulations!", JOptionPane.DEFAULT_OPTION);
							else if (model.getHumanPlayer().getScore() < model.getAiPlayer().getScore())
								JOptionPane.showConfirmDialog(null, "YOU LOSE!", "Oh no!", JOptionPane.DEFAULT_OPTION);
							else
								JOptionPane.showConfirmDialog(null, "DRAW!", "Try again!", JOptionPane.DEFAULT_OPTION);
						}
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						
					}
				};
			
				view.getGameInterface().addMouseListener(mouse);
	}
	
	
	public void playerTurn() {
		
	}
	
	public void aiTurn() {
		
		
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
					if (a.isValid() && !model.alreadyExist(a)) {
						view.addLine(a.getImage(),a.getStart().getX(),a.getStart().getY(), a.getEnd().getX(), a.getEnd().getY());
						model.addLine(new Line(start, end));
						if(model.getHumanPlayer().getItsMyTurn()==true) {
						this.checkLine(model.getListLines().get(model.getListLines().size()-1),Giocatore.HUMAN);}
						else if(model.getAiPlayer().getItsMyTurn()==true) {
						this.checkLine(model.getListLines().get(model.getListLines().size()-1),Giocatore.CPU);
						}
					}
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
	
	public void checkLine(Line line, Giocatore player) throws IOException {
		
		System.out.println(player);
		Line pairStart=null;
		Line pairEnd=null;
		
		/*Angoli 90� formatisi */
		for(int i=0 ; i<model.getListLines().size()-1; i++) {
				if(line.equalsStart(model.getListLines().get(i))) {
					pairStart=model.getListLines().get(i);
				System.out.println("pairStart");
				}
				else if (line.equalsEnd(model.getListLines().get(i))) {
					pairEnd=model.getListLines().get(i);
					System.out.println("pairEnd");
				}
		}
		
		boolean point=false;
		int cont=0;
		
		if(pairStart!=null) {
			for(int i=0; i<model.getListLines().size()-1; i++) {
				if(model.getListLines().get(i).equalsStartEnd(line)) {
					for(int j=0; j<model.getListLines().size()-1; j++) {
						if(model.getListLines().get(j).equalsStartEnd(pairStart)) {
							if(model.getListLines().get(i).equalsEnd(model.getListLines().get(j))){
								cont++;
								point=true;
								model.addSquare(new Square(line,model.getListLines().get(i), model.getListLines().get(j), pairStart, player));
								view.addSquare(model.getListSquares().get(model.getListSquares().size()-1).getImage(),model.getListSquares().get(model.getListSquares().size()-1).getStartLine());
							}
						}
					}
				}
			}
		}
		if(pairEnd!=null) {
			for(int i=0; i<model.getListLines().size()-1; i++) {
				if(line.equalsStartEnd(model.getListLines().get(i))) {
					for(int j=0; j<model.getListLines().size()-1; j++) {
						if(pairEnd.equalsStartEnd(model.getListLines().get(j))) {
							if(model.getListLines().get(i).equalsStart(model.getListLines().get(j))){
								cont++;
								point=true;
								model.addSquare(new Square(line,model.getListLines().get(i), model.getListLines().get(j), pairEnd, player));
								view.addSquare(model.getListSquares().get(model.getListSquares().size()-1).getImage(),model.getListSquares().get(model.getListSquares().size()-1).getStartLine());
							}
						}
					}
				}
			}
		}
		
		
		if(point) {
			if(player==Giocatore.HUMAN) {
				model.getHumanPlayer().setScore(model.getHumanPlayer().getScore()+cont);
			}
			else if(player==Giocatore.CPU) {
				model.getAiPlayer().setScore(model.getAiPlayer().getScore()+cont);
			}
		}
		else if(!point) {
			model.getAiPlayer().setItsMyTurn(!model.getAiPlayer().getItsMyTurn());
			model.getHumanPlayer().setItsMyTurn(!model.getHumanPlayer().getItsMyTurn());
		}
	}		
}
