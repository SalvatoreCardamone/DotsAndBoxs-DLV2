package ModelViewControll;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Application.Main;
import GameData.Line;

public class View {
	private int screenScaleX;
	private int screenScaleY;
	private JFrame screen;
	private JPanel bar;
	private JPanel gameInterface;
	private JPanel playerBar;
	private JPanel aiBar;
	private JLabel scorePlayer;
	private	JLabel scoreAi;
	private JLabel picturePlayer;
	private JLabel pictureAi;
	private JLabel logo;
	private ArrayList<JLabel> dots;
	private ArrayList<JLabel> lines;
	private ArrayList<JLabel> square;
	private JButton reset;
	
	
	public View(int x, int y) throws IOException{
		
		//Screen Creation0
		screen= new JFrame();
		//Bar Component
		playerBar= new JPanel(new GridLayout());
		aiBar=new JPanel(new GridLayout());
		playerBar.setBackground(Color.WHITE);
		aiBar.setBackground(Color.WHITE);
		
			/*Score JLabel Settings*/
			scorePlayer=new JLabel("0", SwingConstants.CENTER);
			scoreAi= new JLabel("0", SwingConstants.CENTER);
			scorePlayer.setFont(new Font("myFont", Font.BOLD, 30));
			scoreAi.setFont(new Font("myFont", Font.BOLD, 30));
			/*Picture JLabel Settings*/
			Image tempPlayerIcon= ImageIO.read(new File("Image"+File.separator+"human.png"));
			Image tempAiIcon= ImageIO.read(new File("Image"+File.separator+"ai.png"));
			Image logoIcon = ImageIO.read(new File("Image"+File.separator+"logo.png"));
			tempPlayerIcon = tempPlayerIcon.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			tempAiIcon = tempAiIcon.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			logoIcon = logoIcon.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
			picturePlayer=new JLabel(new ImageIcon(tempPlayerIcon));
			pictureAi= new JLabel(new ImageIcon(tempAiIcon));
			logo = new JLabel(new ImageIcon(logoIcon));
			
		playerBar.add(scorePlayer); 
		playerBar.add(picturePlayer);
		aiBar.add(pictureAi);
		aiBar.add(scoreAi);
				
		//Reset button
		reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try { screen.dispose(); Main.startGame();} catch (IOException e1) { e1.printStackTrace(); }
			}
		});
		//Bar Settings
		bar=new JPanel();
		bar.setLayout(new BorderLayout());
		bar.add(playerBar, BorderLayout.WEST);
		bar.add(aiBar, BorderLayout.EAST);
		bar.add(logo, BorderLayout.CENTER);
	
		bar.add(reset,BorderLayout.NORTH);
		
		//gameInterface Component
		this.dots = new ArrayList<JLabel>();
		this.lines= new ArrayList<JLabel>();
		this.square= new ArrayList<JLabel>();
		
		
		//gameInterface Settings
		gameInterface=new JPanel(null);
		gameInterface.setBackground(Color.LIGHT_GRAY);
		
		//Screen Settings
		screen.getContentPane().setLayout(new BorderLayout());
		screen.setSize(new Dimension(600,800));
		screen.setResizable(false);
		//screen.setUndecorated(true);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setAlwaysOnTop(true);
		//GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		//device.setFullScreenWindow(screen);
		
		//Component add
		screen.getContentPane().add(bar,BorderLayout.NORTH);
		screen.getContentPane().add(gameInterface,BorderLayout.CENTER);
		
		//Print
		screen.setVisible(true);
	
		//Scale Settings
		this.screenScaleX=(int) (screen.getSize().getWidth()/x);
		this.screenScaleY=(int) ((screen.getSize().getHeight()-200)/y);	
		
	}
	
	public JPanel getGameInterface()
	{
		return gameInterface;
	}
	
	public JPanel getPlayerBar()
	{
		return playerBar;
	}
	
	public JPanel getAiBar()
	{
		return aiBar;
	}
	
	public JLabel getScorePlayer()
	{
		return scorePlayer;
	}
	
	public JLabel getScoreAi()
	{
		return scoreAi;
	}
	
	public ArrayList<JLabel> getDots()
	{
		return dots;
	}
	
	public int getScreenScaleX() {
		return this.screenScaleX;
	}
	public int getScreenScaleY() {
		return this.screenScaleY;
	}
	
	//Screen repaint
	public void refreshScreen() {
		this.screen.invalidate();
		this.screen.validate();
		this.screen.repaint();
	}
	
	//Dots Add Method
	public void addDot(Image image, int x, int y) {
		this.dots.add(new JLabel(new ImageIcon(image)));
		this.dots.get(this.dots.size()-1).setBounds(x*this.screenScaleX, 
													y*this.screenScaleY, 
													this.screenScaleX,
													this.screenScaleY);
		this.gameInterface.add(this.dots.get(this.dots.size()-1));
		this.refreshScreen();
	}
	
	
	//Lines Add Method 
	public void addLine(BufferedImage image, int startX, int startY, int endX, int endY) {
		this.lines.add(new JLabel(new ImageIcon(image)));
		if(startX==endX) {
		this.lines.get(this.lines.size()-1).setBounds((screenScaleX/2)+startX*this.screenScaleX, 
													  (screenScaleY/2)+startY*this.screenScaleY, 
													  10,
													  this.screenScaleY);
		}
		else if (startY==endY) {
			this.lines.get(this.lines.size()-1).setBounds((screenScaleX/2)+startX*this.screenScaleX, 
														  (screenScaleY/2)+startY*this.screenScaleY, 
					  									  this.screenScaleX,
					  									  10);
		}
		this.gameInterface.add(this.lines.get(this.lines.size()-1));
		this.refreshScreen();
		}
		
	//Square add Method

	public void addSquare(Image image, Line A) {
		JLabel label = new JLabel(new ImageIcon(image));
		this.square.add(label);
		this.square.get(this.square.size()-1).setBounds((screenScaleX/2)+ A.getStart().getX()*this.screenScaleX,
														(screenScaleY/2)+A.getStart().getY()*this.screenScaleY,
														this.screenScaleX,
														this.screenScaleY);	
		this.gameInterface.add(this.square.get(this.square.size()-1));
		this.refreshScreen();
	}

}
