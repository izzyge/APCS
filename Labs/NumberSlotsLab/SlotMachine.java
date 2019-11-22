import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


public class SlotMachine {

  private int num1;
  private int num2;
  private int num3;
  private int balance;
  private int winnings;
  private int bet;
  BufferedImage balloons;

  public SlotMachine(int balance){
    num1 = 0;
    num2 = 0;
    num3 = 0;
    this.balance = balance;
    winnings = 0;
    bet = 0;


    try {
      balloons= ImageIO.read(new File("Balloons.jpg"));
    } catch (IOException ex){

    }
  }

  public void drawMe(Graphics g){
    //Colors
    Color blue = new Color(0,0,225);
    Color white = new Color(255,255,255);

    //Draw Slot SlotMachine
    g.setColor(blue);
    g.fillRect(100,100,200,400);

    //Draw numbers
    g.setFont(new Font("Helvetica", Font.PLAIN, 20));
    g.setColor(white);
    g.drawString( num1 + " | " + num2 + " | " + num3, 170, 230);

    //Draw balance and winnings
    g.drawString("Balance: " + balance, 150, 300);
    g.drawString("Winnings: " + winnings, 150, 320);

    //if jackpot, balloon images
    if(num1 == 7 && num2 == 7 && num3 == 7){
        g.drawImage(balloons, 165, 210, 20, 20, null);
        g.drawImage(balloons, 192, 210, 20, 20, null);
        g.drawImage(balloons, 221, 210, 20, 20, null);
    }

    if(num1 != num2 && num2 != num3){
      g.setFont(new Font("Helvetica", Font.PLAIN, 10));
      g.drawString("you win nothing", 160, 360);
    }
  }


  public void bet(int betInput){
    if(betInput <= balance){
      bet = betInput;
      balance -= bet;
    }
  }

  public void play(){
    if(bet>0){
      num1 = (int)(Math.random()*9+1);
      num2 = (int)(Math.random()*9+1);
      num3 = (int)(Math.random()*9+1);
      // num1 = 7;
      // num2 = 7;
      // num3 = 7;
    }

    //jackpot
    if(num1 == 7 && num2 == 7 && num3 == 7){
      winnings += bet*100;
      balance += bet*100;
    } else if(num1 == num2 && num2 == num3){
      winnings += bet*5;
      balance += bet*5;
    } else if(num1 == num2 || num2 == num3 || num1 == num3){
      winnings += bet*2;
      balance += bet*2;
    }

    bet = 0;

  }

}
