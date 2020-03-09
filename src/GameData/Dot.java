package GameData;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Dot {
	private int x;
	private int y;
	private BufferedImage image;
	
	public Dot(int x, int y) throws IOException{
		this.x=x; this.y=y;
		File input=new File("C:\\Users\\salva\\git\\DotsAndBoxs-DLV2\\Image\\parte1.PNG");
		this.image= ImageIO.read(input);
	}

	public BufferedImage getImage() {
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
