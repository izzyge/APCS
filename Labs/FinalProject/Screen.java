import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


public class Screen extends JPanel implements KeyListener{

	int level;
	private Projectile p1, p2;
	private Player player;
	private Target[] targets;
	private int score;
	private Star[] stars;
	BufferedImage background;
	BufferedImage background2;
	BufferedImage win;
	int textX = 850;

	public Screen(){

		player = new Player(40,300);
		p1 = new Projectile(40,300);
		p2 = new Projectile(40,300);
		score = 0;
		level = 1;


		targets = new Target[8];
		for(int i = 0; i<targets.length;i++){
			targets[i] = new Target((int)(Math.random() *550 + 200),(int)(Math.random() *520 + 30));
		}

		stars = new Star[100];
		for(int i = 0; i<stars.length;i++){
			stars[i] = new Star();
		}


		try {
      background= ImageIO.read(new File("img/background.jpg"));
			background2 = ImageIO.read(new File("img/background2.png"));
			win = ImageIO.read(new File("img/win.jpg"));
    } catch (IOException ex){

    }


		//sets keylistener
		setFocusable(true);
        addKeyListener(this);
	}







	public Dimension getPreferredSize() {
		//Sets the size of the panel
        return new Dimension(800,600);
	}

	public void paintComponent(Graphics g) {
    super.paintComponent(g);
		if(level == 1){
			g.setColor(Color.black);
			g.drawImage(background,0,0,800,600,null);
		} else if(level == 2){
			Color space = new Color(10, 2, 48);
			g.setColor(space);
			g.drawImage(background2,0,0,800,600,null);
		}

		// g.drawImage(background,0,0,800,600,null);


		g.setColor(Color.white);
		// g.fillRect(0, 0, 800, 600);

		if(level == 1){
			score -= 5;
		}
		g.drawString("Score: " + score, 10,100);
		g.drawString("Lives: " + player.lives, 10,130);
		g.drawString("Level " + level, 700,100);

		for(int i = 0; i<stars.length;i++){
			stars[i].drawMe(g);
		}

		for(int i = 0; i < targets.length; i++){
			player.checkCollision(targets[i]);

		}

		//Draw Player
		player.drawMe(g);

		//Draw Projectile
		p1.drawMe(g);
		p2.drawMe(g);

		for(int i = 0; i< targets.length; i++){
			targets[i].drawMe(g);
		}

		if(level == 1){
			for(int i = 0; i<5; i++){
				targets[i].setNotVisible();
			}
		}
		//score =0;
		if(level == 2){

			for(int i = 0; i< targets.length; i++){
				targets[i].move();
			}

		}




		if(score==3 && level == 1){
			level = 2;
			score = 0;
			for(int i = 0; i< targets.length; i++){
				targets[i].setVisible();
				targets[i]. setX((int)(Math.random()*200+600));
			}
		}




		if(level==2){
			for(int i = 0; i<targets.length;i++){
				if(targets[i].getX() <= 0 && targets[i].visible == true ){
					player.lives --;
					targets[i].setX(0);

				}
			}
		}

		if(score > 7){
			g.drawImage(win,0,0,800,600,null);
			g.drawString("Press r to restart", 300,580);
		}

		// int targetsHit = 8;
		// for(int i = 0; i < targets.length; i++){
		//
		// 	if(targets[i].getVisible() == false){
		// 		targetsHit++;
		// 	}
		// }
		//
		// if(targetsHit == 8 && score>3){
		// 	g.setColor(Color.yellow);
		// 	g.drawString("YOU WON!!!!!",textX,250);
		// }




		if(player.lives <= 0){
			g.setColor(Color.black);
			g.fillRect(0,0,800,600);
			g.setColor(Color.white);
			g.drawString("GAME OVER :(",300,250);
			g.drawString("Press r to restart", 290,350);

		}

	}


	public void animate(){

		while(true){
			//wait for .01 second
			try {
			    Thread.sleep(30);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}

			p1.moveRight();
			p2.moveRight();

			for(int i = 0; i < targets.length; i++){
				targets[i].checkCollision(p1);
				targets[i].checkCollision(p2);
				player.checkCollision(targets[i]);
			}

			for(int i = 0; i < targets.length; i+=2){
				targets[i].animate();

			}

			for(int i = 1; i < targets.length; i+=2){
				targets[i].animate2();

			}

			for(int i = 0; i<stars.length; i++){
				stars[i].move();
			}

			score = 0;
			for(int i = 0; i<targets.length; i++){
				if(targets[i].getVisible()==false){
					score++;
				}
			}

			textX-=2;



			//repaint the graphics drawn
			repaint();
		}

	}

	public void restart(){
		player.lives = 3;
		score = 0;
		level = 1;
		for(int i = 0; i< targets.length; i++){
			if(targets[i].getX()>200){
				targets[i].setVisible();
			} else{
				targets[i].setX((int)(Math.random() *500 + 300));
				targets[i].setVisible();
			}
		}
	}


		public void playSound() {
      Sound.playSound("sound/Shoot.wav");
    }



	//implement methods of the KeyListener
	public void keyPressed(KeyEvent e) {


		//key code
		//http://www.cambiaresearch.com/articles/15/javascript-char-codes-key-codes

		if (e.getKeyCode()==38){//Up Arrow
		    player.moveUp();
		}
		else if (e.getKeyCode()==40){//Down Arrow
		    player.moveDown();
		} else if ( e.getKeyCode() == 32 ) { //Spacebar
			//update the position of the projectile to the position of the Player
			p1.setPosition( player.getX(),  player.getY() + 50);
			p2.setPosition( player.getX(),  player.getY() + 50);

			if(p1.getX() == 40){
				p1.setVisible(true);
			} else {
				p2.setVisible(true);
			}
			this.playSound();

			//shoot the projectile


		} else if (e.getKeyCode() == 80){
			score = 8;
		} else if (e.getKeyCode() == 82){
			restart();
		}

		repaint();

	}

	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
