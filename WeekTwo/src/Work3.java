import java.util.Scanner;

public class Work3 {
	public static void countNumber() {
		int[] CountNum = {0,0,0,0,0,0,0,0,0,0};
		for(int i = 0; i < 100; i++) {
			int key = (int)(Math.random() * 10);
			CountNum[key]++;
		}
		for(int i = 0; i < 10; i++) {
			System.out.println(i + " : " + CountNum[i]);
		}	
	}
	public static void main(String[] Args) {
		countNumber();
	}
}
