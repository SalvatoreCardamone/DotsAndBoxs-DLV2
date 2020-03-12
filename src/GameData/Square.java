package GameData;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Square {

	private ArrayList<Line> lines;
	private BufferedImage image;

	public Square(Line A, Line B, Line C, Line D) throws IOException {
		lines=new ArrayList<Line>();
		lines.add(A);lines.add(B);lines.add(C);lines.add(D);
		this.firstElementSort();
		File input=new File("Image"+File.separator+"line.png");
		this.image= ImageIO.read(input);
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public ArrayList<Line> getLines() {
		return lines;
	}

	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	}
	
	public Dot getStartDot() {
		return this.lines.get(0).getStart();
	}
	
	//Make element on position 0 the Top Left Corner of the square
	private void firstElementSort() {
		for(int i=0; i<lines.size()-1; i++) {
			for(int j=i+1; j<this.lines.size(); j++) {
				if(this.lines.get(i).getStart().getY()>this.lines.get(j).getStart().getY()) {
					Line temp= this.lines.get(i);
					this.lines.set(i, this.lines.get(j));
					this.lines.set(j, temp);
				}
				else if(this.lines.get(i).getStart().getY()==this.lines.get(j).getStart().getY()) {
					if(this.lines.get(i).getStart().getX()>=this.lines.get(j).getStart().getX()){
						Line temp= this.lines.get(i);
						this.lines.set(i, this.lines.get(j));
						this.lines.set(j, temp);
					}
				}
			}
		}
	}
	
	public Line getStartLine() {
		return this.lines.get(0);
	}
	
	public boolean isValid() {
		for(int i=0; i<this.lines.size()-1; i++) {
			if((this.lines.get(i).getStart().getX()+this.lines.get(i).getStart().getY()) -(this.lines.get(i+1).getStart().getX()+this.lines.get(i+1).getStart().getY()) != 1) {
				return false;
			}
		}
		return true;
	}
	
}
