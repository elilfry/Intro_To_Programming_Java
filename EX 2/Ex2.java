



public class Ex2 {

	
	//ex 2.4 function

	public static int[][] scaleup(double factor_h, double factor_w, int[][] arr) {
		int h = (arr.length);
		int w = (arr[0].length);
		 int hNew = (int) (1+((arr.length) * (factor_h)));
	     int wNEw = (int) (1+((arr[0].length) * (factor_w)));
		 
		
		int [][] scaleupArr = new int [hNew][wNEw];
		for (int i = 0; i < h; i++)
		{
			for (int j = 0; j < w; j++)
			{
				for (int fh = 0; fh < factor_h; fh++)
				{
					for (int fw = 0; fw < factor_w; fw++)
					{	
						int iNew =(int) ((i *factor_h)+fh);
						int jNew =(int) ((j *factor_w) +fw);
						scaleupArr[iNew][jNew] = arr [i][j];
					}
		
	}
		}
	}
		return scaleupArr;
	}

	//ex2.3 function that smooth the image
	public static int[][][] Smooth(int[][][] img, int n){
		int h = img[0].length, w = img[0][0].length;

		int[][][] smootArr = new int [3][h][w];
	
		for (int i =0;i<3;i++) {
		for (int j =0;j<h;j++) {
			for (int k =0;k<w;k++) {
	        
				int PixeSum = 0, PixeCount = 0;

			//a<=n?//	
				for (int a =j-n ; a <j+n; a++){
					for (int b = k-n; b < k+n; b++) {
						
						if (isTrue(img, a, b)) {
							PixeSum = PixeSum + img[i][a][b];
							PixeCount = PixeCount +1;
						}	
					}
				}
				smootArr[i][j][k] = (PixeSum/PixeCount);
			}
        	}
	  }
		return smootArr;
	}
	//check if arr [i][x][y] is valid
	public static boolean isTrue(int[][][] arr, int x,int y) {
		
		if (x>=0 && x < arr[0].length-1) {
			if (y>=0 && y < arr[0][0].length-1) {
				return true;
			}
		}
		return false;
	}
	
	
	

		
	//ex2.2 function the rotate
	public static int[][][] rotate90(int[][][] arr) {
		int h = arr[0].length;
		
		int [][][] rotate90Arr = new int[arr.length] [arr[0][0].length][arr[0].length];
		for (int i=0;i<3;i++) {
		for (int j=0;j<arr[0].length;j++) {
				for (int k=0;k<arr[0][0].length;k++) {
					rotate90Arr[i][k][h-1-j] = arr[i][j][k];}
			}
		
			
		}
					return rotate90Arr;
	
	}

	//ex2.1 function rgb to gray
public static int[][] rgb2gray(int[][][] arr) {
	int [][] grayArr = new int [arr[0].length][arr[0][0].length];
	for (int i=0;i<arr.length;i++) {
		for (int j=0;j<arr[0].length;j++) {
			for (int k=0;k<arr[0][0].length;k++) {
				double x = ((arr[0][j][k])*0.3) + ((arr [1][j][k])*0.59) + ((arr[2][j][k])*0.11);
				grayArr [j][k] = (255*(int)(x));
			}
		}
	}
	return grayArr;
}

	
   	
    
	}
   
	
	
	

