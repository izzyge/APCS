import java.awt.Color;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Target{
	private int x;
	private int y;

	private int width;
	private int height;

	private Color green;
	boolean visible;
	BufferedImage asteroid;

	public Target(int x, int y){

		this.x = x;
		this.y = y;

		this.width = 50;
		this.height = 40;

		this.green = new Color(0,255,00);
		this.visible = true;

		try {
      asteroid= ImageIO.read(new File("img/asteroid.png"));
    } catch (IOException ex){

    }
	}


	public void drawMe(Graphics g){
		if(visible){
			g.drawImage(asteroid,x,y,width,height,null);
		}
	}

	public void playSound(){
		Sound.playSound("sound/Ding.wav");
	}

	public void checkCollision(Projectile p){
		if(visible){
			int pX = p.getX();
			int pY = p.getY();
			int pWidth = p.getWidth();
			int pHeight = p.getHeight();

			if(pX+pWidth >= x && pX <= x + width
				&&  pY+pHeight >= y && pY <= y + height){
				// System.out.println("Collision");
				visible = false;
				this.playSound();

		}
	}

	}

	public void move(){
		x--;
		if(x<0){
			x=800;
		}
	}

	public boolean getVisible(){
		return visible;
	}

	public void setVisible(){
		visible = true;
	}

	public void setNotVisible(){
		visible = false;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}

	public void animate(){
		y++;
		if(y>570){
			y=0;
		}

	}

	public void animate2(){
		y--;
		if(y<30){
			y=600;
		}

	}

	public void setX(int x) {
		this.x = x;
	}




}
