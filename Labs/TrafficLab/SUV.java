import java.awt.Graphics;
import java.awt.Color;
public class SUV extends BigCar{

	public SUV(Color bodyColor, int x, int y){
		super(bodyColor, x, y,2);
  	}

  @Override
  public void drawFrame(Graphics g){
   super.drawFrame(g);

   g.setColor(getBodyColor() );

   g.setColor(Color.black);
   int[] xArray = new int[4];
   int[] yArray = new int[4];

   xArray[0] = getX() + 80;
    yArray[0] = getY();

    xArray[1] = getX() + 110;
    yArray[1] = getY();

   xArray[2] = getX() + 100;
   yArray[2] = getY() - 30;

    xArray[3] = getX() + 80;
    yArray[3] = getY() - 30;


   g.drawPolygon(xArray, yArray, 4);

   g.setColor(Color.black);
   g.drawLine(getX() + 20, getY(), getX()+ 25, getY() +30);
   g.drawLine(getX() + 80, getY(), getX()+65, getY()+45);
   g.drawLine(getX() + 110, getY(), getX() + 95, getY() + 40);


  }


}
