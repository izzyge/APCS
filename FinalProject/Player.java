import java.awt.Color;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Player{
	int lives;
	private int x;
	private int y;

	private int width;
	private int height;

	private Color blue;
	BufferedImage panda;

	public Player(int x, int y){
		lives = 3;
		this.x = x;
		this.y = y;

		this.width = 120;
		this.height = 90;

		this.blue = new Color(0,0,255);

		try {
      panda= ImageIO.read(new File("img/panda.png"));
    } catch (IOException ex){

    }


	}

	public void playSound(){
		Sound.playSound("sound/loselife.mp3");
	}

	public void checkCollision(Target t){
			int tX = t.getX();
			int tY = t.getY();
			int tWidth = t.getWidth();
			int tHeight = t.getHeight();

			if(tX+tWidth >= x && tX <= x + width
				&&  tY+tHeight >= y && tY <= y + height && t.visible == true){

						lives--;
						t.setX(800);
						this.playSound();

	}

	}


	public void drawMe(Graphics g){
		g.drawImage(panda,x,y,width,height,null);
	}

	public void moveUp(){
		y = y - 10;
	}

	public void moveDown(){
		y = y + 10;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}


}
