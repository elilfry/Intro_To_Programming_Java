

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;



public class MainWindow extends JFrame {

	//data
	private ArrayList<Drawable> drawable;
	

	//constructor
	public MainWindow() {
		super();
	}

	//functions

	@Override
	public void paint(Graphics g) {

		g.clearRect(0, 0, this.getWidth(),this.getHeight() );
		
		for (int i=0; drawable != null && i<drawable.size() ;i++) {
			
			if (drawable.get(i) instanceof Point) {
				Point p = (Point)drawable.get(i);
				g.drawOval(p.getX(), p.getY(), 3, 3);
			}
			
			if (drawable.get(i) instanceof Line) {
				Line l = (Line)drawable.get(i);
				
				g.setColor(l.getColor());
				g.drawLine(l.getP0().getX(), l.getP0().getY(),
						l.getP1().getX(), l.getP1().getY());
			}
			
			if (drawable.get(i) instanceof Circle) {
				Circle c = (Circle)drawable.get(i);
				
				g.setColor(c.getColor());
				
				if (c.getFill()) {
					g.fillOval(c.getP().getX()-c.getRadius()/2,
							c.getP().getY()-c.getRadius()/2,
							c.getRadius(), c.getRadius());
				}
				else {
					g.drawOval(c.getP().getX()-c.getRadius()/2,
							c.getP().getY()-c.getRadius()/2,
							c.getRadius(), c.getRadius());
				}
				
				
			}
		

			
			
			
			if (drawable.get(i) instanceof Triangle) {
				Triangle t = (Triangle)drawable.get(i);
				
				g.setColor(t.getColor());
				
				if (t.getFill()) {
					g.fillPolygon(t.getXs(), t.getYs(), t.getXs().length);
				}
				else {
					g.drawPolygon(t.getXs(), t.getYs(), t.getXs().length);
				}
				
			}
			if (drawable.get(i) instanceof Rectangle) {
				Rectangle r = (Rectangle)drawable.get(i);
				Point minPoint = r.minPoint();
				g.setColor(r.getColor());
				
				int height = Math.abs(r.getP1().getX()-r.getP0().getX());
				int width = Math.abs(r.getP0().getY()-r.getP1().getY());;
//				g.drawRect(r.getP0().getX(), r.getP0().getY(),height,width);
				
			
				if (r.getFill()) {
					g.fillRect(minPoint.getX(), minPoint.getY(),height,width);
//				g.fillRect(r.getP0().getX(), r.getP0().getY(),height,width);
				}
				else {
					g.drawRect(minPoint.getX(),minPoint.getY(),height,width);

//					g.drawRect(r.getP0().getX(), r.getP0().getY(),height,width);
				}
				
			}
			
			if (drawable.get(i) instanceof Hexagon) {
				Hexagon h = (Hexagon)drawable.get(i);
				
				g.setColor(h.getColor());
				
				if (h.getFill()) {
					
					
					g.fillPolygon(h.getXs(), h.getYs(),6);
				}
				else {
					
					g.drawPolygon(h.getXs(), h.getYs(), 6);
				}
				
			}
			
		}
		
	}

	
	public void setDraws(ArrayList<Drawable> drawable) {
		this.drawable = drawable;				
		this.repaint();
	}



}
