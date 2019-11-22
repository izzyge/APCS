public class Game {
 private int[][] table;
 int turn;

 public Game() {
   table = new int[3][3];
   for(int r = 0; r < table.length; r++) {
     for(int c = 0; c < table[r].length; c++) {
       table[r][c] = 0;
     }
   }

   turn = 1;
 }

 public void printTable() {
   for(int[] row : table) {
     for(int item : row) {
       String toPrint = "";
       if(item == 0) toPrint += "-";
       else if(item == 1) toPrint += "X";
       else if(item == 2) toPrint += "O";
       System.out.print(toPrint + "\t");
     }
     System.out.println();
   }

   System.out.println();
 }

 public void insertXO(int x, int y) {
   if(table[x][y] == 0) table[x][y] = turn == 1 ? 1 : 2;
   turn = turn == 1 ? 2 : 1;
 }

 public boolean checkFull() {
   boolean full = true;
   for(int[] row : table) {
     for(int item : row) {
       if(item == 0) full = false;
     }
   }

   return full;
 }

 public int checkTicTacToe(){
   while(turn == 1){
     if( (table[0][0] == 1 && table[0][1] == 1 && table[0][2] == 1) ||
         (table[1][0] == 1 && table[1][1] == 1 && table[1][2] == 1)
         (table[2][0] == 1 && table[2][1] == 1 && table[2][2] == 1)
         (table[0][0] == 1 && table[1][0] == 1 && table[2][0] == 1)
         (table[0][1] == 1 && table[1][0] == 1 && table[2][0] == 1)
     )
   }
 }
}
