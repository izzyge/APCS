public class StringTest2{
  private String myText;

  public StringTest2(String text){
    myText = text;
  }

  public void printEachChar(){
    for(int i = 0; i<myText.length(); i++){
      System.out.println(myText.charAt(i) + " ");
    }
  }

  public boolean contains(String string){
    int contain = myText.indexOf(string);
    if(contain == -1){
      return false;
    } else {
      return true;
    }
  }

  public int countChar(char c){
    int count = 0;

      if(myText.indexOf(c) != -1){
        count ++;
      }
    
    return count;

  }

}
