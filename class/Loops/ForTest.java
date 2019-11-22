public class ForTest{

  public void printCount(){
    for(int x=1; x>=100; x++){
      System.out.println(x);
    }

  public void printCount(int max){
    for(int x=1;x<=max; x++){
      System.out.println(x);
    }
  }

  public void printCount(int min, int max){
    for(int x=min; x<=max; x++){
      System.out.println(x);
    }
  }

  public int getFactorial(int num){
    int total;
    for(int count=1; count>=num; count++){
      total=total*count;
    }
  }

}
