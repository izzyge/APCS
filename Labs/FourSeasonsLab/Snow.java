import java.awt.Color;
import java.awt.Graphics;


public class Snow{

    private int x;
    private int y;
    private Color white;

    public Snow(){
        x = (int)(Math.random()*800);
        y = (int)(Math.random()*600);
        white = new Color(255,255,255);
    }

    public void drawMe(Graphics g){
        g.setColor(white);
        g.fillRect(x,y,2,5);
    }

    public void move(){
        y++;

        if( y > 600 ){
            y = 0;
            x = (int)(Math.random()*800);
        }

    }


}
