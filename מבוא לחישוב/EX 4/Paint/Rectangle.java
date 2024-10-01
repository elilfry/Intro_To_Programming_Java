
import java.awt.Color;
public class Rectangle implements Drawable,Saveable {

	//data 
	private Point p0,p1;
	private Color color;
	private boolean fill;
	
	//constructor
	public Rectangle() {
		
	}
	public Rectangle(Point p0,Point p1,Color color,boolean fill) {
		
		this.p0 = p0;
		this.p1= p1;
		this.color = color;
		this.fill = fill;
	}
	
	//function
	
	public Color getColor() {
		return color;
	}
	
	public boolean getFill() {
		return fill;
	}
	
	public Point getP0() {
		return p0;
	}
	
	public Point getP1() {
		return p1;
	}
	
	
	
	public double getPerimeter() {
		
		int height = Math.abs(p0.getX()-p1.getX());
		int width = Math.abs(p0.getY()-p1.getY());
         int recPerimeter = 2*(height+width);
		return recPerimeter;
	}
	
	

	@Override
	public double getArea() {
		int height = Math.abs(p0.getX()-p1.getX());
		int width = Math.abs(p0.getY()-p1.getY());
		int recArea = height * width;
		return recArea;
	}

	public Point minPoint() {
	
			Point min = new Point(Math.min(p0.getX(), p1.getX()),Math.min(p0.getY(), p1.getY()));
				return min;
	}

	@Override
	public String getFileText() {
		return "Rectangle*"+p0.getFileText()+"*"+p1.getFileText()+"*"+Main.translateColor(color)+"*"+fill;
	}

	@Override
	public void loadFileText(String data) {
        String[] rectangle = data.split("\\*");
		
        this.p0 = new Point(Integer.parseInt(rectangle[2]),Integer.parseInt(rectangle[3]),
				Main.translateColor(rectangle[4]),Boolean.parseBoolean(rectangle[5]));
		
		this.p1 = new Point(Integer.parseInt(rectangle[7]),Integer.parseInt(rectangle[8]),
				Main.translateColor(rectangle[9]),Boolean.parseBoolean(rectangle[10]));
        
		this.color=Main.translateColor(rectangle[11]);
		this.fill=Boolean.parseBoolean(rectangle[12]);
	}

	
	
}
