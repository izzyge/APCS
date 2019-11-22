import java.awt.Graphics;
import java.awt.Color;
public class BigCar extends Automobile{
  public BigCar(Color bodyColor, int x, int y, int speed){
    super(bodyColor,x,y, speed);
  }


  @Override
  public void drawFrame(Graphics g){
    super.setWidth(120);
    super.setHeight(45);
    super.drawFrame(g);

    g.setColor(Color.yellow);
    g.fillOval(getX()-5, getY()+ 10, 13,13);

    g.setColor(Color.black);
    int[] xArray = new int[4];
 	  int[] yArray = new int[4];

 	  xArray[0] = getX() + 20;
 	  yArray[0] = getY();

 	  xArray[1] = getX() + 80;
 	  yArray[1] = getY();

    xArray[2] = getX() + 80;
 	  yArray[2] = getY() - 30;

 	  xArray[3] = getX() + 35;
 	  yArray[3] = getY() - 30;

    g.drawPolygon(xArray, yArray, 4);





  }

  @Override
  public void drawWheels(Graphics g){
    g.setColor( Color.black );
		g.fillOval(getX()+15,getY()+30, 30, 30);
		g.fillOval(getX()+70,getY()+30, 30, 30);
    g.setColor(Color.gray);
    g.fillOval(getX()+23,getY()+38, 15, 15);
    g.fillOval(getX()+78,getY()+38, 15, 15);
  }
}
