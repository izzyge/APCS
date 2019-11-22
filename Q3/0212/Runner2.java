import java.util.ArrayList;
public class Runner2{
  public static void main(String[] args){
    Practice pt = new Practice();
    ArrayList<Card> deck = new ArrayList<Card>();

    for(int i = 0; i<10; i++){
      deck.add(new Card((int)(Math.random() * 5 + 1)));
    }

    pt.print(deck);
    System.out.println(pt.getSmallest(deck));
    pt.scramble(deck);
    pt.print(deck);
    pt.sort(deck);
    pt.print(deck);
    pt.searchReplace(1,deck);
    pt.print(deck);
    pt.searchDelete(5,deck);
    pt.print(deck);
  }
}
