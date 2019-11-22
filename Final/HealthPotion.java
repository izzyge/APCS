import java.awt.Color;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class HealthPotion extends Item{

  public HealthPotion(int x, int y, BufferedImage healthPotion, int scene){
    super(x, y, healthPotion, scene);

  }

}
