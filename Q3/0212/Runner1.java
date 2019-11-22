public class Runner1{
  public static void main(String[] args){
    Practice pt = new Practice();
    pt.getDomain("jen@mvla.net");

    Card deck[] = new Card[10];
    for(int i = 0; i<10; i++){
      deck[i] = new Card((int)(Math.random() * 5 + 1));
    }

    pt.print(deck);
    System.out.println(pt.getLargest(deck));
    pt.scramble(deck);
    pt.print(deck);
    pt.sort(deck);
    pt.print(deck);
    pt.searchReplace(2,deck);
    pt.print(deck);
    System.out.println();
  }
}
