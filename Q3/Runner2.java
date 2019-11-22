public class Runner2{
  public static void main(String[] args){
    StringTest2 st = new StringTest2("hello java");

    st.printEachChar();
    System.out.println(st.contains("dog"));
    System.out.println(st.contains("java"));
    System.out.println(st.countChar('a'));
    System.out.println(st.countChar('z'));
  }
}
