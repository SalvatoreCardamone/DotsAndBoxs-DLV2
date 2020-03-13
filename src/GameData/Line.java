package GameData;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Line {

	private Dot start;
	private Dot end;
	private BufferedImage image;
	
	public Line(Dot start, Dot end) throws IOException{
		this.start=start;
		this.end=end;
		File input=new File("Image"+File.separator+"line.png");
		this.image= ImageIO.read(input);
		firstElementSort();
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public Dot getStart() {
		return start;
	}
	public void setStart(Dot start) {
		this.start = start;
	}
	public Dot getEnd() {
		return end;
	}
	public void setEnd(Dot end) {
		this.end = end;
	}
	
	public boolean isValid()
	{
		int difference = 0;
		difference += Math.abs(start.getX()-end.getX());
		difference += Math.abs(start.getY()-end.getY());
		if ( difference <= 1)
			return true;
		
		return false;
	}
	private void firstElementSort() {
		if(this.start.getY()>=this.end.getY()) {
			if(this.start.getX()>=this.end.getX()) {
				Dot temp=this.start;
				this.start=this.end;
				this.end=temp;
				
			}
		}
	}
	
	public boolean equalsStart(Line a) {
		if(this.start.getX()==a.start.getX() && this.start.getY()==a.start.getY())
			return true;
		return false;
	}
	
	
	public boolean equalsEnd(Line a) {
		if (this.end.getX()==a.getEnd().getX() && this.end.getY()==a.getEnd().getY())
			return true;
		return false;
	}
	
	public boolean equalsStartEnd(Line a) {
		if (this.start.getX()==a.getEnd().getX() && this.start.getY()==a.getEnd().getY())
			return true;
		return false;
	}
}

