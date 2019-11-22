public abstract class Profile{
  private String employerName;
  private String employeeName;
  public Profile(String e1, String e2){
    employerName = e1;
    employeeName = e2;
  }

  public abstract String getInfo();

  public String getEmployer(){
    return employerName;
  }

  public String getName(){
    return employeeName;
  }
}
