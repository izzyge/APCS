import java.util.ArrayList;

public class Runner{
  public static void main(String[] args){
    ArrayList<Card>deck = new ArrayList<>();
    deck.add(new Card(4, "Hearts"));
    deck.add(new Card(7, "Spades"));
    deck.add(new Card(10, "Diamonds"));

    for(int i = 0; i<deck.size(); i++){
      System.out.println(deck.get(i));
    }
  }
}
