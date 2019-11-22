public class Item{
  private double price;
  private String name;

  public Item(String name, double price ){
    this.price = price;
    this.name = name;
  }

  public double getPrice(){
    return price;
  }

  public String toString(){
    return name + " $" + price ;
  }
}
