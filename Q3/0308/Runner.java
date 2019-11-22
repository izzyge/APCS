public class Runner{
  public static void main(String[] args){
    int[][]numMatrix = new int[4][5];
    for(int r=0; r<numMatrix.length; r++){
      for(int c=0; c<numMatrix[r].length; c++){
        numMatrix[r][c] = (int)(Math.random() * 50 + 1);
      }
    }

    WarmUp wu = new WarmUp(numMatrix);
    wu.print();
    wu.replaceLargest();
    wu.print();
  }
}
