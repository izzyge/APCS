public class Runner{
  public static void main(String[] args){
    ComputerScienceStudent css = new ComputerScienceStudent("Judy");
    System.out.println(css.saying());

    Student s = (Student) css;
    System.out.println(s.saying());
  }
}
