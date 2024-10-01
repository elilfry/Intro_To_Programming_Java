


import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		// the window definition
		MainWindow frame = new MainWindow();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setVisible(true);
		
		
		
		
		ArrayList<Drawable> draws = new ArrayList<Drawable>();
		Point p0 = new Point(100,100);
		Point p1 = new Point(150,150);
		Point p2= new Point(250,300);
		Point p3= new Point(220,310);
		Point p4= new Point(230,100);
		Point p5= new Point(240,220);
        Point p6= new Point(181,171);

        Hexagon h = new Hexagon(p0, 100, Color.CYAN, true);
		draws.add(h);
        
		Line l = new Line(p0, p1, Color.BLACK);
		draws.add(p0);
		draws.add(p2);

		draws.add(l);
		
		
		
		Circle c = new Circle(p4, 100, Color.MAGENTA, true);
		draws.add(c);
		
		Circle c2 = new Circle(p6, 70, Color.black, true);
		draws.add(c2);
		
		Triangle t = new Triangle(p3, p4, p5, Color.BLUE, true);
		draws.add(t);
		
		Rectangle r = new Rectangle(p0, p1, Color.BLUE, false);
		draws.add(r);
		
		
		frame.setDraws(draws);
		
		sort(draws); //sort by perimeter
		frame.setDraws(draws); //draw by sorted perimeter        
//
//		saveFile(draws);
//		
//		draws = readFile("My_path");
//		frame.setDraws(draws);
		
	
		// Create a list and add shapes
		// sort by area

		// draw the shapes
		/*
		 * frame.setDraws(your_shapes_list);
		 */

		// sort by perimeter

		// draw the shapes
		/*
		 * frame.setDraws(your_shapes_list);
		 */

		// save and load the shapes with file
		/*
		 * saveFile(your_shapes_list); 
		 * your_shapes_list = readFile("My_path");
		 * frame.setDraws(your_shapes_list);
		 */

	}

	public static ArrayList<Drawable> readFile(String fileName) {

		ArrayList<Drawable> newDraws = new ArrayList<Drawable>();

		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			String line = br.readLine();

			while (line != null) {

				if (line.startsWith("Point")) {
					Point p_new = new Point();
					p_new.loadFileText(line);

					newDraws.add(p_new);
				}
				
				if (line.startsWith("Line")) {
					Line l_new = new Line();
					l_new.loadFileText(line);
					newDraws.add(l_new);
					
				}
				if (line.startsWith("Circle")) {
					Circle c_new = new Circle();
					c_new.loadFileText(line);
					newDraws.add(c_new);
					
				}
				if (line.startsWith("Triangle")) {
					Triangle t_new = new Triangle();
					t_new.loadFileText(line);
					newDraws.add(t_new);
					
				}
				if (line.startsWith("Rectangle")) {
					Rectangle r_new = new Rectangle();
					r_new.loadFileText(line);
					newDraws.add(r_new);
					
				}
				if (line.startsWith("Hexagon")) {
					Hexagon h_new = new Hexagon();
					h_new.loadFileText(line);
					newDraws.add(h_new);
					
				}
				
				line = br.readLine();
			}

			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return newDraws;

	}

	public static void sort (ArrayList<Drawable> draw) {
		ComparebyPerimeter myComparator = new ComparebyPerimeter();
		Collections.sort(draw,myComparator);
		
		
	}
	
	public static void saveFile(ArrayList<Drawable> draws) {
		try {
			FileWriter myWriter = new FileWriter("My_path");
			for (int i = 0; i < draws.size() && draws != null ; i++) {
				if (draws.get(i) instanceof Saveable) {
					Saveable s = (Saveable) draws.get(i);
					myWriter.write(s.getFileText() + "\n");
				}
			}

			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static String translateColor(Color c) {
		if (c.equals( Color.BLACK)) {
			return "black";
		}
		if (c.equals( Color.CYAN)) {
			return "ciyan";
		}
		if (c.equals(Color.MAGENTA)) {
			return "magenta";
		}
		if (c.equals(Color.BLUE)) {
			return "blue";
		}
		return "bad_color";
	}

	public static Color translateColor(String c) {
		if (c.equals("black"))
			return Color.BLACK;
		if (c.equals("ciyan") )
			return Color.CYAN;
		if (c.equals("magenta"))
			return Color.MAGENTA;
		if (c.equals("blue"))
			return Color.BLUE;
		return Color.black;
	}

}


