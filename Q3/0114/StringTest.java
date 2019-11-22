public class StringTest{
  private String word;

  public StringTest(String w){
    word = w;
  }

  private char getFirstLetter(){
    return word.charAt(0);
  }

  private char getLastLetter(){
    return word.charAt(word.length() -1);
  }

  public void printWordGame(){
    System.out.print(getFirstLetter());
    for(int i = 1; i<word.length()-1; i++){
      System.out.print("*");
    }
    System.out.println(getLastLetter());
  }
}
