import java.awt.Color;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("start");

		int[][][] myImage = MyImageIO.readImageFromFile("42104.jpg");

		//rotate90
		try {
			int[][][] rotate90 = Ex2.rotate90(myImage);
			MyImageIO.writeImageToFile("rotate90.jpg",rotate90);
		}
		catch(Exception e) {
			System.out.println("rotate 90");
			e.printStackTrace();
		}

		//Smooth
		try {
			int[][][] smooth = Ex2.Smooth(myImage, 10);
			MyImageIO.writeImageToFile("smooth.jpg",smooth);
		}
		catch(Exception e) {
			System.out.println("Smooth");
			e.printStackTrace();
		}

		//rgb2gray
		int[][] grayImage = null;
		try {
			grayImage = Ex2.rgb2gray(myImage);
			MyImageIO.writeImageToFile("grayImage.jpg",grayImage);
		}
		catch(Exception e) {
			System.out.println("rgb2gray");
			e.printStackTrace();
		}

		try {
			int[][] scalledUpImage = Ex2.scaleup(1.4,1.4, grayImage);
			MyImageIO.writeImageToFile("scalledUpImage.jpg",scalledUpImage);
		}
		catch(Exception e) {
			System.out.println("scale up");
			e.printStackTrace();
		}

		try {
			int[][] scalledDownImage = Ex2.scaleup(0.8, 1.3, grayImage);
			MyImageIO.writeImageToFile("scalledDownImage.jpg",scalledDownImage);
		}
		catch(Exception e) {
			System.out.println("scale down");
			e.printStackTrace();
		}

		System.out.println("done");

	}

}
