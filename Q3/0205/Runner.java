import java.util.ArrayList;

public class Runner{
  public static void main(String[] args){
    ArrayListTest alt = new ArrayListTest();
    ArrayList<Integer> al = new ArrayList<>();
    for( int i = 0; i< 10; i++){
      al.add((int)(Math.random() * 10 +1));
    }
    alt.print(al);
    alt.scramble(al);
    alt.print(al);
    alt.sort(al);
    alt.print(al);
  }
}
