public class ArrayTest4{
  int[] numbers;

  public ArrayTest4(int n){
    numbers = new int[n];

    for(int i = 0; i<numbers.length; i++){
      numbers[i] = (int)(Math.random() * 5 + 1);
    }

  }

  public void print(){
    for(int each: numbers){
      System.out.println(each);
    }
  }

  public boolean search(int n){
    for(int each: numbers){
      if(n == each){
        return true;
      }
    }
    return false;
  }
}
