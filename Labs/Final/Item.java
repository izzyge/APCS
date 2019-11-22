import java.awt.Color;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public abstract class Item{
  private int x;
  private int y;
  private int width;
  private int height;
  BufferedImage img;
  private boolean visible;
  private int scene;

  public Item(int x, int y, BufferedImage img, int scene){
    this.x = x;
    this.y = y;
    this.width = 60;
    this.height = 60;
    this.img = img;
    visible = true;
    this.scene = scene;
  }


  public void drawMe(Graphics g){
    if(visible)
      g.drawImage(img, x, y, width, height, null);
  }

  public void drawMe2(Graphics g,int x,int y, int width, int height){
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

  public int getScene(){
    return scene;
  }

  public void setVisible(boolean vis){
    visible = vis;
  }

  public boolean returnVisible(){
    return visible;
  }


  public boolean checkCollision(Player p){

  if(visible == true){
    int px = ((int)Math.round(p.getX()));
    int py =((int)Math.round(p.getY()));
    int pWidth = p.getWidth();
    int pHeight = p.getHeight();
    if( px + pWidth >= x && px <= x + width
    && py + pHeight >= y && py <= y + height ){
      visible = false;
      return true;


      }

      }
      return false;
    }
}
