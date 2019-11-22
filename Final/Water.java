import java.awt.Color;
import java.awt.Graphics;


public class Water{

    private int x;
    private int y;
    private Color white;

    public Water(){
        x = (int)(Math.random()*800);
        y = (int)(Math.random()*600);
        white = new Color(255,255,255);
    }

    public void drawMe(Graphics g){
        g.setColor(white);
        g.fillRect(x,y,2,2);
    }

    public void moveRight(){
        x--;

        if( x < 0 ){
            x=800;
            y = (int)(Math.random()*800);
        }

    }

    public void moveLeft(){
        x++;

        if( x > 800 ){
            x=0;
            y = (int)(Math.random()*800);
        }

    }


}
