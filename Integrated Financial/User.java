package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

//User is composition
class User extends Screenobj implements KeyListener {

	//make a deep copy constructor
	private static String Name;
	private Account account = new Account(100);
	
	
	public User(String name) {
		Name = name;
		location = new Vector2D(500,300);
		velocity = new Vector2D(0,0);
		size = new Vector2D(50,50);
		image = new ImageIcon("usericon.png").getImage();
		
	}
	
	public void draw(Graphics2D g)
	{
		String balance = String.valueOf(getAccountBalance());
		g.setColor(Color.black);
		g.setFont(new Font ("Arial", Font.PLAIN,150));
		
		g.drawString(balance, 250,250);
		g.drawImage(image, (int)location.getX(), (int)location.getY(), 50, 50, null);
	}
	
	public void deposit(int x)
	{
		account.deposit(x);
	}
	public void withdraw(int x)
	{
		account.withdraw(x);
	}
	public String getName()
	{
		return Name;
	}
	public void setName(String name)
	{
		Name=name;
	}

	public int getAccountBalance() {
		return (account.getValue());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}