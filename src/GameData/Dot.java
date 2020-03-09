package GameData;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.scene.shape.Circle;

public class Dot extends Circle{
	private int x;
	private int y;
	private Image image;
	private boolean selected;
	
	public Dot(int x, int y) throws IOException{
		this.x=x; this.y=y;
		selected = false;
		File input=new File("Image"+File.separator+"dot.png");
		this.image= ImageIO.read(input);
		this.image = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		this.setRadius(12.5);
		this.setCenterX((double) x);
		this.setCenterX((double) y);
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
	
	public void setSelected(boolean b) throws IOException
	{
		selected = b;
	}
	
	public boolean isSelected()
	{
		return selected;
	}
}
