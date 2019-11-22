import java.awt.Color;
import java.awt.Graphics;

public class Projectile{
    private int x;
    private int y;

    private int width;
    private int height;

    private Color red;
    private boolean visible;


    public Projectile(int x, int y){

        this.x = x;
        this.y = y;

        this.width = 10;
        this.height = 10;

        this.red = new Color(255,0,0);
        this.visible = false;


    }


    public void drawMe(Graphics g){

        if( visible ){
        g.setColor(red);
        g.fillOval(x,y,width,height);
        }

    }


    public void moveRight(){
      if( visible ){
        x++;
      }

      if(x > 800){
        visible = false;
      }
    }

    public void setVisible(boolean visible){
      this.visible = visible;
    }

    public void setPosition(int x, int y){
      if(visible == false){
        this.x = x;
        this.y = y;
      }
    }






}
