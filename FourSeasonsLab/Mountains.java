import java.awt.Color;
import java.awt.Graphics;


public class Mountains{

    private int x;
    private int y;
    private Color grey;
    private Color white;

    public Mountains(){
        x = (int)(Math.random()*600);
        y = 300;
        grey = new Color(137, 128, 114);
        white = new Color(255,255,255);
    }

    public void drawMe(Graphics g){
        int[] xArray = new int[3];
        int[] yArray = new int[3];
        xArray[0] = x;
        yArray[0] = y;
        xArray[1] = x+150;
        yArray[1] = y;
        xArray[2] = x+80;
        yArray[2] = 170;
        g.setColor(grey);

        g.fillPolygon(xArray, yArray, 3);

    }
    public void drawMeWinter(Graphics g){
        int[] xArray2 = new int[3];
        int[] yArray2 = new int[3];
        xArray2[0] = x+51;
        yArray2[0] = y-80;
        xArray2[1] = x+106;
        yArray2[1] = y-80;
        xArray2[2] = x+80;
        yArray2[2] = 170;
        g.setColor(white);
        g.fillPolygon(xArray2, yArray2, 3);

    }
}
