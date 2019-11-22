import java.awt.Color;
import java.awt.Graphics;

public class Houses {

  int x;
  int y;
  int row;
  int col;
  Color brown;
  Color white;
  Color darkBrown;

  public Houses(int x, int y, int row, int col){
    this.x = x;
    this.y = y;
    this.row = row;
    this.col = col;


    brown = new Color(222,184,135);
    white = new Color(255,255,255);
    darkBrown = new Color(71, 40, 0);
  }

  public void drawMe(Graphics g){
		for(int r=0; r<row; r++){
			for(int c=0; c<col; c++){
				//building
				g.setColor(brown);
				g.fillRect(x + c*45,y + r*40,35,25);
				int[] xArray = new int[3];
				int[] yArray = new int[3];
				xArray[0] = 600+c*45;
				yArray[0] = 400+r*40;
				xArray[1] = 617+c*45;
				yArray[1] = 385+r*40;
				xArray[2] = 635+c*45;
				yArray[2] = 400+r*40;
				g.fillPolygon(xArray, yArray, 3);
				//windows
				g.setColor(white);
				g.fillRect(x+4+c*45,y+4+r*40,10,10);
			}
		}
	}

  public void drawMe2(Graphics g){
		for(int r=0; r<row; r++){
			for(int c=0; c<col; c++){
				//building
				g.setColor(brown);
				g.fillRect(x + c*45,y + r*40,35,25);
				//windows
				g.setColor(white);
				g.fillRect(x+4+c*45,y+4+r*40,10,10);
        //door
        g.setColor(darkBrown);
        g.fillRect(x+20+c*45,y+4+r*40,10,20);

			}
		}
	}



  }
