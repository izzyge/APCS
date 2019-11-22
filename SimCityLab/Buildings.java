import java.awt.Color;
import java.awt.Graphics;

public class Buildings {

  int x;
  int y;
  int row;
  int col;
  Color white;
  Color darkGray;


  public Buildings(int x, int y, int row, int col){
    this.x = x;
    this.y = y;
    this.row = row;
    this.col = col;

    white = new Color(255,255,255);
    darkGray = new Color(71, 68, 64);

  }

  public void drawMe(Graphics g){

    for(int r=0; r<row; r++){

      for(int c=0; c<col; c++){

        //building
        g.setColor(Color.gray);
        g.fillRect(x + c*35,y + r*100,30,85);

        //window

            g.setColor(white);
            g.fillRect(x + c*35 + 2,y + r*100 + 4,8,8);
            g.fillRect(x + c*35 + 2,y + r*100 + 19,8,8);
            g.fillRect(x + c*35 + 2,y + r*100 + 34,8,8);
            g.fillRect(x + c*35 + 2,y + r*100 + 49,8,8);
            g.fillRect(x + c*35 + 2,y + r*100 + 64,8,8);

            g.fillRect(x + c*35 + 18,y + r*100 + 4,8,8);
            g.fillRect(x + c*35 + 18,y + r*100 + 19,8,8);
            g.fillRect(x + c*35 + 18,y + r*100 + 34,8,8);
            g.fillRect(x + c*35 + 18,y + r*100 + 49,8,8);
            g.fillRect(x + c*35 + 18,y + r*100 + 64,8,8);

      }
    }

  }

  public void drawMe2(Graphics g){

    for(int r=0; r<row; r++){

      for(int c=0; c<col; c++){

        //building
        g.setColor(darkGray);
        g.fillRect(x + c*50,y + r*110,40,80);

        //window

            g.setColor(white);
            g.fillRect(x + c*50 + 5,y + r*100 + 4,8,8);
            g.fillRect(x + c*50 + 5,y + r*100 + 19,8,8);
            g.fillRect(x + c*50 + 5,y + r*100 + 34,8,8);
            g.fillRect(x + c*50 + 5,y + r*100 + 49,8,8);
            g.fillRect(x + c*50 + 5,y + r*100 + 64,8,8);

            g.fillRect(x + c*50 + 25,y + r*100 + 4,8,8);
            g.fillRect(x + c*50 + 25,y + r*100 + 19,8,8);
            g.fillRect(x + c*50 + 25,y + r*100 + 34,8,8);
            g.fillRect(x + c*50 + 25,y + r*100 + 49,8,8);
            g.fillRect(x + c*50 + 25,y + r*100 + 64,8,8);

      }
    }

  }
}
