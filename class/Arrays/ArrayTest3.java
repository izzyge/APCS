public class ArrayTest3{
  int[] numbers;

  public ArrayTest3(int n){
    numbers = new int[n];
    for(int i=0;i<n;i++){
      numbers[i] = (int)(Math.random()*4 + 1);
    }

  }

  public void print(){
    for(int each: numbers){
      System.out.println(each);
    }
  }

  public int getProduct(){
      int product = 1;
      for(int i=0;i<numbers.length;i++){
        product *= numbers[i];
      }

      return product;
  }
}
