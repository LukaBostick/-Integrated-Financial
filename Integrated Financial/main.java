package test;

import java.io.FileNotFoundException;

import javax.swing.JFrame;



public class Main {

	static final int SCREEN_WIDTH = Constraints.SCREEN_WIDTH_X;

	static final int SCREEN_HEIGHT = Constraints.SCREEN_HEIGHT_Y;
	
	static final String NAME = Constraints.PROGRAM_NAME; 
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		initFrame(NAME,SCREEN_WIDTH,SCREEN_HEIGHT);
	}
	
	public static void initFrame(String name, int width, int height) throws FileNotFoundException, InterruptedException
	{
		JFrame frame = new JFrame(name);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		BankingPanel panel = new BankingPanel(width,height);
		frame.add(panel);
		frame.setVisible(true);
		frame.setResizable(false);
		panel.preSimulationLoop();
	}
}