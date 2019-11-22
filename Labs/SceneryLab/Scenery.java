import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

public class Scenery extends JPanel{
	
	private int background;
	private int clouds;
	
	public Scenery(int b, int c){ 		//1 = day, 2 = night
		background = b;
		clouds = c;
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(800,600);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if(background == 1){
			Color lightBlue = new Color(108,206,209);
			g.setColor(lightBlue);
			g.fillRect(0,0,800,600);
		}
		
		if(background == 2){
			Color darkBlue = new Color(24,42,132);
			g.setColor(darkBlue);
			g.fillRect(0,0,800,600);
		}
		
		if(clouds == 1){
			Color white = new Color(255,255,255);
			g.setColor(white);
			g.fillOval(0,0,250,100); //clouds left to right
			g.fillOval(130,70,250,100);
			g.fillOval(330,50,250,100);
			g.fillOval(550,0,250,100);
		}
		
		//Buildings
		Color lightGray = new Color(209,209,209);
		Color darkGray = new Color(99,99,99);
		Color black = new Color(0,0,0);
		
			g.setColor(lightGray);
			g.fillRect(0,250,175,350);
			
			for(int i=0; i<8; i++){
				g.setColor(black);
				g.fillRect(20,270 + (40*i),20,20);
			}
			
			for(int i=0; i<8; i++){
				g.setColor(black);
				g.fillRect(70,270 + (40*i),20,20);
			}
			
			for(int i=0; i<8; i++){
				g.setColor(black);
				g.fillRect(120,270 + (40*i),20,20);
			}
			
			Color colorBrown = new Color(79,20,3);
			g.setColor(colorBrown);
			g.fillRect(290,425,50,200);
			
			Color colorGreen = new Color(0,249,108);
			g.setColor(colorGreen);
			g.fillOval(220, 370, 100, 100);
			g.setColor(colorGreen);
			g.fillOval(210, 300, 100, 100);
			g.setColor(colorGreen);
			g.fillOval(270, 285, 100, 100);
			g.setColor(colorGreen);
			g.fillOval(290, 370, 100, 100);
			g.setColor(colorGreen);
			g.fillOval(330, 300, 100, 100);
			

	            //Flower 1
	        g.setColor(colorGreen);  //stem
	        g.fillRect(410, 550, 10, 100);


	        g.setColor(Color.PINK); //petals
	        g.fillOval(394, 470, 40, 40);
	        g.fillOval(420, 490, 40, 40);
	        g.fillOval(410, 520, 40, 40);
	        g.fillOval(380, 520, 40, 40);
	        g.fillOval(370, 490, 40, 40);

	        g.setColor(Color.YELLOW);  //middle
	        g.fillOval(402, 505, 25, 25);
	        
	        g.setColor(Color.RED);
	        g.fillRect(640, 440, 70, 50);
	        g.fillRect(625, 485, 120, 80);
	        
	        g.setColor(Color.BLACK);
	        g.fillOval(700, 555, 30, 30);
	        g.fillOval(625, 555, 30, 30);
	        
	        g.setColor(Color.ORANGE);
	        g.fillOval(625, -20, 225, 225);
	        g.setColor(Color.YELLOW);
	        g.fillOval(650, -20, 200, 200);
	        
	      


		
	}
}

