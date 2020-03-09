package GameData;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Dot {
	private int x;
	private int y;
	private Image image;
	
	public Dot(int x, int y) throws IOException{
		this.x=x; this.y=y;
		
		File input=new File("Image"+File.separator+"dot.png");
		this.image= ImageIO.read(input);
		this.image = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	}

	public Image getImage() {
		return image;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
