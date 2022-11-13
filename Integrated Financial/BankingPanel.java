package test;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


class BankingPanel extends JPanel implements MouseListener
{
	//double buffer / raster image that the screen objs are drawn to, once drawn the whole raster is drawn together
	Image Buffer,background;
	int width,height;
	Graphics2D g;
	
	String currentPage;
	
	Point2D clickLocation=null;
	Point2D mouseLocation=null;
	User person1 = new User("Bart");
	
	public BankingPanel (int w, int h)
	{
		width=w;
		height=h;
		
		//setup the graphics
		Buffer=new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		g=(Graphics2D) Buffer.getGraphics();
		this.addMouseListener(this);
	}
	public void preSimulationLoop() throws InterruptedException, FileNotFoundException {
		Button start = new Button(500,300,243,65,Button.Job.Start,new ImageIcon("Start.png").getImage());
    	Button quit = new Button(500,400,243,65,Button.Job.Quit,new ImageIcon("Quit.png").getImage());
		Button about = new Button(500,500,243,65,Button.Job.About,new ImageIcon("About.png").getImage());
		Button back = new Button(500,600,243,65,Button.Job.Back,new ImageIcon("Back.png").getImage());
		
		
		
		//Loop
		while(true)
    	{
			g.setColor(Color.black);
    		g.fillRect(0,0,this.getWidth(),this.getHeight());
    		g.setColor(Color.WHITE);
    		g.setFont(new Font ("Arial", Font.PLAIN,72));
    		g.drawString("Banking App", 250,250);
    		//draw
    		start.draw(g, mouseLocation);
    		quit.draw(g, mouseLocation);
    		about.draw(g, mouseLocation);
    		
    		this.getGraphics().drawImage(Buffer, 0, 0, null);
    		
    		//check for actions
    		if(clickLocation != null)
    		{
    			//start Simulation
    			if(start.check(clickLocation))
    				break;
    			if(quit.check(clickLocation))
    				System.exit(0);
    			
    			while(about.check(clickLocation))
    			{
    				g.setColor(Color.black);
    				g.fillRect(0,0,this.getWidth(),this.getHeight());
    	    		g.setColor(Color.white);
    	    		
    	    		//TODO Write a function for printing text on screen
    	    		g.drawString("Created for HackUTD IX", 200,250);
    	    		g.drawString("11/12/2022 - 11/13/2022", 200,300);
    	    		g.drawString("nitish, avaneesh, himanth, luka", 200, 350);
    	    		g.drawString("", 200, 400);
    	    		
    	    		back.draw(g, mouseLocation);
    	    		
    	    		quit.isEmpty();
    				
    	    		this.getGraphics().drawImage(Buffer, 0, 0, null);
        			
    	    		if(back.check(getLocation()))
    	    			break;
    			}  			
    				clickLocation = null;
    		}
    		try {
    			Thread.sleep(100);
    		}catch(InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
		loop();
	}
	public void loop() throws FileNotFoundException
	{
		String ACCT  = Constraints.ACCT_FILENAME;
		String INVEST = Constraints.INVEST_FILENAME;
		String BUDGET = Constraints.BUDGET_FILENAME;
		
		int FrameNumber=0;
		
		//init user and bank
		
		JFrame frame = (JFrame) this.getTopLevelAncestor();
		//init background
		BackGroundImage background = new BackGroundImage(ACCT);
		
		
		
		//init buttons
		Button account = new Button(310,20,146,50,Button.Job.Account);
		Button investments = new Button(470,20,157,50,Button.Job.Investments);
		Button budget = new Button(600,20,146,50,Button.Job.Budget);
		
		account.draw(g, mouseLocation);
		investments.draw(g, mouseLocation);
		budget.draw(g, mouseLocation);
		
		
		// init user and account
		
		
		
		//checkUser();
		
		
		while(true)
		{
			FrameNumber++;
			
			g.setColor(Color.white);
			g.fillRect(0, 0, Buffer.getWidth(null), Buffer.getHeight(null));
			
			if(clickLocation != null)
			{
			if(account.check(clickLocation))
			{
				background.setImage(ACCT);
				genBudget(g);
			}
				
			if(investments.check(clickLocation))
			{
				background.setImage(INVEST);
				genStock(g);
			}
				
			if(budget.check(clickLocation))
			{
				background.setImage(BUDGET);
			}
			GenAcct(g);
			}
			
			
			//clickLocation=null;
			//g.drawImage(new ImageIcon("Simulation Template.png").getImage(), 150, 50, null);
			
			for(int i=0;i<Screenobj.Screenobjs.size();i++)
			{
				Screenobj so = Screenobj.Screenobjs.get(i);
				
				//Act on the various objects
                so.act();        
                
                //Draw various screen objects                            
                so.draw(g);
			}
			this.getGraphics().drawImage(Buffer, 0, 0, null);
			try{Thread.sleep(20);}catch(Exception e){}
		}
	}
	
	private void genBudget(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(0,0,this.getWidth(),this.getHeight());
		g.setColor(Color.white);
		String s = Integer.toString((int)(Math.random()*200));
		
		g.drawString(s, 200,250);
	}
	private void genStock(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(0,0,this.getWidth(),this.getHeight());
		g.setColor(Color.white);
		String s = Integer.toString((int)(Math.random()*200));
		
		g.drawString(s, 200,250);
		
	}
	private void GenAcct(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(0,0,this.getWidth(),this.getHeight());
		g.setColor(Color.white);
		String s = Integer.toString((int)(Math.random()*200));
		
		g.drawString(s, 200,250);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		clickLocation = e.getLocationOnScreen();
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}