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
	private int dx;

	private int width;
	private int height;


  private BufferedImage nemo;


	public Player(int x, int y){

    this.x = x;
    this.y = y;
		dx = 10;
		width = 100;
		height = 100;
		try {
      nemo= ImageIO.read(new File("imgs/nemo.png"));
    } catch (IOException ex){

    }


	}

	public void playSound(){

	}



	public void drawMe(Graphics g){
    g.drawImage(nemo,x,y,width,height,null);
	}

	public void moveUp(){
		y = y - 15;
	}

	public void moveDown(){
		y = y + 15;
	}

  public void moveRight(){
    x = x + dx;
  }

	public void setDX(){
		dx = 20;
	}

  public void moveLeft(){
    x = x - dx;
  }

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

  public void setX(int x){
    this.x = x;
  }

  public void setY(int y){
    this.y = y;
  }

	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}




}
