import java.util.Scanner;

public class Work4 {
	public static int indexOfSmallestElement(double[] array) {
		int index = 0;   //记录最小元素的序号
		double SmallestElement = array[0];    //记录最小元素的值
		for(int i = 1; i < array.length; i++) {
			if(array[i] < SmallestElement) {  //如果出现比当前记录更小的元素，则将其记录下来
				index = i;
				SmallestElement = array[i];
			}
		}
		return index;
	}
	public static void main(String[] Args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		double[] arr = new double[n];
		/*随机给数组赋值一系列无序的浮点数序列*/
		for(int i = 0; i < n; i++) arr[i] = (int)(Math.random() * 10000)/1000.0;
		/*输出数组的序列*/
		for(double db : arr)System.out.print(db + " ");
		System.out.println();
		int SmallestIndex = indexOfSmallestElement(arr);
		System.out.print(SmallestIndex);
	}
}
