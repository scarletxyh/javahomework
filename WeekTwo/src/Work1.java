import java.util.Scanner;

public class Work1 {
	public static void reverse(int number) {
		int res = 0;
		while(number != 0) {
			res = res*10 + number%10;
			number /= 10;
		}
		System.out.print(res);
	}
	public static void main(String[] Args) {
		Scanner in = new Scanner(System.in);
		int res = in.nextInt();
		reverse(res);
	}
}
