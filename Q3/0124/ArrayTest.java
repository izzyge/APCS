public class ArrayTest{
  private int[] nums;

  public ArrayTest(int size){
    nums = new int[size];
    for(int i = 0; i<nums.length;i++){
      nums[i] = (int)(Math.random() * 9 + 1);
    }
  }

  public void printArray(){
    for(int each: nums){
      System.out.println(each);
    }
    System.out.println();
  }

  public void scramble(){
    for(int i = 0; i<nums.length;i++){
      int j = (int)(Math.random() * (nums.length -1 ) + 1);
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
  }

  public void sort(){
    for(int i = 0; i<nums.length-1; i++){
     int min = i;
     int current = i;

     for(int j = i+1; j<nums.length; j++){

       if(nums[j] < nums[min]){
         min = j;
       }
     }

     if(min!= current){
       int temp = nums[current];
       nums[current] = nums[min];
       nums[min] = temp;

     }
   }
  }
}
