public class WarmUp{
  int[][]numMatrix;

  public WarmUp(int[][]numMatrix){
    this.numMatrix = numMatrix;
  }

  public void print(){
    for(int r=0; r<numMatrix.length; r++){
      for(int c=0; c<numMatrix[r].length; c++){
        System.out.print(numMatrix[r][c] + "\t");
      }
      System.out.println();
    }
    System.out.println();
  }

  public void replaceLargest(){
    int largest = numMatrix[0][0];
    for(int r=0; r<numMatrix.length; r++){
      for(int c=0; c<numMatrix[r].length; c++){
        if(numMatrix[r][c] > largest)
          largest = numMatrix[r][c];
      }
    }

    for(int r=0; r<numMatrix.length; r++){
      for(int c=0; c<numMatrix[r].length; c++){
        if(numMatrix[r][c] == largest)
          numMatrix[r][c] = -1;
      }
    }
  }
}
