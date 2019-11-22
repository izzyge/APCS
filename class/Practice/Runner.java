import java.util.Scanner;

public class Runner{
   public static void main(String args[]){
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;


        Scanner kb = new Scanner(System.in);

        //Write the Practice Class given the following...

        //Practice has a default constructor that set the instance variable called name
        //to "Jen".  It also has an initialization constructor that sets the instance variable called name to what is passed in.
        Practice practice1 = new Practice();
        Practice practice2 = new Practice("John");

        //Practice has a method that will print the instance variable name.
        System.out.println("Print names");
        practice1.printName();
        practice2.printName();
        System.out.println("\n\n");


        System.out.println("Logical Operator");
        //Practice has a method that will Check if 3 numbers are the same and return true
        //or false otherwise.
        num1 = 3;
        num2 = 4;
        num3 = 4;
        System.out.println("First Check: " + practice1.checkNum(num1, num2, num3));
        num1 = 4;
        num2 = 4;
        num3 = 4;
        System.out.println("Second Check: " + practice1.checkNum(num1, num2, num3));
        System.out.println("\n\n");


        System.out.println("while Loop");
        //Practice has a method that will count from 1 to the number passed inclusive on one line with
        //a comma in between each number using a while loop.
        num1 = (int)(Math.random()*15 + 1);
        System.out.println("num1: " + num1);
        practice1.whileCount1(num1);
        System.out.println("\n\n");


        System.out.println("For Loop");
        //Practice has a method that will count from num1 to num2 by 1 inclusive using a for loop on one line.
        //It will count up or down depending on the numbers.
        num1 = (int)(Math.random()*15 + 1);
        num2 = (int)(Math.random()*15 + 1);
        System.out.println("num1: " + num1 + ", num2: " + num2);
        practice1.forCount1(num1,num2);
        System.out.println("\n\n");


        System.out.println("summation");
        //Practice has a method that will return the summation of the number passed using a for
        //loop. For example, if you pass in 5, it will return 15 which is 1+2+3+4+5
        num1 = (int)(Math.random()*15 + 1);
        System.out.println("num1: " + num1);
        System.out.println(practice1.summation(num1));
        System.out.println("\n\n");


        //if-else, switch
        System.out.println("switch if-else)");
        num1 = (int) (Math.random() * 5) + 1;
        num2 = (int) (Math.random() * 5) + 1;
        System.out.println("num1: " + num1 + ", num2: " + num2);


        //Use an if-else. Given 1 return "cat", Given 2 return "dog", Given 3 return "bear", Given anything else return "not valid"
        String result = practice1.getIfElse(num1);
        System.out.println("if-else result: " + result);


        //Use a switch. Given 1 print "car", Given 2 print "airplane", Given 3 print "door", Given anything else print "not valid"
        System.out.print("switch result: ");
        practice1.printSwitch(num2);
        System.out.println("\n\n");

        System.out.println("Random Numbers");
        //Practice has a method that will return a random number between 4 and 17 inclusive
        System.out.println( practice1.getRand1() );
        System.out.println("\n\n");


        System.out.println("Arrays 1");
        //Practice has a method that will print the array using a for-each loop.
        int[] array = {1,3,5,2,1};
        practice1.print(array);
        System.out.println("\n");

        System.out.println("Arrays 2");
        //Practice has a method that will take in an array and will make another array that is the same
        //but with all the 5 replaced with 0.  Then return it.
        int[] array1 = {1,3,1,13,5}; //-> {1,3,1,13,0};
        int[] array2 = {1,5,5,13}; //-> {1,0,0,13};
        int[] result1 = practice1.replace5(array1);
        int[] result2 = practice1.replace5(array1);
        practice1.print(result1);
        practice1.print(result2);
        System.out.println("\n\n");

   }//End Main
}//End Class
