public class WarmUp{
  int[][]numMatrix;

  public WarmUp(int[][] nums){
    numMatrix = nums;
  }

  public void print(){
    for(int r = 0; r<numMatrix.length; r++){
      for(int c = 0; c<numMatrix[r].length; c++){
        System.out.print(numMatrix[r][c] + "\t");
      }
      System.out.println();
    }
    System.out.println();
  }

  public int findLargest(){
    int largest = 0;
    for(int r = 0; r<numMatrix.length; r++){
      for(int c = 0; c<numMatrix[r].length; c++){
        if(numMatrix[r][c] > largest)
        largest = numMatrix[r][c];
      }
    }
    return largest;
  }

  
}
