package tests;

public class test {
	
	private static Boolean[] pointsEntree = new Boolean[4];;

	public static void main(String[] args) {
		pointsEntree[0] = false;
		pointsEntree[1] = true;
		pointsEntree[2] = true;
		pointsEntree[3] = false;
		
		aff();
		
		rotate2();
		
		aff();
		
		rotate2();
		
		aff();

		rotate2();
		
		aff();

		rotate2();
		
		aff();

		rotate2();
		
		aff();

	}
	
	public static void rotate() {
		int u;
		for(int i = 0; i <= pointsEntree.length - 1; i++) {
			if(i+1 >= pointsEntree.length - 1) u = 0;
			else u = i+1;
			if(pointsEntree[i] == true && pointsEntree[u] == false) {
				pointsEntree[i] = false;
				pointsEntree[u] = true;
			}
		}
	}
	
	public static void rotate2() {
		if(pointsEntree[0] == true && pointsEntree[1] == true) {
			pointsEntree[0] = false;
			pointsEntree[1] = true;
			pointsEntree[2] = true;
			pointsEntree[3] = false;
		}
		else if(pointsEntree[1] == true && pointsEntree[2] == true) {
			pointsEntree[0] = false;
			pointsEntree[1] = false;
			pointsEntree[2] = true;
			pointsEntree[3] = true;
		}
		else if(pointsEntree[2] == true && pointsEntree[3] == true) {
			pointsEntree[0] = true;
			pointsEntree[1] = false;
			pointsEntree[2] = false;
			pointsEntree[3] = true;
		}
		else if(pointsEntree[3] == true && pointsEntree[0] == true) {
			pointsEntree[0] = true;
			pointsEntree[1] = true;
			pointsEntree[2] = false;
			pointsEntree[3] = false;
		}
	}
	
	public static void aff() {
		String aff = "";
		for(int i = 0; i <= pointsEntree.length -1; i++) {
			aff = aff + pointsEntree[i];
		}
		System.out.println(aff);
	}
	

}
