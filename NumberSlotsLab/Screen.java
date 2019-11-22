import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;


import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Screen extends JPanel implements ActionListener{

  SlotMachine sm;
  JButton spinButton;
  JButton betButton1;
  JButton betButton2;
  JButton betButton3;

  public Screen(){
    this.setLayout(null);

    spinButton = new JButton("Spin");
    spinButton.setBounds(150,450,100,50);
    spinButton.addActionListener(this);
    this.add(spinButton);

    betButton1 = new JButton(" 1 ");
    betButton1.setBounds(115,120,50,50);
    betButton1.addActionListener(this);
    this.add(betButton1);

    betButton2 = new JButton(" 5 ");
    betButton2.setBounds(175,120,50,50);
    betButton2.addActionListener(this);
    this.add(betButton2);

    betButton3 = new JButton(" 10 ");
    betButton3.setBounds(235,120,50,50);
    betButton3.addActionListener(this);
    this.add(betButton3);

    sm = new SlotMachine(100);

    this.setFocusable(true);
  }

  public Dimension getPreferredSize(){
    return new Dimension(800,600);
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);

    sm.drawMe(g);
  }

  public void actionPerformed(ActionEvent e){
      if( e.getSource() == spinButton){
        sm.play();
        betButton1.setEnabled(true);
        betButton2.setEnabled(true);
        betButton3.setEnabled(true);
      }
      if( e.getSource() == betButton1){
        sm.bet(1);
        betButton1.setEnabled(false);
        betButton2.setEnabled(false);
        betButton3.setEnabled(false);
      }
      if( e.getSource() == betButton2){
        sm.bet(5);
        betButton1.setEnabled(false);
        betButton2.setEnabled(false);
        betButton3.setEnabled(false);
      }
      if( e.getSource() == betButton3){
        sm.bet(10);
        betButton1.setEnabled(false);
        betButton2.setEnabled(false);
        betButton3.setEnabled(false);

      }
      repaint();
  }
}
