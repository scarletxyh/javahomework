
public class Course implements Cloneable {
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;
    
    public Course(String courseName) {
    	this.courseName = courseName;
    }
    
    public void addStudent(String student) {
    	students[numberOfStudents] = student;
    	numberOfStudents++;
    }
    
    public String[] getStudents() {
    	return students;
    }
    
    public int getNumberOfStudents() {
    	return numberOfStudents;
    }
    public String getCourseName() {
    	return courseName;
    }
    public void dropStudent(String student) {
    	int index = 0;
    	for(int i = 0; i < numberOfStudents; i++) {
    		if(students[i].equals(student)) index = i;//找到值为student的下标
    	}
    	this.numberOfStudents--;  //人数减一（假设没有重名）
    	for(int i = index; i < numberOfStudents;i++) {
    		students[i] = students[i+1];  //将index下标元素删除，将后面元素前移
    	}
    }
    public Course clone() throws CloneNotSupportedException { //实现clone接口
    	Course cloned = (Course)super.clone();//调用Object类的clone函数
    	cloned.courseName = new String(courseName);//拷贝字符串
    	cloned.students = students.clone();//拷贝字符串数组
    	return cloned;
    }
    public static void main(String[] args) throws CloneNotSupportedException {
    	Course math = new Course("Math");
    	for(int i = 1; i <= 4; i++) {  //输入一系列学生姓名
    		StringBuilder sb = new StringBuilder("stu");
    		sb.append(i);
    		math.addStudent(sb.toString());
    	}
    	
    	Course tmpMath = math.clone(); //拷贝原课程数据
    	
    	//显示原课程与拷贝信息
    	System.out.println(math.getCourseName());
    	System.out.println(math.getNumberOfStudents());
    	System.out.println(tmpMath.getCourseName());
    	System.out.println(tmpMath.getNumberOfStudents());
    	
    	//删除一部分学生信息
    	math.dropStudent("stu4");
    	tmpMath.dropStudent("stu1");
    	tmpMath.dropStudent("stu2");
    	
    	//显示删除后的结果
    	System.out.print("origin:");
    	for(int i = 0; i < math.getNumberOfStudents(); i++) {
    		System.out.print(math.getStudents()[i]+" ");
    	}
    	System.out.print("\nclone:");
    	for(int i = 0; i < tmpMath.getNumberOfStudents(); i++) {
    		System.out.print(tmpMath.getStudents()[i]+" ");
    	}
    }
}
