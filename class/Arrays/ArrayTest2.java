import java.util.Scanner;
public class ArrayTest2{
  Scanner sc = new Scanner(System.in);

  public void arrayDemo6(){
    System.out.println("Demo 6");
    int[] nums = new int[10];
    for(int i = 0; i<nums.length; i++){
      nums[i] = (int)(Math.random()*9+1);

    }
    for(int each: nums){
      System.out.println(each);
    }

    System.out.println("Change which cell to 0?");
    int change = sc.nextInt();

    nums[change-1] = 0;

    for(int each: nums){
      System.out.println(each);
    }

  }


  public void arrayDemo7(){
    System.out.println("Demo 7");
    String[] words = {"one". "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
    System.out.println("Change which cell?");
    int change = sc.nextInt();

    words[change-1] = ""
  }
}
