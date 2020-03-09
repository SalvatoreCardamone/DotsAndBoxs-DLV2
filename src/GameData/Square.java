package GameData;

import java.util.ArrayList;

public class Square {

	private ArrayList<Line> lines;

	public Square(Line A, Line B, Line C, Line D) {
		lines=new ArrayList<Line>();
		lines.add(A);lines.add(B);lines.add(C);lines.add(D);
		this.firstElementSort();
	}
	
	public ArrayList<Line> getLines() {
		return lines;
	}

	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	}
	
	//Make element on position 0 the Top Left Corner of the square
	private void firstElementSort() {
		for(int i=1; i<lines.size(); i++) {
			if(lines.get(0).getStart().getY()<lines.get(i).getStart().getY()) {
				if(lines.get(0).getStart().getX()<lines.get(i).getStart().getX()) {
					Line temp=lines.get(0);
					lines.set(0, lines.get(i));
					lines.set(i, temp);
				}
			}
		}
	}
	
}
