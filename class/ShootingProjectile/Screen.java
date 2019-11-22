import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class Screen extends JPanel implements KeyListener{

    private Projectile p1;
    private Ship s1;
    private Enemy[] enemies;


    public Screen(){

        s1 = new Ship(50,300);
        p1 = new Projectile(50,300);
        enemies = new Enemy[3];

        enemies[0] = new Enemy(700,30);
        enemies[1] = new Enemy(700,100);
        enemies[2] = new Enemy(700,300);


        //sets keylistener
        setFocusable(true);
        addKeyListener(this);
    }

    public Dimension getPreferredSize(){
        //Sets the size of the panel
            return new Dimension(800,600);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);



        g.setColor(Color.white);
        g.fillRect(0, 0, 800, 600);


        //Draw ship
        s1.drawMe(g);

        //Draw Projectile
        p1.drawMe(g);

        for(int i=0; i<enemies.length; i++){
          enemies[i].drawMe(g);
        }

    }


    public void animate(){

        while(true)
        {
            //wait for .01 second
            try {
                Thread.sleep(10);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            p1.moveRight();

            //repaint the graphics drawn
            repaint();
        }

    }

    //implement methods of the KeyListener
    public void keyPressed(KeyEvent e) {


        //key code
        //http://www.cambiaresearch.com/articles/15/javascript-char-codes-key-codes

        if (e.getKeyCode()==38){//Up Arrow
            s1.moveUp();
        }
        else if (e.getKeyCode()==40){//Down Arrow
            s1.moveDown();
        } else if (e.getKeyCode() == 32){ //spacebar
          //shoot the projectile
          p1.setVisible(true);
          p1.setPosition(s1.getX(), s1.getY());
        }

        repaint();

    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
