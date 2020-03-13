package Application;


import java.io.IOException;


import ModelViewControll.Controller;
import ModelViewControll.Model;
import ModelViewControll.View;

public class Main {

	 public static void main(String[] args) throws IOException {       
		 System.out.println("PROVA");
		 int nQuadranti=10;
		 Controller A = new Controller(new Model(nQuadranti, nQuadranti), new View(nQuadranti, nQuadranti));
		 A.start(A);
	    }
}
