

import java.awt.Color;
import java.util.Arrays;

public class Hexagon implements Drawable,Saveable {

		// data 
		private Point p;
		private int radius;
		private Color color;
		private boolean fill;
	
		// constructor
		public Hexagon() {
			
		}
		public Hexagon(Point p,int radius,Color color,boolean fill) {
			this.p = p;
			this.radius = radius;
			this.color = color;
			this.fill = fill;
		}
		public int getX() {
			return p.getX();
		}
		
		public int[] getXs() {
			int[] ans = new int[6];
			ans[0] = p.getX() +  radius; // Point a
			ans[1] =  p.getX() + (int)(radius/2); // Point b
			ans[2] = p.getX() -(int)(radius/2); // Point c
			ans[3] = p.getX() - radius; // Point d
			ans[4] = p.getX() -(int)(radius/2); //Point e
			ans[5] = p.getX() +(int)(radius/2); // Point f
			return ans;
		}
		
		public int[] getYs() {
			int[] ans = new int[6];
			ans[0] = p.getY(); //Point a
			ans[1] = p.getY() +(int)(((radius) *(Math.sqrt(3)))/2); // Point b
			ans[2] = p.getY() +(int)(((radius) *(Math.sqrt(3)))/2);  //Point  c
			ans[3] = p.getY(); // Point d
			ans[4] = p.getY() - (int)(((radius) *(Math.sqrt(3)))/2); // Point e
			ans[5] = p.getY() - (int)(((radius) *(Math.sqrt(3)))/2); // Point f


			return ans;
		}
		
		
		@Override
		public Color getColor() {
			return color;
		}
		@Override
		public boolean getFill() {
			return fill;
		}
		public Point getP() {
			return p;
		}
		
		public int getRadius() {
			return radius;
		}
		
		public double getArea() {
		double hexArea = (((radius * radius)*3) * (Math.sqrt(3)))/2;
			return hexArea;
		}
		
		public double getPerimeter() {
			
			int hexPerimeter = (radius*6);
 			return hexPerimeter;
		}
		
		
		
		
		@Override
		public String getFileText() {
			return "Hexagon*"+p.getFileText()+"*"+radius+"*"+Main.translateColor(color)+"*"+fill;
		}
		@Override
		public void loadFileText(String data) {
			String[] hexagon = data.split("\\*");
			this.p = new Point(Integer.parseInt(hexagon[2]),Integer.parseInt(hexagon[3]),
					Main.translateColor(hexagon[4]),Boolean.parseBoolean(hexagon[5]));
			this.radius = Integer.parseInt(hexagon[6]);
			this.color=Main.translateColor(hexagon[7]);
			this.fill=Boolean.parseBoolean(hexagon[8]);
			
				
		}
		
		
	
	
}
