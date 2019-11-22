
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;



public class Screen extends JPanel {
	int moonX;
	int topX;
	int bottomX;
	int wheel1X;
	int wheel2X;
	double t;
	double pi;
	int xBird;
	double yBird;
	double radBird;




	public Screen(){
		moonX = 0;
		topX = 700;
		bottomX = 650;
		wheel1X = 665;
		wheel2X = 790;
		t = 3.14;
		pi = 3.14;
		xBird = 0;
		yBird = 0;
		radBird = 0;

	}

	public Dimension getPreferredSize(){
		return new Dimension(800,600);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Color yellow = new Color(255,255,0);
		Color green = new Color(0,255,0);
		Color white = new Color(255,255,255);
		Color black = new Color(0,0,0);
		Color lightgray = new Color(178,178,178);
		Color gray = new Color(119, 96, 80);
		Color grayblue = new Color(114, 144, 193);


		Color darkOrange = new Color(188, 88, 0);
		//background
		g.setColor(darkOrange);
		g.fillRect(0,0,800,600);

		//moon animated
		g.setColor(white);
		g.fillOval((int)(200*Math.cos(t-pi)+395),(int)(400*Math.sin(t-pi)+400),100,100);
		g.setColor(darkOrange);
		g.fillOval((int)(200*Math.cos(t-pi)+445),(int)(400*Math.sin(t-pi)+400),90,90);


		//ground
		g.setColor(gray);
		g.fillRect(0,400,800,200);

		//road
		g.setColor(lightgray);
		g.fillRect(0,470,800,50);
		//lane divider
		int dividerX = 0;
		g.setColor(yellow);
		while(dividerX<800){
			g.fillRect(dividerX,495,20,5);
			dividerX += 35;
		}

		//fence
		int fenceX=0;
		g.setColor(black);
		while(fenceX < 800){
			g.fillRect(fenceX,325,20,75);

			fenceX = fenceX + 40;
		}
		g.fillRect(0,340,800,10);

		//house
		g.fillRect(75,220,100,180);
		g.fillRect(175,275,100,125);
		g.fillRect(275,200,75,200);

		int[] xArray1 = new int[3];
        int[] yArray1 = new int[3];
        //Point 1
        xArray1[0] = 70;
        yArray1[0] = 220;
        //Point 2
        xArray1[1] = 125;
        yArray1[1] = 150;
        //Point 3
        xArray1[2] = 180;
        yArray1[2] = 220;
        g.fillPolygon(xArray1, yArray1, 3);


		int[] xArray2 = new int[3];
        int[] yArray2 = new int[3];
        //Point 1
        xArray2[0] = 270;
        yArray2[0] = 200;
        //Point 2
        xArray2[1] = 310;
        yArray2[1] = 150;
        //Point 3
        xArray2[2] = 355;
        yArray2[2] = 200;
        g.fillPolygon(xArray2, yArray2, 3);


		//bird

		g.setColor(black);
		int[] xTail = new int[3];
		int[] yTail = new int[3];
		xTail[0] = 0+xBird;
    	yTail[0] = (int)(162+yBird);
    	xTail[1] = 25+xBird;
    	yTail[1] = (int)(150+yBird);
    	xTail[2] = 25+xBird;
    	yTail[2] = (int)(175+yBird);
    	g.fillPolygon(xTail, yTail, 3);
    	int[] xHead = new int[3];
    	int[] yHead = new int[3];
    	xHead[0] = 75+xBird;
    	yHead[0] = (int)(150+yBird);
    	xHead[1] = 88+xBird;
    	yHead[1] = (int)(162+yBird);
    	xHead[2] = 75+xBird;
    	yHead[2] = (int)(175+yBird);
    	g.fillPolygon(xHead, yHead, 3);
    	g.fillRect(25+xBird,(int)(150+yBird),50,25);
    	g.fillRect(50+xBird,(int)(130+yBird),15,20);
    	g.fillRect(50+xBird,(int)(170+yBird),15,20);
    	int[] xWing1 = new int[3];
    	int[] yWing1 = new int[3];
    	xWing1[0] = 30+xBird;
    	yWing1[0] = (int)(100+yBird);
    	xWing1[1] = 50+xBird;
    	yWing1[1] = (int)(130+yBird);
    	xWing1[2] = 65+xBird;
    	yWing1[2] = (int)(130+yBird);
    	g.fillPolygon(xWing1, yWing1, 3);
    	int[] xWing2 = new int[3];
    	int[] yWing2 = new int[3];
    	xWing2[0] = 30+xBird;
    	yWing2[0] = (int)(225+yBird);
    	xWing2[1] = 50+xBird;
    	yWing2[1] = (int)(190+yBird);
    	xWing2[2] = 65+xBird;
    	yWing2[2] = (int)(190+yBird);
    	g.fillPolygon(xWing2, yWing2, 3);





		//car
		g.setColor(grayblue);
		g.fillRect(bottomX,390,200,75);
		g.fillOval(topX,350,120,100);
		g.setColor(black);
		g.fillOval(wheel1X,450,50,50);
		g.fillOval(wheel2X,450,50,50);
	}


	public void animate(){
		while(true){
			moonX ++;
			bottomX --;
			topX --;
			wheel1X --;
			wheel2X --;
			t=t+(pi/96);
			xBird += 5;
			radBird += 2;
			// yBird = 50*Math.cos(radBird*(pi/96));



			//making it slower
			try{
				Thread.sleep(20); //milliseconds
			}
			catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

			repaint();
		}
	}
}
