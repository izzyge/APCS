import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class Table extends JPanel implements ActionListener{
    private Card[] deck;
    private int playerIndex;
    private JButton hitButton;
    private JButton newGameButton;
    private JButton standButton;
    private int total;
    private int score;
    private boolean stand;
    // private int winnings;

    public Table(){
        deck = new Card[52];
        deck[11] = new Card(2, "2", "hearts");
        deck[12] = new Card(3, "3", "hearts");
        deck[2] = new Card(4, "4", "hearts");
        deck[3] = new Card(5, "5", "hearts");
        deck[4] = new Card(6, "6", "hearts");
        deck[5] = new Card(7, "7", "hearts");
        deck[6] = new Card(8, "8", "hearts");
        deck[7] = new Card(9, "9", "hearts");
        deck[8] = new Card(10, "10", "hearts");
        deck[9] = new Card(10, "J", "hearts");
        deck[10] = new Card(10, "Q", "hearts");
        deck[0] = new Card(10, "K", "hearts");
        deck[1] = new Card(11, "A", "hearts");

        deck[13] = new Card(2, "2", "diamonds");
        deck[14] = new Card(3, "3", "diamonds");
        deck[15] = new Card(4, "4", "diamonds");
        deck[16] = new Card(5, "5", "diamonds");
        deck[17] = new Card(6, "6", "diamonds");
        deck[18] = new Card(7, "7", "diamonds");
        deck[19] = new Card(8, "8", "diamonds");
        deck[20] = new Card(9, "9", "diamonds");
        deck[21] = new Card(10, "10","diamonds");
        deck[22] = new Card(10, "J", "diamonds");
        deck[23] = new Card(10, "Q", "diamonds");
        deck[24] = new Card(10, "K", "diamonds");
        deck[25] = new Card(11, "A", "diamonds");

        deck[26] = new Card(2, "2", "spades");
        deck[27] = new Card(3, "3", "spades");
        deck[28] = new Card(4, "4", "spades");
        deck[29] = new Card(5, "5", "spades");
        deck[30] = new Card(6, "6", "spades");
        deck[31] = new Card(7, "7", "spades");
        deck[32] = new Card(8, "8", "spades");
        deck[33] = new Card(9, "9", "spades");
        deck[34] = new Card(10, "10","spades");
        deck[35] = new Card(10, "J", "spades");
        deck[36] = new Card(10, "Q", "spades");
        deck[37] = new Card(10, "K", "spades");
        deck[38] = new Card(11, "A", "spades");

        deck[39] = new Card(2, "2", "clubs");
        deck[40] = new Card(3, "3", "clubs");
        deck[41] = new Card(4, "4", "clubs");
        deck[42] = new Card(5, "5", "clubs");
        deck[43] = new Card(6, "6", "clubs");
        deck[44] = new Card(7, "7", "clubs");
        deck[45] = new Card(8, "8", "clubs");
        deck[46] = new Card(9, "9", "clubs");
        deck[47] = new Card(10, "10","clubs");
        deck[48] = new Card(10, "J", "clubs");
        deck[49] = new Card(10, "Q", "clubs");
        deck[50] = new Card(10, "K", "clubs");
        deck[51] = new Card(11, "A", "clubs");

        hitButton = new JButton("Hit");
        hitButton.setBounds(270,50,100,40);
        hitButton.addActionListener(this);
        this.add(hitButton);

        standButton = new JButton("Stand");
        standButton.setBounds(460,50,100,40);
        standButton.addActionListener(this);
        this.add(standButton);

        newGameButton = new JButton("New Game");
        newGameButton.setBounds(650,50,100,40);
        newGameButton.addActionListener(this);
        this.add(newGameButton);
        newGameButton.setVisible(false);

        shuffle();
        playerIndex = 2;
        total = deck[0].getValue() + deck[1].getValue();
        score = 20;
        setLayout(null);

    }

    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(1000,600);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.green);
        g.fillRect(0,0,1000,600);

        int x = 100;
        int y = 200;
        for(int i = 0; i<playerIndex;i++){
          deck[i].drawMe(g,x,y);
          x+=80;

        }

        Font font = new Font("Arial", Font.PLAIN, 50);
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString("Total: " + total, 50,100);
        g.drawString("Points: " + score, 500 ,500);
        if(stand == true){
          if(total == 21){
            font = new Font("Arial", Font.PLAIN, 25);
            g.setColor(Color.white);
            g.drawString("You Win 5 Points!", 50,500);
            g.setColor(Color.black);
          } else if(total == 20){
            font = new Font("Arial", Font.PLAIN, 25);
            g.setColor(Color.white);
            g.drawString("You Win 3 Points!", 50,500);
            g.setColor(Color.black);
          } else if(total == 19){
            font = new Font("Arial", Font.PLAIN, 25);
            g.setColor(Color.white);
            g.drawString("You Win 2 Points!", 50,500);
            g.setColor(Color.black);
          } else if(total == 18 || total == 17 || total == 16){
            font = new Font("Arial", Font.PLAIN, 25);
            g.setColor(Color.white);
            g.drawString("You Win 1 Point!", 50,500);
            g.setColor(Color.black);
          } else if(total > 21) {
            font = new Font("Arial", Font.PLAIN, 25);
            g.setColor(Color.white);
            g.drawString("You lose :(", 50,500);
            g.setColor(Color.black);
          }
        }



    }



    private void shuffle(){
      for(int i = 0; i < deck.length; i++) {
        int i1 = (int)(deck.length * Math.random());

        Card temp = deck[i];
        deck[i] = deck[i1];
        deck[i1] = temp;
      }
    }


     private void reset(){
       playerIndex = 2;
       shuffle();
       for(int i = 0; i<playerIndex;i++){

         total += deck[i].getValue();
       }
     }


    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == hitButton){
        playerIndex ++;
        total = 0;
        System.out.println(deck[playerIndex -1 ].getValue());
        if(deck[playerIndex -1].getValue() == 11){
          for(int i = 0; i<playerIndex;i++){
            total += deck[i].getValue();
            if(total > 21){
              deck[playerIndex-1].setValue(1);
            }
          }
          total = 0;
          for(int i = 0; i<playerIndex;i++){
            total += deck[i].getValue();
          }
        System.out.println(deck[playerIndex -1 ].getValue());
        } else {
          for(int i = 0; i<playerIndex;i++){

            total += deck[i].getValue();
            // System.out.println(total);
          }

      }

        if(total >21){
           standButton.setVisible(true);
           hitButton.setVisible(false);
           newGameButton.setVisible(false);
         }



      } else if(e.getSource() == newGameButton){
        reset();
        stand = false;
        score --;
        total = 0;
        for(int i = 0; i<playerIndex;i++){

          total += deck[i].getValue();
        }
        newGameButton.setVisible(false);
        hitButton.setVisible(true);
        standButton.setVisible(true);
      } else if(e.getSource() == standButton){
        total = 0;
        stand = true;
        for(int i = 0; i<playerIndex;i++){

          total += deck[i].getValue();
        }
        if(total == 21){
          score += 5;

        } else if(total == 20){
          score += 3;

        } else if(total == 19){
          score +=2;

        } else if(total == 18 || total == 17 || total == 16){
          score ++;

        } else {
          score = 20;
        }

        hitButton.setVisible(false);
        standButton.setVisible(false);
        newGameButton.setVisible(true);



        // reset();

      }

      repaint();
    }


}
