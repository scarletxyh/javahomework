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
		double[] arr = new double[10];
		System.out.println("Please enter 10 numbers");
		/*让用户输入10个数*/
		for(int i = 0; i < 10; i++) {
			System.out.print(i + 1 + " : ");
			arr[i] = in.nextDouble();
		}
		/*输出数组的序列*/
		int SmallestIndex = indexOfSmallestElement(arr);
		System.out.print("The index of the smallest number is : " + SmallestIndex);
	}
}
