public class Count{
  public int getFactorial(int n){
    int count = 1;
    int total = 1;
    while(count <= n){
      total = total * count;
      count++;
    }
    return total;
  }
}
