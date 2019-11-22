import java.util.Scanner;

class Runner {
 public static void main(String[] args) {
   Game game = new Game();
   Scanner sc = new Scanner(System.in);
   while(true) {
     game.printTable();

     System.out.println("Player 1:");
     System.out.println("Input row");
     int r1 = sc.nextInt();
     System.out.println("Input column");
     int c1 = sc.nextInt();
     game.insertXO(r1-1,c1-1);
     game.printTable();

     if(game.checkFull() == true){
       break;
     }

     System.out.println("Player 2:");
     System.out.println("Input row");
     int r2 = sc.nextInt();
     System.out.println("Input column");
     int c2 = sc.nextInt();
     game.insertXO(r2-1,c2-1);
     game.printTable();

     if(game.checkFull() == true){
       break;
     }
   }

   System.out.println("Game Over!");
 }
}
