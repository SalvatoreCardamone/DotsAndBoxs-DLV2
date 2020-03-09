package ModelViewControll;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
	private ArrayList<JLabel> dots;
	private ArrayList<JLabel> lines;
	private ArrayList<JLabel> square;
	
	public View(int x, int y) throws IOException{
		
		//Screen Creation0
		screen= new JFrame();		
	
		
		//Bar Component
		playerBar= new JPanel(new GridLayout());
		aiBar=new JPanel(new GridLayout());
			/*Score JLabel Settings*/
			scorePlayer=new JLabel("0", SwingConstants.CENTER);
			scoreAi= new JLabel("0", SwingConstants.CENTER);
			scorePlayer.setFont(new Font("myFont", Font.BOLD, 30));
			scoreAi.setFont(new Font("myFont", Font.BOLD, 30));
			/*Picture JLabel Settings*/
			BufferedImage tempPlayerIcon= ImageIO.read(new File("C:\\Users\\salva\\git\\DotsAndBoxs-DLV2\\Image\\parte1.PNG"));
			BufferedImage tempAiIcon= ImageIO.read(new File("C:\\Users\\salva\\git\\DotsAndBoxs-DLV2\\Image\\parte1.PNG"));
			picturePlayer=new JLabel(new ImageIcon(tempPlayerIcon));
			pictureAi= new JLabel(new ImageIcon(tempAiIcon));
		playerBar.add(scorePlayer);
		playerBar.add(picturePlayer);
		aiBar.add(pictureAi);
		aiBar.add(scoreAi);
				
		//Bar Settings
		bar=new JPanel();
		bar.setLayout(new BorderLayout());
		bar.setBackground(Color.BLACK);
		bar.add(playerBar, BorderLayout.WEST);
		bar.add(aiBar, BorderLayout.EAST);
		
		//gameInterface Component
		this.dots = new ArrayList<JLabel>();
		this.lines= new ArrayList<JLabel>();
		this.square= new ArrayList<JLabel>();
		
		//gameInterface Settings
		gameInterface=new JPanel(null);
		gameInterface.setBackground(Color.YELLOW);
		
		//Screen Settings
		screen.getContentPane().setLayout(new BorderLayout());
		screen.setUndecorated(true);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setAlwaysOnTop(true);
		GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		device.setFullScreenWindow(screen);
		
		//Component add
		screen.getContentPane().add(bar,BorderLayout.NORTH);
		screen.getContentPane().add(gameInterface,BorderLayout.CENTER);
		
		//Print
		screen.setVisible(true);
	
		//Scale Settings
				this.screenScaleX=(int) (gameInterface.getSize().getWidth()/x);
				this.screenScaleY=(int) (gameInterface.getSize().getHeight()/y);
				
		
	}
	
	
	//Screen repaint
	public void refreshScreen() {
		this.screen.invalidate();
		this.screen.validate();
		this.screen.repaint();
	}
	
	//Dots Add Method
	public void addDot(BufferedImage image, int x, int y) {
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
													  this.screenScaleX,
													  10);
		}
		else if (startY==endY) {
			this.lines.get(this.lines.size()-1).setBounds((screenScaleX/2)+startX*this.screenScaleX, 
														  (screenScaleY/2)+startY*this.screenScaleY, 
					  									  10,
					  									  this.screenScaleY);
		}
		this.gameInterface.add(this.lines.get(this.lines.size()-1));
		this.refreshScreen();
		System.out.println("aggiunto");
		}
	
	//Square add Method


	
	
}
