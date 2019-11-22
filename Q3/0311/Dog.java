public class Dog extends Animal{
  public Dog(String a){
    super(a);
  }

  public void printInfo(){
    super.getName();
    super.speak();
    this.speak();
  }

  @Override
  public void speak(){
    System.out.println("woof");
  }
}
