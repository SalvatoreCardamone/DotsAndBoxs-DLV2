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
		File input=new File("C:\\\\Users\\\\salva\\\\git\\\\DotsAndBoxs-DLV2\\\\Image\\\\parte1.PNG");
		this.image= ImageIO.read(input);
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
	
}
