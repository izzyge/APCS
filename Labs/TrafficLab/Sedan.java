import java.awt.Graphics;
import java.awt.Color;
public class Sedan extends MediumCar{

	public Sedan(Color bodyColor, int x, int y){
		super(bodyColor, x, y, 3);
  	}

  @Override
  public void drawFrame(Graphics g){
   super.drawFrame(g);

   g.setColor(getBodyColor() );

   g.setColor(Color.black);
   g.drawLine(getX() + 20, getY(), getX()+ 25, getY() +25);
   g.drawLine(getX() + 60, getY(), getX()+ 55, getY()+40);
   g.drawLine(getX() + 90, getY(), getX() + 80, getY() + 25);


  }


}
