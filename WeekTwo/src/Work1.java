import java.util.Scanner;

public class Work1 {
	public static void reverse(int number) {
		int res = 0;
		while(number != 0) {
			res = res*10 + number%10;
			number /= 10;
		}
		System.out.print("The reverse of the number is : " + res + "\n");
	}
	public static void main(String[] Args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter a number : ");
		int res = in.nextInt();
		reverse(res);
	}
}
