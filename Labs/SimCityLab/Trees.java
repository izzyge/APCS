import java.awt.Color;
import java.awt.Graphics;

public class Trees{
	int x;
	int y;
	int row;
	int col;
	Color brown = new Color(160,82,45);
	Color green = new Color(0,128,0);

	public Trees(int x, int y, int row, int col){
		this.x = x;
		this.y = y;
		this.row = row;
		this.col = col;
	}

	public void drawMe(Graphics g){
		for(int r=0; r<row; r++){
			for(int c=0; c<col; c++){
				//trunk
				g.setColor(brown);
				g.fillRect(x+c*35,y+r*40,10,25);

				//tree
				g.setColor(green);
				g.fillOval(x-10+c*35,y-15+r*40,30,30);
			}
		}
	}

	public void drawMe2(Graphics g){
		for(int r=0; r<row; r++){
			for(int c=0; c<col; c++){
				//trunk
				g.setColor(brown);
				g.fillRect(x+c*38,y+r*45,10,25);
				//tree
				g.setColor(green);
				g.fillOval(x-10+c*38,y-30+r*45,30,40);
			}
		}
	}

	public void drawMe3(Graphics g){
		for(int r=0; r<row; r++){
			for(int c=0; c<col; c++){
				//trunk
				g.setColor(brown);
				g.fillRect(x+c*40,y+r*48,10,25);
				//tree
				g.setColor(green);
				g.fillOval(x-10+c*40,y-30+r*48,30,40);
			}
		}
	}
}


