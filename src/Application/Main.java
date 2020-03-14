package Application;


import java.io.IOException;
import ModelViewControll.Controller;
import ModelViewControll.Model;
import ModelViewControll.View;

public class Main {

	public static Controller A;
	 public static void main(String[] args) throws IOException {       
		 System.out.println("PROVA");
		 
		 startGame();
		 
	    }
	 
	 public static void startGame() throws IOException
	 {
		 int nQuadranti=8;
		 A = new Controller(new Model(nQuadranti, nQuadranti), new View(nQuadranti, nQuadranti));
		 A.start(A);
	 }
	 
}
