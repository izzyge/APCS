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
	BufferedImage bamboo;

	public Target(int x, int y){

		this.x = x;
		this.y = y;

		this.width = 60;
		this.height = 50;

		this.green = new Color(0,255,00);
		this.visible = true;

		try {
      bamboo= ImageIO.read(new File("bamboo.png"));
    } catch (IOException ex){

    }
	}


	public void drawMe(Graphics g){
		if(visible){
			g.drawImage(bamboo,x,y,width,height,null);
		}
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
		}
	}

	}

	public boolean getVisible(){
		return visible;
	}

	public int getY(){
		return y;
	}

	public void animate(){
		y++;
		if( y > 600 ){
				y = 0;
		}
	}

	public void animate2(){
		y--;
		if( y <0 ){
				y = 600;
		}
	}




}
