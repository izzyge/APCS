public class StringReview{
  private String fullname;

  public StringReview(String str){
    fullname = str;
  }

  public String getLastName(){
    return fullname.substring(fullname.lastIndexOf('.')+1, fullname.length());
  }

  public String toString(){
    String str = "Your name is " + fullname.substring(0, fullname.indexOf('.')) +
    " " + fullname.substring(fullname.indexOf('.')+1, fullname.lastIndexOf('.')) +
    " " + getLastName();
    return str;
  }
}
