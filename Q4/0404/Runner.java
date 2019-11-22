public class Runner{
  public static void main(String[] args){
    Programmer p1 = new Programmer("Jennifer");
    p1.getInfo();
    p1.addCredits(10);
    Teacher t1 = new Teacher("John");
    t1.getInfo();
    t1.addCredits(12);

    System.out.println("Credits: " + Profile.getCredits());
  }
}
