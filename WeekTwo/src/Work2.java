import java.util.Scanner;

public class Work2 {
    public static void printMatrix(int n) {
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			System.out.print((Math.random() > 0.5) ? 0 : 1);
    			System.out.print(" ");
    		}
    		System.out.print("\n");
    	}
    }
    public static void main(String[] Args) {
    	Scanner in = new Scanner(System.in);
    	System.out.print("Enter n : ");
		int res = in.nextInt();
		printMatrix(res);
    }
}
