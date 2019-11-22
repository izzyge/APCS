public class ArrayTest4Runner{
  public static void main(String[] args){
    ArrayTest4 at = new ArrayTest4(10);

    at.print();
    
    boolean search = at.search(5);
    System.out.println(search);
  }
}
