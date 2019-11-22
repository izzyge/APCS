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

	private Projectile p1;
	private Player player;
	private Target[] targets;
	private int score;
	BufferedImage background;


	public Screen(){

		player = new Player(40,300);
		p1 = new Projectile(40,300);
		score = 0;

		targets = new Target[8];
		for(int i = 0; i<targets.length;i++){
			targets[i] = new Target((int)(Math.random() *600 + 100),(int)(Math.random() *520 + 30));
		}


		try {
      background= ImageIO.read(new File("background.jpg"));
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

		g.drawImage(background,0,0,800,600,null);


		g.setColor(Color.white);
		// g.fillRect(0, 0, 800, 600);

		g.drawString("Score: " + score, 10,100);


		//Draw Player
		player.drawMe(g);

		//Draw Projectile
		p1.drawMe(g);

		for(int i = 0; i< targets.length; i++){
			targets[i].drawMe(g);
		}

		if(score==8){
			g.setColor(Color.black);
			g.fillRect(0,0,800,600);
			g.setColor(Color.white);
			g.drawString("YOU WON!!!", 360,200);
		}

	}


	public void animate(){

		while(true){
			//wait for .01 second
			try {
			    Thread.sleep(10);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}

			p1.moveRight();

			for(int i = 0; i < targets.length; i++){
				targets[i].checkCollision(p1);
			}

			for(int i = 0; i < targets.length; i+=2){
				targets[i].animate();

			}

			for(int i = 1; i < targets.length; i+=2){
				targets[i].animate2();

			}

			score = 0;
			for(int i = 0; i<targets.length; i++){
				if(targets[i].getVisible()==false){
					score++;
				}
			}

			//repaint the graphics drawn
			repaint();
		}

	}


	public void playSound() {

        Sound.playSound("Shoot.wav");
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
			this.playSound();

			//shoot the projectile
			p1.setVisible(true);

		}

		repaint();

	}

	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
