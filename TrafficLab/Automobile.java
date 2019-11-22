import java.awt.Graphics;
import java.awt.Color;

public class Automobile{

	private Color bodyColor;
	private int speed;
	private int x = 100;
	private int y = 100;
	private int width;
	private int height;


	public Automobile(Color bodyColor, int x, int y, int speed){

		this.bodyColor = bodyColor;
		this.x = x;
		this.y = y;
		this.width = 100;
		this.height = 40;
		this.speed = speed;
	}


	public void drawMe(Graphics g){

		this.drawFrame(g);
		this.drawWheels(g);
	}

	public void drawFrame(Graphics g){
		g.setColor( bodyColor );
		g.fillRect(x,y,width,height);
	}

	public void drawWheels(Graphics g){
		g.setColor( Color.black );
		g.fillOval(x+10,y+25, 25, 25);
		g.fillOval(x+65,y+25, 25, 25);
	}

	public void move1(){
  	x-=2;
  }

	public void move2(){
  	x-=3;
  }

	public void move3(){
  	x-=5;
  }

	public void move4(){
  	x-= 7;
  }

	public void moveUp(){

			y++;
	}

	public void moveDown(){

			y--;
	}


	public void setWidth(int width){
		this.width = width;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getX(){
		return x;
	}

	public void setX(int x){
		this.x = x;
	}

	public int getY(){
		return y;
	}

	public Color getBodyColor(){
		return bodyColor;
	}

	public int getHeight(){
		return height;
	}

	public int getSpeed(){
		return speed;
	}

}
