import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


public class Game {
 private int[][] table;
 private int turn;
 private boolean win1;
 private boolean win2;
 private int wins1, wins2;

 public Game() {
   table = new int[3][3];
   for(int r = 0; r < table.length; r++) {
     for(int c = 0; c < table[r].length; c++) {
       table[r][c] = 0;
     }
   }

   turn = 1;
   win1 = false;
   win2 = false;
 }

 public void printTable() {
   for(int[] row : table) {
     for(int item : row) {
       String toPrint = "";
       if(item == 0) toPrint += "-";
       else if(item == 1) toPrint += "X";
       else if(item == 2) toPrint += "O";
       System.out.print(toPrint + "\t");
     }
     System.out.println();
   }

   System.out.println();
 }

 public void insertXO(int x, int y) {
  if(table[x][y] == 0){
    if(turn == 1){
        table[x][y] = 1;

      		Sound.playSound("sound/x.wav");

    }
    else if(turn == 2){
        table[x][y] = 2;
      		Sound.playSound("sound/y.wav");

    }
  }
  if(turn == 1)
    turn = 2;
  else if(turn == 2)
    turn = 1;
 }

 public boolean checkFull() {
   boolean full = true;
   for(int[] row : table) {
     for(int item : row) {
       if(item == 0) full = false;
     }
   }

   return full;
 }

 public boolean checkWin(){
   if( win1 == true || win2 == true)
    return true;
   else
    return false;
 }

 public void win(int player){
   Sound.playSound("sound/win.wav");
   if(player == 1){
     win1 = true;
     wins1++;
   }
   else if (player == 2){
     win2 = true;
     wins2++;
   }

 }

 public void clear(){
   for(int r = 0; r<3; r++){
     for(int c = 0; c<3; c++){
        table[r][c] = 0;
     }
   }
   win1 = false;
   win2 = false;
 }

 public void drawMe(Graphics g){
   Font font = new Font("Arial", Font.PLAIN, 100);
   g.setFont(font);
   g.setColor(Color.blue);
   g.fillRect(0,0,800,600);
   g.setColor(Color.white);
   g.fillRect(200, 50, 10, 450);
   g.fillRect(350, 50, 10, 450);
   g.fillRect(50, 200, 450, 10);
   g.fillRect(50, 350, 450, 10);
   g.setFont(new Font("Arial", Font.PLAIN, 50));
   g.drawString("P1: " + wins1, 20,550);
   g.drawString("P2: " + wins2, 220,550);
   g.setFont(font);
   for(int r = 0; r<3; r++){
     for(int c = 0; c<3; c++){
       if(table[r][c] == 1){
        g.setColor(Color.white);
        g.drawString("X", 160 * c + 80, 160 * r + 140 );
      } else if(table[r][c] == 2){
       g.setColor(Color.white);
       g.drawString("O", 160 * c + 80, 160 * r + 140 );
     }
     }
   }

   g.setColor(Color.white);
   g.setFont(new Font("Arial", Font.PLAIN, 30));
   if(win1 == true)
    g.drawString("Player 1 Wins", 600,500);
   if(win2 == true)
    g.drawString("Player 2 Wins", 600,500);
   if(checkFull() == true && win1 == false && win2 == false){
    g.drawString("Tie", 600,500);
    Sound.playSound("sound/tie.wav");
   }
 }

 public int checkTicTacToe(){
      if(table[0][0] == 1 && table[0][1] == 1 && table[0][2] == 1)
        return 1;
      if(table[1][0] == 1 && table[1][1] == 1 && table[1][2] == 1)
        return 1;
      if(table[2][0] == 1 && table[2][1] == 1 && table[2][2] == 1)
        return 1;
      if(table[0][0] == 1 && table[1][0] == 1 && table[2][0] == 1)
        return 1;
      if(table[0][1] == 1 && table[1][1] == 1 && table[2][1] == 1)
        return 1;
      if(table[0][2] == 1 && table[1][2] == 1 && table[2][2] == 1)
        return 1;
      if(table[0][0] == 1 && table[1][1] == 1 && table[2][2] == 1)
        return 1;
      if(table[0][2] == 1 && table[1][1] == 1 && table[2][0] == 1)
        return 1;

      if(table[0][0] == 2 && table[0][1] == 2 && table[0][2] == 2)
        return 2;
      if(table[1][0] == 2 && table[1][1] == 2 && table[1][2] == 2)
        return 2;
      if(table[2][0] == 2 && table[2][1] == 2 && table[2][2] == 2)
        return 2;
      if(table[0][0] == 2 && table[1][0] == 2 && table[2][0] == 2)
        return 2;
      if(table[0][1] == 2 && table[1][1] == 2 && table[2][1] == 2)
        return 2;
      if(table[0][2] == 2 && table[1][2] == 2 && table[2][2] == 2)
        return 2;
      if(table[0][0] == 2 && table[1][1] == 2 && table[2][2] == 2)
        return 2;
      if(table[0][2] == 2 && table[1][1] == 2 && table[2][0] == 2)
        return 2;


    return 0;
 }
}
