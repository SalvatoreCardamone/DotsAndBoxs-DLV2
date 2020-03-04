package GameData;

public class Line {

	private Dot start;
	private Dot end;
	
	public Line(Dot start, Dot end) {
		this.start=start;
		this.end=end;
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
