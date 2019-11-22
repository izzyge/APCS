import java.awt.Color;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Crab extends Character{

  private String message1;
  private String message2;
  private String message3;

  public Crab(int x, int y, BufferedImage char2){
    super(x, y, char2);
    message1 = "In order to know where your father is,";
    message2 = "you must bring me back two items:";
    message3 = "A shell and an apple";

  }

  public void changeMessage(){
    message1 = "Thank you very much Nemo!";
    message2 = "Your father is on the bottom left corner of this map";
    message3 = "Don't forget, you MUST collect the remaining 2 items!";
  }

  public void conversation(Graphics g){
    if(this.getActive()){
      g.setColor(Color.white);
      g.drawString(message1, getX() + 150, getY());
      g.drawString(message2, getX()+150, getY()+30);
      g.drawString(message3, getX()+150, getY()+60);
    }
  }

}
