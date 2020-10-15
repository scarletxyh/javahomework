import java.util.Scanner;

public class Work5 {
	public static double sumMajorDiagonal(double[][] m) {
		double res = 0;
		for(int i = 0; i < 4; i++)res += m[i][i];
		return res;
	}
	public static void main(String[] Args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a 4-by-4 matrix row by row:\n");
		double[][] matrix = new double[4][4];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				matrix[i][j] = in.nextDouble();
			}
		}
		double res = sumMajorDiagonal(matrix);
		System.out.print(res);
	}
}
