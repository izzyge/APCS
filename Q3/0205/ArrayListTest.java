import java.util.ArrayList;

public class ArrayListTest{

  public void scramble(ArrayList<Integer> al){

    for(int i = 0; i< al.size(); i++){
      int j = (int)(Math.random() * al.size());

      int temp = al.get(i);
      al.set(i, al.get(j));
      al.set(j, temp);

    }
  }

  public void sort(ArrayList<Integer> al){
    for(int i = 0; i<al.size()-1; i++){
      int current = i;
      int min = i;
      for(int j = i+1; j<al.size(); j++){
        if(al.get(j) < al.get(min))
        min = j;
      }

      if(current != min){
        int temp = al.get(current);
        al.set(current, al.get(min));
        al.set(min, temp);
      }
    }


  }

  public void print(ArrayList<Integer> al){
    for(int each: al){
      System.out.println(each);
    }
    System.out.println();
  }
}
