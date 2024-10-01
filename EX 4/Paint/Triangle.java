



import java.awt.Color;

public class Triangle implements Drawable,Saveable {
	
	//data
	private Point p0,p1,p2;
	private Color color;
	private boolean fill;
	
	//constructor
	public Triangle() {
		
	}
	
	
	public Triangle(Point p0,Point p1,Point p2,Color color, boolean fill) {
		this.p0 = p0;
		this.p1 = p1;
		this.p2 = p2;
		
		this.color = color;
		this.fill = fill;
	}

		
	//functions
	public Color getColor() {
		return color;
	}
	
	public int[] getXs() {
		int[] ans = new int[3];
		ans[0] = p0.getX();
		ans[1] = p1.getX();
		ans[2] = p2.getX();
		return ans;
	}
	
	public int[] getYs() {
		int[] ans = new int[3];
		ans[0] = p0.getY();
		ans[1] = p1.getY();
		ans[2] = p2.getY();
		return ans;
	}


	@Override
	public boolean getFill() {
		return fill;
	}


	@Override
	public double getArea() {//Area=|(p1-p0)X(p2-p0)|
		return Math.abs((p1.getX()-p0.getX())*(p2.getY()-p0.getY()) - (p2.getX()- p0.getX())*(p1.getY()-p0.getY()));
	}
	
	private double getDistance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.getY()-p2.getY(),2)+Math.pow(p1.getX()-p2.getX(),2));
	}
	public double getPerimeter() {
		return getDistance(p0,p1)+getDistance(p1,p2)+getDistance(p2,p0);
	}
	
	@Override
	public String getFileText() {
		return "Triangle*"+p0.getFileText()+"*"+p1.getFileText()+"*"+p2.getFileText()+"*"+Main.translateColor(color)+"*"+fill;
	}

	@Override
	public void loadFileText(String data) {
		String[] triangle = data.split("\\*");
		this.p0 = new Point(Integer.parseInt(triangle[2]),Integer.parseInt(triangle[3]),
				Main.translateColor(triangle[4]),Boolean.parseBoolean(triangle[5]));
		this.p1 = new Point(Integer.parseInt(triangle[7]),Integer.parseInt(triangle[8]),
				Main.translateColor(triangle[9]),Boolean.parseBoolean(triangle[10]));
		this.p2 =new Point(Integer.parseInt(triangle[12]),Integer.parseInt(triangle[13]),
				Main.translateColor(triangle[14]),Boolean.parseBoolean(triangle[15]));
		this.color=Main.translateColor(triangle[16]);
		this.fill=Boolean.parseBoolean(triangle[17]);


	}
//	public static Point loadFileText1(String data) {  //func that get  x and y anf return point(x,y)
//		String[] point = data.split("\\*");
//		int x=Integer.parseInt(point[1]);
//		int y=Integer.parseInt(point[2]);
//		Point temp = new Point(x,y);
//        return temp;
//}
}

