public class GrayImage
{
    public static final int BLACK = 0;
    public static final int WHITE = 255;


    /** The 2-dimensional representation of this image. Guaranteed not to be null.
    *  All values in the array are within the range [BLACK, WHITE], inclusive.
    */
    private int[][] pixelValues;

    public GrayImage(int[][] pixelValues)
    {
        this.pixelValues = pixelValues;
    }


    /** @return the total number of white pixels in this image.
    *  Postcondition: this image has not been changed.
    */
    public int countWhitePixels()
    {  /* to be implemented in part (a) */
      int count = 0;
      for(int r = 0; r<pixelValues.length; r++){
        for(int c = 0; c<pixelValues[r].length; c++){
          if(pixelValues[r][c] == WHITE)
            count++;
        }
      }
      return count;


    }

    public void processImage()
    {  /* to be implemented in part (b) */
      for(int r = 0; r<pixelValues.length; r++){
        for(int c = 0; c<pixelValues[r].length; c++){
          if(r+2< pixelValues.length && c+2< pixelValues[r].length){
            int newValue = pixelValues[r+2][c+2];
            if(pixelValues[r][c] - newValue >= 0)
              pixelValues[r][c] -= newValue;
            else
              pixelValues[r][c] = 0;

          }
        }
      }

    }

    public void printPixels()
    {
        for(int row=0; row < pixelValues.length; row++)
        {
            for(int col=0; col < pixelValues[row].length; col++)
            {
                System.out.print( pixelValues[row][col] + "\t" );
            }
            System.out.println("");
        }
    }
}
