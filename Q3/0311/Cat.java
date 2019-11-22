public class Cat extends Animal{
    public Cat(String a){
      super(a);
    }

    public void printInfo(){
      super.getName();
      super.speak();
      this.speak();
    }

    @Override
    public void speak(){
      System.out.println("meow");
    }

}
