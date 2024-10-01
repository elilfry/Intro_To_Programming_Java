

import java.awt.Color;

public class Circle implements Drawable, Saveable {
	
	//data
	private Point p0;
	private int radius;
	private Color color;
	private boolean fill;
	
	
	//constructor
	
	public Circle() {};
	
	public Circle(Point p,int radius,Color color,boolean fill) {
		this.p0 = p;
		this.radius = radius;
		this.color = color;
		this.fill = fill;
	}
	
	@Override
	public Color getColor() {
		return color;
	}
	@Override
	public boolean getFill() {
		return fill;
	}
	@Override
	public double getArea() {
		return Math.PI*radius*radius;
	}
	public double getPerimeter() {

		double  perimeter = (radius)* ( Math.PI)*(2);
		return perimeter;
	}
	
	public Point getP() {
		return p0;
	}
	
	public int getRadius() {
		return radius;
	}

	@Override
	public String getFileText() {
		return "Circle*"+p0.getFileText()+"*"+radius+"*"+Main.translateColor(color)+"*"+fill;
	}

	@Override
	public void loadFileText(String data) {
		String[] circle = data.split("\\*");
		this.p0 = new Point(Integer.parseInt(circle[2]),Integer.parseInt(circle[3]),
				Main.translateColor(circle[4]),Boolean.parseBoolean(circle[5]));
		this.radius = Integer.parseInt(circle[6]);
		this.color=Main.translateColor(circle[7]);
		this.fill=Boolean.parseBoolean(circle[8]);

	}

	


}


