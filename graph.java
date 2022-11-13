package test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
public class graph {

	

	 class GraphOld extends JComponent{
	    private static JFrame window = new JFrame();
	    private static boolean start = false;
	    public static String function;

	    public static HashMap<Integer, Double> stockP = new HashMap<>();

	    public static void main(String[] args) {
	        window.setTitle("Graph");
	        window.setSize(1000, 700);
	        window.setVisible(true);
	        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        GraphOld graph = new GraphOld();
	        window.add(graph);

	        JFrame promptWindow = new JFrame();
	        JTextField textInput = new JTextField();
	        Button enter = new Button();

	        promptWindow.setTitle("Prompt");
	        promptWindow.setLocation(1000, 0);
	        promptWindow.setSize(200, 200);
	        promptWindow.setVisible(true);

	        enter.setLabel("Graph it");
	        enter.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent actionEvent) {
	                textInput.setBackground(Color.GREEN);
	                function = textInput.getText();
	                if (function.contains(":")){
	                    function = function.substring(function.indexOf(":") + 2);
	                    System.out.println("y = " + function);
	                }
	                start = true;
	                try {
	                    TimeUnit.MILLISECONDS.sleep(1);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                //textInput.setBackground(Color.LIGHT_GRAY);
	            }
	        });
	        enter.setSize(200, 50);
	        enter.setBackground(Color.MAGENTA);

	        textInput.setText("Enter function: ");
	        textInput.setBackground(Color.LIGHT_GRAY);
	        textInput.setSize(200, 200);

	        promptWindow.add(textInput);
	        promptWindow.add(enter);

	    }

	    public void paint(Graphics graph0) {
	        Graphics2D graph = (Graphics2D) graph0;
	        instantiateGraph(graph);
	        if (start){
	            createStockGraph(graph);
	        }

	        try {
	            TimeUnit.MILLISECONDS.sleep(1);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        repaint();
	    }

	    public void createStockGraph(Graphics2D graph){
	        createStockPriceData();
	        graph.setColor(Color.LIGHT_GRAY);
	        int inc = 35;
	        for(int i = 0; i < window.getWidth(); i += inc){
	            int x = i;
	            int y = (int) getStockPriceAt(x);

	            if(i > 0) {

	                if ((int) getStockPriceAt(x - inc) > (int) getStockPriceAt(x)) {
	                    graph.setColor(Color.GREEN);
	                } else {
	                    graph.setColor(Color.RED);
	                }
	                graph.drawLine(x-inc + 5,(int)(getStockPriceAt(x-inc)) + 20, x + 5, (int)(getStockPriceAt(x)) + 20);
	            }




	            graph.fill(new Rectangle(x, y, 10, 45));
	        }

	    }

	    public static void createStockPriceData(){
	        try {
	            File fileRead = new File("C:\\Users\\Suneetha\\IdeaProjects\\graphics_0\\src\\com\\Apps\\Desmos\\stockPrices.txt");
	            Scanner scan = new Scanner(fileRead);
	            while (scan.hasNextLine()) {
	                stockP.put(scan.nextInt(), scan.nextDouble());
	            }
	            scan.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }
	    }
	    public static double getStockPriceAt(int time){
	        return stockP.get(time);
	    }

	    private static void instantiateGraph(Graphics2D graph){
	        defineTitles(graph);

	        graph.setStroke(new BasicStroke(3));
	        graph.drawLine(0,  (int)(window.getHeight()*0.9), windowGetWidth(), (int)(window.getHeight()*0.9));
	        graph.drawLine((int)(window.getWidth()*0.05), 0, (int)(window.getWidth()*0.05), windowGetHeight());
//	        graph.drawLine(window.getWidth() / 2, 0, window.getWidth() / 2, window.getHeight());
//	        graph.drawLine(0, window.getHeight() / 2, window.getWidth(), window.getHeight() / 2);

	        graph.setStroke(new BasicStroke(1));
	        graph.setColor(Color.LIGHT_GRAY);
	        for (int i = 0; i < window.getWidth(); i += window.getWidth() / 20){
	            graph.drawLine(i, 0, i, window.getHeight());
	        }
	        for (int i = 0; i < window.getHeight(); i += window.getHeight() / 20){
	            graph.drawLine(0, i, window.getWidth(), i);
	        }
	    }

	    public static void defineTitles(Graphics2D graph){
	        JTextField text = new JTextField();
	        text.setPreferredSize(new Dimension(300,100));
	        window.add(text);
	        text.setVisible(true);
	    }
	    public static int windowGetWidth(){
	        return window.getWidth();
	    }

	    public static int windowGetHeight(){
	        return window.getHeight();
	    }

	}
}
