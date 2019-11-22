import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.util.ArrayList;

public class Table extends JPanel implements ActionListener{
    private ArrayList<Card>deck;
    private ArrayList<Card>playerHand;
    private ArrayList<Card>dealerHand;
    private JButton hitButton;
    private JButton newGameButton;
    private JButton standButton;
    private int dealerTotal;
    private int playerTotal;
    private int playerScore;
    private int dealerScore;
    boolean deal, win, lose, tie;

    public Table(){
      deck = new ArrayList<>();
      dealerHand = new ArrayList<>();
      playerHand = new ArrayList<>();
      deck.add(new Card(2,"2", "heart"));
      deck.add(new Card(2, "2", "heart"));
      deck.add(new Card(3, "3", "heart"));
      deck.add(new Card(4, "4", "heart"));
      deck.add(new Card(5, "5", "heart"));
      deck.add(new Card(6, "6", "heart"));
      deck.add(new Card(7, "7", "heart"));
      deck.add(new Card(8, "8", "heart"));
      deck.add(new Card(9, "9", "heart"));
      deck.add(new Card(10, "10", "heart"));
      deck.add(new Card(10, "J", "heart"));
      deck.add(new Card(10, "Q", "heart"));
      deck.add(new Card(10, "K", "heart"));
      deck.add(new Card(11, "A", "heart"));
      deck.add(new Card(2, "2", "diamond"));
      deck.add(new Card(3, "3", "diamond"));
      deck.add(new Card(4, "4", "diamond"));
      deck.add(new Card(5, "5", "diamond"));
      deck.add(new Card(6, "6", "diamond"));
      deck.add(new Card(7, "7", "diamond"));
      deck.add(new Card(8, "8", "diamond"));
      deck.add(new Card(9, "9", "diamond"));
      deck.add(new Card(10, "10", "diamond"));
      deck.add(new Card(10, "J", "diamond"));
      deck.add(new Card(10, "Q", "diamond"));
      deck.add(new Card(10, "K", "diamond"));
      deck.add(new Card(11, "A", "diamond"));
      deck.add(new Card(2, "2", "spade"));
      deck.add(new Card(3, "3", "spade"));
      deck.add(new Card(4, "4", "spade"));
      deck.add(new Card(5, "5", "spade"));
      deck.add(new Card(6, "6", "spade"));
      deck.add(new Card(7, "7", "spade"));
      deck.add(new Card(8, "8", "spade"));
      deck.add(new Card(9, "9", "spade"));
      deck.add(new Card(10, "10", "spade"));
      deck.add(new Card(10, "J", "spade"));
      deck.add(new Card(10, "Q", "spade"));
      deck.add(new Card(10, "K", "spade"));
      deck.add(new Card(11, "A", "spade"));
      deck.add(new Card(2, "2", "club"));
      deck.add(new Card(3, "3", "club"));
      deck.add(new Card(4, "4", "club"));
      deck.add(new Card(5, "5", "club"));
      deck.add(new Card(6, "6", "club"));
      deck.add(new Card(7, "7", "club"));
      deck.add(new Card(8, "8", "club"));
      deck.add(new Card(9, "9", "club"));
      deck.add(new Card(10, "10", "club"));
      deck.add(new Card(10, "J", "club"));
      deck.add(new Card(10, "Q", "club"));
      deck.add(new Card(10, "K", "club"));
      deck.add(new Card(11, "A", "club"));
      // String suit = "";
      //   for(int i = 0; i<4; i++){
      //     for(int j = 0; j < 13; j++){
      //       if(i == 0)
      //         suit = "hearts";
      //       else if(i == 1)
      //         suit = "diamonds";
      //       else if(i == 2)
      //         suit = "spades";
      //       else if(i == 3)
      //         suit = "clubs";
      //       else
      //         System.out.println("****************************");
      //       deck.add(new Card(j+1,suit));
      //     }
      //   }

        shuffle();

        hitButton = new JButton("Hit");
        hitButton.setBounds(670,50,100,40);
        hitButton.addActionListener(this);
        this.add(hitButton);

        standButton = new JButton("Stand");
        standButton.setBounds(780,50,100,40);
        standButton.addActionListener(this);
        this.add(standButton);

        newGameButton = new JButton("New Game");
        newGameButton.setBounds(890,50,100,40);
        newGameButton.addActionListener(this);
        this.add(newGameButton);
        newGameButton.setVisible(false);


        // total = deck[0].getValue() + deck[1].getValue();
	      playerHand.add( deck.get(0) );
	      playerHand.add( deck.get(1) );
        dealerHand.add( deck.get(2) );
        dealerHand.add( deck.get(3) );
	      deck.remove(0);
        deck.remove(0);
        deck.remove(0);
	      deck.remove(0);
        setLayout(null);

        if(playerHand.size() > 0)
          playerTotal = playerHand.get(0).getValue() + playerHand.get(1).getValue();
        else
          playerTotal = 0;


    }

    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(1000,600);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Color background = new Color(12, 66, 24);
        g.setColor(background);
        g.fillRect(0,0,1000,600);
        g.setColor(Color.BLACK);


