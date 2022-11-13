package test;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class BackGroundImage extends Screenobj{

	public BackGroundImage(String imageName)
	{
		this.image = new ImageIcon(imageName).getImage();
		
		this.location = new Vector2D(0,0);
		
		this.size = new Vector2D(1000,1000);
	}
	
	public void draw(Graphics2D g)
	{
		g.drawImage(image, (int)location.getX(), (int)location.getY(), 1000, 1000, null);
	}
	
	public void setImage(String imageName)
	{
		this.image = new ImageIcon(imageName).getImage();
	}
}
