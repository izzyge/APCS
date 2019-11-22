public class ArrayTest{
  String[] words;

  public ArrayTest(){
    words = new String[5];
    words[0] = "pig";
    words[1] = "horse";
    words[2] = "dog";
    words[3] = "cow";
    words[4] = "sheep";
  }

  public void printWords(){
    for(String each: words){
      System.out.println(each);
    }
  }

  public void swapWords(int one, int two){
    String temp = words[one];
    words[one] = words[two];
    words[two] = temp;
  }
}
