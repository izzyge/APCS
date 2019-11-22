import java.awt.Graphics;
import java.awt.Color;
public class SportsCar extends MediumCar{

	public SportsCar(Color bodyColor, int x, int y){
		super(bodyColor, x, y,5);
  }

  @Override
  public void drawFrame(Graphics g){
   super.drawFrame(g);

   g.setColor(getBodyColor() );

   g.setColor(Color.black);
   g.drawLine(getX() + 20, getY(), getX()+ 25, getY() +25);
   g.drawLine(getX() + 60, getY(), getX()+ 55, getY()+40);



  }


}
