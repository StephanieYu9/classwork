package algorithms;

public class TowerOfHanoi {

	public static void main(String[] args) {
		 int n = 4; // Number of disks
	     towerSolution(n, 'A', 'C', 'B');
	}

	public static void towerSolution(int n, char A, char B, char C) {
		if (n == 1){
            System.out.println("Move disk 1 from rod " +  A + " to rod " + B);
            return;
        }else {
        	towerSolution(n-1, A, C, B);
            System.out.println("Move disk " + n + " from rod " +  A + " to rod " + B);
            //towerSolution(n-1, C, B, A);

        }
	}
}
