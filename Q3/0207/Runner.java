import java.util.ArrayList;

public class Runner{
  public static void main(String[] args) {
    ArrayListTest at = new ArrayListTest();
    ArrayList<Item> itemList = new ArrayList<Item>();

    itemList.add(new Item("Book", 15.50));
    itemList.add(new Item("Laptop", 999.99));
    itemList.add(new Item("Pencil", .50));

    at.printList(itemList);
    at.scramble(itemList);
    at.printList(itemList);
    at.sort(itemList);
    at.printList(itemList);
  }
}
