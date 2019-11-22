import java.awt.Color;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Character{
  private int x;
  private int y;
  private int width;
  private int height;
  BufferedImage img;
  private boolean visible;
  private boolean active;

  public Character(int x, int y, BufferedImage img){
    this.x = x;
    this.y = y;
    width = 40;
    height = 40;
    this.img = img;
    visible = true;
    active = false;
    
  }

  public boolean getActive(){
    return active;
  }

  public void setActive(){
    active = true;
  }


  public void drawMe(Graphics g){
    g.drawImage(img, x, y, width, height, null);
  }

  public void drawMe2(Graphics g,int width, int height){
    g.drawImage(img, x, y, width, height, null);
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


  public boolean checkCollision2(Player p){


    int px = ((int)Math.round(p.getX()));
    int py =((int)Math.round(p.getY()));
    int pWidth = p.getWidth();
    int pHeight = p.getHeight();
    if( px + pWidth >= x && px <= x + width
    && py + pHeight >= y && py <= y + height ){
      return true;


      }


      return false;
    }
}
