import java.util.ArrayList;

public class ArrayListTest{
  public void printList(ArrayList<Item>list){
    for(Item each: list){
      System.out.println(each);
    }
    System.out.println();
  }

  public void scramble(ArrayList<Item>list){
    for(int i = 0; i< list.size(); i++){
      int j = (int)(Math.random() * list.size());

      Item temp = list.get(i);
      list.set(i, list.get(j));
      list.set(j, temp);
    }
  }

  public void sort(ArrayList<Item>list){
    for(int i = 0; i< list.size() -1; i++){
      for(int j = i+1; j< list.size(); j++){
        if(list.get(j).getPrice() < list.get(i).getPrice()){
          Item temp = list.get(i);
          list.set(i, list.get(j));
          list.set(j, temp);
        }
      }
    }
  }


}
