import java.awt.Color;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Player{
	private int x;
	private int y;

	private int width;
	private int height;

	private Color blue;
	BufferedImage panda;

	public Player(int x, int y){

		this.x = x;
		this.y = y;

		this.width = 100;
		this.height = 120;

		this.blue = new Color(0,0,255);

		try {
      panda= ImageIO.read(new File("panda.png"));
    } catch (IOException ex){

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
