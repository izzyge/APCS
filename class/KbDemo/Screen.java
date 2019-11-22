import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Screen extends JPanel implements KeyListener{


    private Player p1;
    private Enemy[] enemies;

    public Screen(){
      addKeyListener(this);
      setFocusable(true);
      p1 = new Player(50,300);
      enemies = new Enemy[3];

      for(int i=0; i<enemies.length; i++){
        enemies[i] = new Enemy(730, (i+1)*160);
      }
    }

    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(800,600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        p1.drawMe(g);

        for(int i=0; i<enemies.length; i++){
          enemies[i].drawMe(g);
        }


    }

    public void keyPressed(KeyEvent e){
      System.out.println("key: " + e.getKeyCode());
      if(e.getKeyCode() == 38){
        p1.moveUp();
      }

      if(e.getKeyCode() == 40){
        p1.moveDown();
      }


      repaint();
    }

    public void keyReleased(KeyEvent e){}

    public void keyTyped(KeyEvent e){}
}
