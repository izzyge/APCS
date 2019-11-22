public class Programmer extends Profile{
  public Programmer(String e1, String e2){
    super(e1, e2);
  }

  public String getInfo(){
    return "Programmer, " + super.getName() + ", " + super.getEmployer();
  }
}
