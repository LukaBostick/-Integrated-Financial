package test;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;



//Bank holds all people
public class Bank {

	static int userNumber;
	
	private User[] user = new User[10];
	
	public void addUser(String name)
	{
		User u = new User(name);
		user[userNumber++]=u;
	}
	
	
	public User addUser(User user)
	{
		User u = new User(user.getName());
		return u;
	}
	
	private User getUser(String name)
	{
		User u = getUser(name);
		return u;
	}
	
	public void modifyAccountType(String name, String accountType)
	{
		
		if(accountType == "checkingAccount")
		{	User u1 = getUser(name);
			Account.u1 = new checkingAccount(u1.getAccountBalance());
		}
		else if(accountType == "savingsAccount") {
			User u2 = getUser(name);
			Account.u2 = new savingsAccount(u2.getAccountBalance());
		}
		else if(accountType == "creditAccount") {
			User u3 = getUser(name);
			Account.u3 = new creditAccount(u3.getAccountBalance());
		}
		
	}
	public void withdrawAccount(String name, int amt)
	{
		User u = getUser(name);
		u.withdraw(amt);
	}
	public void depositAccount(String name, int amt)
	{
		User u = getUser(name);
		u.deposit(amt);
	}
}
class Account {
	
	public static checkingAccount u1;
	public static savingsAccount u2;
	public static creditAccount u3;
	
	protected int value;
	
	public Account(int value)
	{
		this.setValue(value);
		
	}
	public void deposit(int amt) {
		this.value+=amt;
		
	}
	
	private void setValue(int value)
	{
		this.value=value;
	}
	public void account()
	{
		this.setValue(0);
	}
	
	public void withdraw(int amt)
	{
		this.value-=amt;
	}
	
	public int getValue()
	{
		return value;
	}

	
}
class checkingAccount extends Account    
{

	public checkingAccount(int value) {
		super(value);
		this.value=value;
	}
	
	public void withdraw(float amt)
	{
		//cash back of 1% for every withdraw
		withdraw(amt);
		deposit((int)(amt/100));
	}

	
}
class savingsAccount extends Account
{
	public savingsAccount(int value)
	{
		super(value);
	}
	public void withdraw(float amt)
	{
		// penalty of 8% for every withdraw
		super.withdraw((int) amt);
		super.withdraw((int) amt/25);
	}
	public void deposit(int amt)
	{
		super.value+=amt;
	}
}
class creditAccount extends Account
{
	//Default line of credit value
	private int creditLimit=1000; 
	public creditAccount(int value)
	{
		super(value);
	}
	
	public void withdraw(float amt)
	{
		
		if(amt <= creditLimit)
			super.withdraw((int)amt);
	}
	
	public void deposit(int amt)
	{
		super.deposit(amt);	
	}
	public int getValue()
	{
		return creditLimit;
	}
}
