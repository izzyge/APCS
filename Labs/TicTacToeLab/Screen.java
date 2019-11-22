import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;


import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

  public class Screen extends JPanel implements MouseListener, ActionListener{
    Game game;
    private JButton newgame;

    public Screen(){
      this.setLayout(null);

      game = new Game();

      this.setFocusable(true);
      addMouseListener(this);

      newgame = new JButton("New Game");
  		newgame.setBounds(650,150,100,40);
  		newgame.addActionListener(this);
  	  add(newgame);
      newgame.setVisible(false);
    }

    public Dimension getPreferredSize(){
      return new Dimension(800,600);
    }

    public void paintComponent(Graphics g){
      super.paintComponent(g);
      if(game.checkFull() == true || game.checkWin() == true)
        newgame.setVisible(true);

      game.drawMe(g);
    }

    public void actionPerformed(ActionEvent e){
      if(e.getSource() == newgame){
        game.clear();
        newgame.setVisible(false);
      }
      repaint();
    }

    public void mousePressed(MouseEvent e) {

        //Print location of x and y
        System.out.println("X: " + e.getX() + ", Y: " + e.getY());

        //Check if mouse pressed position is in the brown box
        if (e.getX() >= 50 && e.getX() <= 200 && e.getY() >= 50 && e.getY() <= 200) {
          game.insertXO(0,0);
        } else if (e.getX() >= 210 && e.getX() <= 360 && e.getY() >= 50 && e.getY() <= 200){
          game.insertXO(0,1);
        } else if (e.getX() >= 370 && e.getX() <= 520 && e.getY() >= 50 && e.getY() <= 200){
          game.insertXO(0,2);
        } else if (e.getX() >= 50 && e.getX() <= 200 && e.getY() >= 210 && e.getY() <= 360) {
          game.insertXO(1,0);
        } else if (e.getX() >= 210 && e.getX() <= 360 && e.getY() >= 210 && e.getY() <= 360){
          game.insertXO(1,1);
        } else if (e.getX() >= 370 && e.getX() <= 520 && e.getY() >= 210 && e.getY() <= 360){
          game.insertXO(1,2);
        } else if (e.getX() >= 50 && e.getX() <= 200 && e.getY() >= 370 && e.getY() <= 520) {
          game.insertXO(2,0);
        } else if (e.getX() >= 210 && e.getX() <= 360 && e.getY() >= 370 && e.getY() <= 520){
          game.insertXO(2,1);
        } else if (e.getX() >= 370 && e.getX() <= 520 && e.getY() >= 370 && e.getY() <= 520){
          game.insertXO(2,2);
        }

        if(game.checkTicTacToe() == 1){
          game.win(1);
        } else if(game.checkTicTacToe() == 2)
          game.win(2);

        repaint();
    }

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {}

  }
