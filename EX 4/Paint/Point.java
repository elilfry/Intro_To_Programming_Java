


import java.awt.Color;

public class Point implements Drawable, Saveable {
	
	//data
	private int x,y;
	private boolean fill;
	private Color color;
	
	
	//constructor
	public Point(int x,int y,Color color,boolean fill) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.fill = fill;
	}
	public Point (Point p) {
		this(p.x,p.y,p.color,p.fill);
	}
	
	public Point(int x,int y) {
		this(x,y,Color.BLACK,false);
	}
	public Point() {
		
	}
	
	//functions
	
	public static double getDistance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.getY()-p2.getY(),2)+Math.pow(p1.getX()-p2.getX(),2));
	}
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Color getColor() {
		return color;
	}
	
	public boolean getFill() {
		return fill;
	}
	
	public double getArea() {
		
		
		return 0;
	}
	public double getPerimeter() {
		return 0;
	}
	
	@Override
	public String getFileText() {
		
		return "Point*"+x+"*"+y+"*"+Main.translateColor(color)+"*"+fill; 
		
	}
	@Override
	public void loadFileText(String data) {
		String[] point = data.split("\\*");
		this.x=Integer.parseInt(point[1]);
		this.y=Integer.parseInt(point[2]);
		this.color=Main.translateColor(point[3]);
		this.fill=Boolean.parseBoolean(point[4]);
	}
	
	public static Point loadFileText1(String data) {
		String[] point = data.split("\\*");
		int x=Integer.parseInt(point[1]);
		int y=Integer.parseInt(point[2]);
		Point temp = new Point(x,y);
        return temp;
	}
}

