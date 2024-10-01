package Ex3;



public class Rational {
//data
	private int num =0 ;
	private int den = 0;
	
	//Contractor
	
	
	public Rational() {
		this.num = 1;
		this.den = 1;
	}
	
	public Rational(int num) {
		this.num = num;
		this.den =1;
	}

	
	public Rational(int num,int den) {
		
		if (den == 0) {
			System.out.println("error.you can not insert 0 to denominator,insted the denominator will be 1");
			den = 1;
			
		}
		
		this.num = num;
			this.den =den;

		}
		
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getDen() {
		return den;
	}
	public void setDan(int den) {
		this.den = den;
	}


	
	
	
	//function
	
	public void reduce() { //reduce the Rational number 
	int gcd = gcd(num,den);
	if (gcd !=1 ) {
	num = (num/gcd);
	den = (den/gcd);
}
	}

	 public int gcd (int num,int den) { //finding gcd
		int gcd =1;
		int x =Math.min(num, den);
		
		for (int i =x;i>0;i--) {
			if ((num % i== 0) && (den%i ==0)) {
				gcd = i;
				return i;
			}
		}
		return gcd;
	}
	 public boolean equals(Rational other) {
			if ((getNum() * other.getDen()) == (getDen() * other.getNum())) {
				return true;
			}
		return false;
		}

	public String toString() {
		return "Rational = "+num+" / "+den+ " [num= " +num+ ", den= " + den+" ] ";
	}
	
	
}
