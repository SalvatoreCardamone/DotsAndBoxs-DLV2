package ModelViewControll;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View {
	private JFrame screen;
	private JPanel bar;
	private JPanel gameInterface;
	
	public View(){
		
		//Screen Creation
		screen= new JFrame();		

		
		
		//Bar Settings
		bar=new JPanel();
		bar.setLayout(new GridLayout());
		bar.setBackground(Color.WHITE);
		
		//gameInterface Settings
		gameInterface=new JPanel();
		gameInterface.setBackground(Color.BLUE);
		
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
	
		
	}
	
}
