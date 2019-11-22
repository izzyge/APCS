public class MyMath{
  public void countDown(int x){
    if(x>=0){
      System.out.println(x);
      countDown(x-1);
    }
  }

  public void countUp(int x){
    if(x>0){
      countUp(x-1);
      System.out.println(x);
    }
  }

  public int factorial(int x){
    int r = 0;
    if(x>1){
      x = x * factorial(x-1);
      r = x;
    } else if(x==1){
      r = 1;
    }
    return r;
  }
}