        int x = 100;
        int y = 140;
        for(int i = 0; i<dealerHand.size(); i++){
          dealerHand.get(i).drawMe(g,x,y);
          x+=80;
        }

        x = 100;
        y = 350;
        for(int i = 0; i<playerHand.size(); i++){
          playerHand.get(i).drawMe(g,x,y);
          x+=80;
        }

        if(!deal){
          g.setColor(Color.BLACK);
          g.fillRect(100,140, 80,150);
          g.drawString("Dealer Total: " + dealerHand.get(1).getValue(), 600,250);

        }

        g.setColor(Color.BLACK);
        g.drawString("Your Total: " + getTotalPlayer(), 600,450);
        if(deal)
          g.drawString("Dealer Total: " + getTotalDealer(), 600,250);
        g.drawString("Dealer: " + dealerScore, 230,50);
        g.drawString("You: " + playerScore, 50,50);

        g.setColor(Color.WHITE);
        if(win)
          g.drawString("WIN", 100,560);
        else if(lose)
          g.drawString("LOSE", 100,560);
        else if(tie)
          g.drawString("TIE", 100,560);

        if(deck.size() <4){
          g.drawString("DECK IS EMPTY", 100,560);
          hitButton.setVisible(false);
          standButton.setVisible(false);

        }



    }

    public void shuffle(){
      for(int i = 0; i < deck.size(); i++) {
        int i1 = (int)(deck.size() * Math.random());

        Card temp = deck.get(i);
        deck.set(i, deck.get(i1));
        deck.set(i1, temp);
      }
    }

    private int getTotalPlayer(){
		int playerTotal = 0;
  		for(int i=0; i<playerHand.size(); i++){
        if(playerHand.get(i).getValue() == 11){
          if(playerTotal > 21){
            playerHand.get(i).setValue(1);
          }
        }
        playerTotal = playerTotal + playerHand.get(i).getValue();
  		}
  		return playerTotal;
  	}

  	private int getTotalDealer(){
  		int dealerTotal = 0;
  		for(int i=0; i<dealerHand.size(); i++){
        if(dealerHand.get(i).getValue() == 11){
          if(dealerTotal > 21){
            dealerHand.get(i ).setValue(1);
          }
  			dealerTotal = dealerTotal + dealerHand.get(i).getValue();
        }

  		}
  		return dealerTotal;
  	}

    private void dealerPlays(){
  		while(getTotalDealer()<17){
  			dealerHand.add(deck.get(0));
  			deck.remove(0);
  		}
  	}


    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == hitButton){
        playerHand.add( deck.get(0) );
	      deck.remove(0);


        //ace 1 or 11
        if(playerHand.get(playerHand.size()-1).getValue() == 11){
          if(getTotalPlayer() > 21){
            playerHand.get(playerHand.size()-1 ).setValue(1);
          }
        }

        if(getTotalPlayer() >21){
           standButton.setVisible(false);
           hitButton.setVisible(false);
           newGameButton.setVisible(true);
           dealerScore++;
           lose = true;
        } else if(getTotalPlayer() == 21){
          deal = true;
          hitButton.setVisible(false);
          standButton.setVisible(false);
          newGameButton.setVisible(true);
          if(getTotalDealer() == 21){
            tie = true;
          } else {
            win = true;
            playerScore++;
          }
        }


    } else if(e.getSource() == standButton){
      //ace 1 or 11
        deal = true;
        dealerTotal = dealerHand.get(0).getValue();

        dealerPlays();

        hitButton.setVisible(false);
        standButton.setVisible(false);
        newGameButton.setVisible(true);

        if(getTotalDealer() > 21){
          playerScore++;
          win = true;
        }


        if(getTotalDealer() < 21 && getTotalPlayer() < 21){
          if(getTotalDealer() < getTotalPlayer()){
            playerScore++;
            win = true;
          } else if(getTotalDealer() > getTotalPlayer()){
            dealerScore++;
            lose = true;
          } else{
            tie = true;
          }
        }



    } else if(e.getSource() == newGameButton){
      deal = false;
      playerHand.clear();
			dealerHand.clear();
			shuffle();
			playerHand.add(deck.get(0));
			playerHand.add(deck.get(1));
			deck.remove(0);
			deck.remove(0);
			dealerHand.add(deck.get(0));
			dealerHand.add(deck.get(1));
			deck.remove(0);
			deck.remove(0);
      hitButton.setVisible(true);
			standButton.setVisible(true);
			newGameButton.setVisible(false);
      win = false;
      lose = false;
      tie = false;


    }

    repaint();
  }

}
