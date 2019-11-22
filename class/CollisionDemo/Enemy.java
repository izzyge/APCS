import java.awt.Color;
import java.awt.Graphics;

public class Enemy{
	private int x;
	private int y;

	private int width;
	private int height;

	private Color green;
	private boolean visible;


	public Enemy(int x, int y){

		this.x = x;
		this.y = y;

		this.width = 50;
		this.height = 50;

		this.green = new Color(0,255,00);
		this.visible = true;
	}


	public void drawMe(Graphics g){
		if(visible){
			g.setColor(green);
			g.fillRect(x,y,width,height);
		}
	}

	public void checkCollision(Projectile p){
		if(visible){
			int pX = p.getX();
			int pY = p.getY();
			int pWidth = p.getWidth();
			int pHeight = p.getHeight();

			if(pX+pWidth >= x && pX <= x + width
				&&  pY+pHeight >= y && pY <= y + height){
				// System.out.println("Collision");
				visible = false;
		}
	}

	}




}
