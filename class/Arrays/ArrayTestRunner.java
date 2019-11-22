public class ArrayTestRunner{
  public static void main(String[] args){
    ArrayTest at = new ArrayTest(5);
    at.print();
    
    int sum = at.getSum();
    System.out.println(sum);
  }

}
