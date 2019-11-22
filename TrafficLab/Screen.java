import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Screen extends JPanel{

	private ArrayList<Automobile> carList;
	private Color background;
	private BufferedImage roads;

	public Screen(){
		carList = new ArrayList<Automobile>();
		carList.add(new Truck(Color.blue, (int)(Math.random() * 1000),275));
		carList.add(new Sedan(Color.cyan, (int)(Math.random() * 1000),500));
		carList.add(new SportsCar(Color.gray, (int)(Math.random() * 1000),275));
		carList.add(new SUV(Color.red, (int)(Math.random() * 1000),500));
		carList.add(new Truck(Color.blue, (int)(Math.random() * 1000),275));
		carList.add(new Sedan(Color.cyan, (int)(Math.random() * 1000),500));
		carList.add(new SportsCar(Color.gray, (int)(Math.random() * 1000),500));
		carList.add(new SUV(Color.red, (int)(Math.random() * 1000),275));
		carList.add(new Truck(Color.blue, (int)(Math.random() * 1000),275));
		carList.add(new Sedan(Color.cyan, (int)(Math.random() * 1000),275));
		carList.add(new SportsCar(Color.gray, (int)(Math.random() * 1000),500));
		carList.add(new SUV(Color.red, (int)(Math.random() * 1000),500));
		carList.add(new Truck(Color.blue, (int)(Math.random() * 1000),500));
		carList.add(new Sedan(Color.cyan, (int)(Math.random() * 1000),275));
		carList.add(new SportsCar(Color.gray, (int)(Math.random() * 1000),275));
		carList.add(new SUV(Color.red, (int)(Math.random() * 1000),500));
		carList.add(new Truck(Color.blue, (int)(Math.random() * 1000),500));
		carList.add(new Sedan(Color.cyan, (int)(Math.random() * 1000),275));
		carList.add(new SportsCar(Color.gray, (int)(Math.random() * 1000),500));
		carList.add(new SUV(Color.red, (int)(Math.random() * 1000),275));


		try {
            roads = ImageIO.read(new File("imgs/roads.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

	}

	public Dimension getPreferredSize(){
		return new Dimension(800,600);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//draw background
		g.setColor( background);
		g.fillRect(0,0,800,600);

		g.drawImage(roads, 0, 0, null);

		//draw cars
		for(int i = 0; i<carList.size(); i++){
			carList.get(i).drawMe(g);
		}

	}

	public void animate(){
	    while(true){
	      for(int i = 0;i<carList.size();i++){
					if(carList.get(i).getSpeed() == 1)
	        	carList.get(i).move1();
					else if(carList.get(i).getSpeed() == 2)
						carList.get(i).move2();
					else if(carList.get(i).getSpeed() == 3)
						carList.get(i).move3();
					else if(carList.get(i).getSpeed() == 5)
						carList.get(i).move4();


					if(carList.get(i).getX()<= -300)
						carList.get(i).setX(1100);

					if(carList.get(i).getX() == 270 && i%4 == 0){
						if(carList.get(i).getY() == 275)
							carList.get(i).moveUp();
						if(carList.get(i).getY() == 500)
							carList.get(i).moveDown();
					}
	      }
	        try {
	                Thread.sleep(20);
	            } catch(InterruptedException ex) {
	                Thread.currentThread().interrupt();
	            }
	      repaint();
	    }
	  }



}
