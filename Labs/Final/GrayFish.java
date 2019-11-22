import java.awt.Color;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class GrayFish extends Character{

  private String message1;
  private String message2;
  private String message3;

  public GrayFish(int x, int y, BufferedImage char1){
    super(x, y, char1);
    message1 = "It looks like you've collected two potions!";
    message2 = "I will activate these potions so you can move quicker and stay healthy";
    message3 = "Go along and find your father!";

  }

  public void conversation(Graphics g){
    if(this.getActive()){
      g.setColor(Color.black);
      g.drawString(message1, getX() + 100, getY());
      g.drawString(message2, getX()+100, getY()+30);
      g.drawString(message3, getX()+100, getY()+60);
    }
  }

}
