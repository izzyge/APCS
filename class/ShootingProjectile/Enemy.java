import java.awt.Color;
import java.awt.Graphics;

public class Enemy{
  private int x;
  private int y;

  private int width;
  private int height;

  private Color red;

  public Enemy(int x, int y){
    this.x = x;
    this.y = y;
    this.width = 30;
    this.height = 30;
    this.red = new Color(255,0,0);
  }

  public void drawMe(Graphics g){
    g.setColor(red);
    g.fillRect(x,y,width,height);
  }
}
