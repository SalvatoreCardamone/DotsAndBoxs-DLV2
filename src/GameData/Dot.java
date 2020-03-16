package GameData;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javafx.scene.shape.Circle;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("punto")
public class Dot extends Circle{
	@Param(0)
	private int x;
	@Param(1)
	private int y;
	
	private Image image;
	private Image notImage;
	private boolean selected;
	
	public Dot() {}
	
	public Dot(int x, int y) throws IOException{
		this.x=x; this.y=y;
		selected = false;
		File inputImage=new File("Image"+File.separator+"dot.png");
		this.image= ImageIO.read(inputImage);
		this.image = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		File inputNotImage= new File("Image"+File.separator+"selectDot.png");
		this.notImage=ImageIO.read(inputNotImage);
		this.notImage=notImage.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
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
	
	
	public void switchImage() {
		this.selected=!this.selected;
		Image temp= this.image;
		this.image=this.notImage;
		this.notImage=temp;
	}
}
