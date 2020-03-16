package Application;


import java.io.IOException;

import javax.swing.JOptionPane;

import ModelViewControll.Controller;
import ModelViewControll.Model;
import ModelViewControll.View;

public class Main {

	public static Controller A;
	public static int nQuadranti;
	 public static void main(String[] args) throws IOException {       
		 System.out.println("PROVA");
		 
		 startGame();
		 
	    }
	 
	 public static void startGame() throws IOException
	 {
		 nQuadranti = 0;
		 while (nQuadranti <= 2 || nQuadranti >= 11)
		 {
		 String s = JOptionPane.showInputDialog("Inserire numero quadranti (Minimo 3, max 10):");
		 if (s == null)
			 System.exit(0);
			 
		 try { nQuadranti = Integer.parseInt(s); }
		 catch (Exception e) {}
		 }
		 
		 A = new Controller(new Model(nQuadranti, nQuadranti), new View(nQuadranti, nQuadranti));
		 A.start(A);
	 }
	 
}
