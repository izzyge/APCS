import java.awt.Graphics;
import java.awt.Color;
public class Truck extends BigCar{

	public Truck(Color bodyColor, int x, int y){
		super(bodyColor, x, y,1);
  	}

  @Override
  public void drawFrame(Graphics g){
   super.drawFrame(g);

   g.setColor(getBodyColor() );


   g.setColor(Color.black);
   g.drawLine(getX() + 20, getY(), getX()+ 25, getY() +30);
   g.drawLine(getX() + 80, getY(), getX()+65, getY()+45);



  }


}
