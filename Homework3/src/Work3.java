import java.util.ArrayList;
import java.util.Comparator;

public class Work3 {
	
	public static void sort(ArrayList<Number> list) {
		list.sort(new NumberComparator());//用比较器实现ArrayList的内置sort函数
	}
    public static void main(String args[]) {
		ArrayList<Number> myList = new ArrayList<Number>();//构造一个新的ArrayList<Number>类
		for(int i = 0; i < 20; i++) {
			//随机赋值int和double类型的数据
			if((int)(Math.random()*10)%2 == 1) myList.add(Math.random()*100);
			else myList.add((int)(Math.random()*100));
		}
		//打印排序前的数据
		System.out.println("Before:");
		for (Number list: myList) {
            System.out.println(list);
        }
		sort(myList);
		//打印排序后的数据
		System.out.println("\nAfter:");
		for (Number list: myList) {
            System.out.println(list);
        }
	}
}
class NumberComparator implements Comparator<Number>{ //实现Comparator<Number>接口
	public int compare(Number first, Number second) {
		if (first.doubleValue() - second.doubleValue() > 0)return 1;
		else if (first.doubleValue() - second.doubleValue() == 0)return 0;
		else return -1;
	}
}