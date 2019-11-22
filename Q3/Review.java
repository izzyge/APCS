public class Review{
  private int[] nums;

  public Review(int a){
    nums = new int[a];

    for(int i = 0; i<nums.length; i++){
      nums[i] = (int) (Math.random() * 3 +2);
    }
  }

  public void printArray(){
    for(int i = 0; i<nums.length; i++){
      System.out.println(nums[i]);
    }
  }
}
