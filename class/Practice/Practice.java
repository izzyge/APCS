public class Practice{

  String name;

  public Practice(){
    name = "Jen";
  }

  public Practice(String name){
    this.name = name;
  }

  public void printName(){
    System.out.println(name);
  }

  public boolean checkNum(int one, int two, int three){
    if(one == two && two == three){
      return true;
    } else {
      return false;
    }
  }

  public void whileCount1(int num){
    int count = 1;
    while(count<= num){
      System.out.println(count + ", ");
      count++;
    }
  }

  public void forCount1(int num1, int num2){
     if(num1<num2){
       for(int i = num1; i<num2; i++){
         System.out.println(i+ ", ");
       }
     } else if(num1>num2){
       for(int i = num2; i<num1; i++){
         System.out.println(i+", ");
       }
     }
  }

  public String getIfElse(int num){
    if(num == 1){
      return "cat";
    } else if (num == 2){
      return "dog";
    } else if( num == 3){
      return "bear"
    } else {
      return "not valid";
    }
  }

  public void printSwitch(int num){
    switch(num){
      case 1:
        System.out.println("car");
        break;
      case 2:
        System.out.println("airplane");
        break;
      case 3:
        System.out.println("door");
        break;
      default:
        System.out.println("not valid");
        break;

    }
  }

  public int getRand1(){
    return (int)(Math.random() * 14 + 4);
  }

  public void print(int[] nums){
    for(int each: nums){
      System.out.println(each);
    }
  }

  public int[] replace5(int[] nums){
    for(int i = 0; i<nums.length; i++){
      
    }
  }

}
