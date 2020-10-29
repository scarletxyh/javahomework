import java.util.Date;

class Account{
	int id = 0;  //学号
	double balance = 0;  //账户余额
	double annualInterestRate = 0;  //年利率
	Date dateCreated;  //注册日期
	Account(){}  //无参数构造函数
	Account(int id, double balance){  //自定义构造函数
		this.id = id;
		this.balance = balance;
		dateCreated = new Date();
	}
	int getID() {return id;}  //id访问器
	double getBalance() {return balance;} //余额访问器
	double getAnnualInterestRate() {return annualInterestRate;} //年利率访问器
	void setID(int id) {this.id = id;} //id修改器
	void setBalance(double balance) {this.balance = balance;}//余额修改器
	void setAnnualInterestRate(double annualInterestRate) { //年利率修改器
		this.annualInterestRate = annualInterestRate/100;
	}
	Date getDate() {return dateCreated;} //注册日期访问器
	double getMonthlyInterestRate() {return annualInterestRate/12;} //月利率访问器
	double getMonthlyInterest() {return balance * getMonthlyInterestRate();}//月利息
	void withDraw(int withdrawMoney) {  //提款
		if(balance >= withdrawMoney)balance -= withdrawMoney;
		else System.out.println("Withdraw failed!");
	}
	void deposit(int depositMoney) {balance += depositMoney;}//存款
}

public class Work2 {
	public static void main(String[] args) {
		Account myAccount = new Account(1122, 20000);//构造新的Account类实例
		myAccount.setAnnualInterestRate(4.5); //设置年利率
		myAccount.withDraw(2500); //提款2500
		myAccount.deposit(3000); //存款30000
		System.out.println("Balance : "+myAccount.getBalance()); //显示余额
		System.out.println("MonthlyInterest : "+myAccount.getMonthlyInterest()); //显示月利息
		System.out.println("CreatedDate + "+myAccount.getDate());  //显示注册日期	
	}
}

