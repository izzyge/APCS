import java.awt.Color;
import java.awt.Graphics;


public class Trees{

    private int x;
    private int y;
    private Color brown;
    private Color green;
    private Color fall;

    public Trees(){
        x = (int)(Math.random()*800);
        y = (int)(Math.random()*230 + 260);
        brown = new Color(124, 79, 49);
        green = new Color(48, 153, 59);
        fall = new Color(188, 99, 43);
    }

    public void drawMeGreen(Graphics g){
        g.setColor(brown);
        g.fillRect(x,y,15,40);
        g.setColor(green);
        g.fillRect(x-7,y-10,30,30);
    }

    public void drawMeOrange(Graphics g){
        g.setColor(brown);
        g.fillRect(x,y,15,40);
        g.setColor(fall);
        g.fillRect(x-7,y-10,30,30);
    }

    public void drawMeBrown(Graphics g){
      g.setColor(brown);
      g.fillRect(x,y,15,40);
    }


}
