import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;



public class Screen extends JPanel {
	Houses h1;
	Houses h2;
	Buildings b1;
	Buildings b2;
	Trees t1;
	Trees t2;
	Trees t3;

	int moonX;
	double t;
	int r;
	int gValue;
	int b;
	int skyTime;

	public Screen(){

		//sets up the instance variables
		h1 = new Houses(600,400,3,4);
		h2 = new Houses(50,300,2,3);
		b1 = new Buildings(50,400,2,4);
		b2 = new Buildings(275,500,1,4);
		t1 = new Trees(600,535,1,6);
		t2 = new Trees(600, 290, 2, 4);
		t3 = new Trees(275,300,4,5);
		moonX = 0;
		t = 3.14;
		r = 66;
		gValue = 137;
		b = 219;
		skyTime = 0;

	}

	public Dimension getPreferredSize() {
		//Sets the size of the panel
        return new Dimension(800,600);
	}

	public void paintComponent(Graphics g) {
        super.paintComponent(g);

				Color sky = new Color(r,gValue,b);
				g.setColor(sky);
				g.fillRect(0,0,800,250);

				double moonX = 200*Math.cos(t-3.14)+395;

				g.setColor(Color.white);
				g.fillOval((int)moonX,(int)(400*Math.sin(t-3.14)+400),40,40);


				g.setColor(Color.yellow);
				g.fillOval((int)((410*Math.cos(t)+400)),(int)(410*Math.sin(t)+405),40,40);


				Color ground = new Color(84, 96, 84);
				g.setColor(ground);
				g.fillRect(0,250, 800,350);

				Color street = new Color(104, 103, 100);
				g.setColor(street);
				g.fillRect(220,250,25,350);
				g.fillRect(530,250,25,350);

				for(int i=0; i<18;i++){
					g.setColor(Color.yellow);
					g.fillRect(230, 250 + (i*20), 5,10);
				}
				for(int i=0; i<18;i++){
					g.setColor(Color.yellow);
					g.fillRect(540, 250 + (i*20), 5,10);
				}


				//houses
				h1.drawMe(g);
				h2.drawMe2(g);
				b1.drawMe(g);
				b2.drawMe2(g);
				t1.drawMe(g);
				t2.drawMe2(g);
				t3.drawMe3(g);

	}

	public void animate(){
		while(true){
			t=t+(3.14/96);
			moonX ++;
			skyTime++;

			try{
				Thread.sleep(30); //milliseconds
			}
			catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			skyTime+=.25;
			if(skyTime==0 || skyTime==188){
				r = 135;
				gValue = 206;
				b = 235;
			}
			if(skyTime==28 || skyTime==216){
				r = 66;
				gValue = 137;
				b = 219;
			}
			if(skyTime==58 || skyTime==246){
				r = 0;
				gValue = 102;
				b = 204;
			}
			if(skyTime==92 || skyTime==280){
				r = 45;
				gValue = 72;
				b = 178;
			}
			if(skyTime==122 || skyTime==315){
				r = 40;
				gValue = 40;
				b = 148;
			}
			if(skyTime==156 || skyTime==360){
				r = 16;
				gValue = 98;
				b = 179;
			}

			if(skyTime>360){
				skyTime = 0;
			}


			repaint();
		}
	}

}
