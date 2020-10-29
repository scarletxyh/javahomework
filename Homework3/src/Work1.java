import java.util.Date;

public class Work1 {
    public static void main(String[] args) {
    	Date mydate = new Date();  //初始化一个Date类的实例
    	for(int i = 4; i < 12; i++) {
    		mydate.setTime((long)Math.pow(10, i));//设置不同的流逝时间
    		System.out.println(mydate.toString());//打印mydate
    	}
    }
}
