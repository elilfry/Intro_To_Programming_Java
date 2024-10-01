

import java.awt.Color;

public class Line implements Drawable, Saveable {
	
	//data
	private Point p0,p1;
	private Color color;
	
	//constructor
      public Line() {		
	}
	
	public Line(Point p0,Point p1, Color color) {
		this.p0 = p0;
		this.p1 = p1;
		this.color = color;
	}
	
	// functions
	public Point getP0() {
		return p0;
	}
	
	public Point getP1() {
		return p1;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public boolean getFill() {
		return false;
	}

	@Override
	public double getArea() {
		return 1;
	}
	private double getDistance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.getY()-p2.getY(),2)+Math.pow(p1.getX()-p2.getX(),2));
	}
	@Override
	public double getPerimeter() {
		
		
		double perimeter = (getDistance(p0, p1)) * 2;

		return perimeter;
	}

	@Override
	public String getFileText() {
		return "Line*"+p0.getFileText()+"*"+p1.getFileText()+"*"+Main.translateColor(color);
	}

	@Override
	public void loadFileText(String data) {
		String[] line = data.split("\\*");
		
		this.p0 = new Point(Integer.parseInt(line[2]),Integer.parseInt(line[3]),
				Main.translateColor(line[4]),Boolean.parseBoolean(line[5]));
		
		this.p1 = new Point(Integer.parseInt(line[7]),Integer.parseInt(line[8]),
				Main.translateColor(line[9]),Boolean.parseBoolean(line[10]));
		
	}
	

}
