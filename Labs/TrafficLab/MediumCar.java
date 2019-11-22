import java.awt.Graphics;
import java.awt.Color;
public class MediumCar extends Automobile{
  public MediumCar(Color bodyColor, int x, int y, int speed){
    super(bodyColor,x,y, speed);
  }


  @Override
  public void drawFrame(Graphics g){
    super.drawFrame(g);
    g.setColor(Color.yellow);
    g.fillOval(getX()-5, getY()+ 10, 13,13);
    int[] xArray = new int[4];
 	  int[] yArray = new int[4];

 	  xArray[0] = getX() + 20;
 	  yArray[0] = getY();

 	  xArray[1] = getX() + 60;
 	  yArray[1] = getY();

    xArray[2] = getX() + 60;
 	  yArray[2] = getY() - 20;

 	  xArray[3] = getX() + 30;
 	  yArray[3] = getY() - 20;



    g.setColor(Color.black);
 	  g.drawPolygon(xArray, yArray, 4);

    xArray[0] = getX() + 60;
 	  yArray[0] = getY();

 	  xArray[1] = getX() + 90;
 	  yArray[1] = getY();

    xArray[2] = getX() + 80;
    yArray[2] = getY() - 20;

 	  xArray[3] = getX() + 60;
 	  yArray[3] = getY() - 20;


    g.drawPolygon(xArray, yArray, 4);

  }

  @Override
  public void drawWheels(Graphics g){
    super.drawWheels(g);
    g.setColor(Color.gray);
    g.fillOval(getX()+15,getY()+30, 15, 15);
    g.fillOval(getX()+70,getY()+30, 15, 15);
  }
}
