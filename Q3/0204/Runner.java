import java.util.ArrayList;
public class Runner{
  public static void main(String[] args){
    ArrayList<Card> cardList = new ArrayList<>();
    cardList.add(new Card(1));
    cardList.add(new Card(2));
    cardList.add(new Card(3));
    cardList.add(new Card(4));

    for( int i = 0; i<cardList.size(); i++){
      int i1 = (int)(Math.random() * 4);
      Card temp = cardList.get(i);
      cardList.set(i, cardList.get(i1));
      cardList.set(i1, temp);
    }

    for(Card each: cardList){
      System.out.println(each);
    }

  }
}
