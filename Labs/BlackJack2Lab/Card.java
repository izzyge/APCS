import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Card {
  private int value;
  private String name;
  private String suit;
  private  BufferedImage suitImage;

  public Card(int value, String name, String suit){
    this.value = value;
    this.suit = suit;
    this.name = name;



    if(suit.equals("heart")){
      try{
        suitImage = ImageIO.read(new File("images/heart.png"));
      }catch(IOException e){
        System.out.println(e);
      }
    } else if(suit.equals("diamond")){
      try{
        suitImage = ImageIO.read(new File("images/diamond.jpg"));
      }catch(IOException e){
        System.out.println(e);
      }
    } else if(suit.equals("spade")){
      try{
        suitImage = ImageIO.read(new File("images/spade.jpg"));
      }catch(IOException e){
        System.out.println(e);
      }
    } else if(suit.equals("club")){
      try{
        suitImage = ImageIO.read(new File("images/club.png"));
      }catch(IOException e){
        System.out.println(e);
      }
    }

  }

  public void drawMe(Graphics g, int x, int y){
    //card outline
    g.setColor(Color.WHITE);
    g.fillRect(x,y,120,150);
    g.setColor(Color.BLACK);
    g.drawRect(x,y,120,150);

    //draw name
    Font font = new Font("Arial", Font.PLAIN, 50);
    g.setFont(font);

    if(suit.equals("heart") || suit.equals("diamond"))
      g.setColor(Color.RED);
    else if(suit.equals("spade") || suit.equals("club"))
      g.setColor(Color.BLACK);

    g.drawString(name,x+30,y+100);

    g.drawImage(suitImage, x+2,y,null);
  }

  public int getValue(){
    return value;
  }

  public void setValue(int value){
    this.value = value;
  }


}
