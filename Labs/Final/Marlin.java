import java.awt.Color;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Marlin extends Character{

  private String message1;
  private String message2;
  private String message3;

  public Marlin(int x, int y, BufferedImage char3){
    super(x, y, char3);
    message1 = "Nemo you found me!!";
    message2 = "Sadly, we are stuck in this tank now";
    message3 = "Can you get us out of here? Use number keys to access items in inventory!";

  }

  public void changeMessage(){
    message1 = "We're free!!";
    message2 = "Thanks for finding me Nemo";
    message3 = "";
  }

  public void conversation(Graphics g){
    if(this.getActive()){
      g.setColor(Color.white);
      g.drawString(message1, getX() + 100, getY());
      g.drawString(message2, getX()+100, getY()+30);
      g.drawString(message3, getX()+100, getY()+60);
    }
  }

}
