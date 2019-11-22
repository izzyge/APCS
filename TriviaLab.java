import java.util.Scanner;
import java.util.Random;
public class TriviaLab{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("Choose a category (math or geography)");
		String category = s.next();
		int score = 0;
		if(category.equals("geography")){
			//1
			System.out.println("1. What country is Tokyo the capital of?");
			String a1 = s.next();
			if(a1.equals("Japan")){
				System.out.println("Correct!");
				score ++;
			} else{
				System.out.println("Incorrect");
			}
			//2
			System.out.println("2. What is the capital of China?");
			String a2 = s.next();
			if(a2.equals("Beijing")){
				System.out.println("Correct!");
				score ++;
			} else{
				System.out.println("Incorrect");
			}
			//3
			System.out.println("3. Which country has the largest population?");
			String a3 = s.next();
			if(a3.equals("China")){
				System.out.println("Correct!");
				score++;
			} else{
				System.out.println("Incorrect");
			}
			//4
			System.out.println("4. What country are the Great Pyramids in?");
			String a4 = s.next();
			if(a4.equals("Egypt")){
				System.out.println("Correct!");
				score++;
			} else{
				System.out.println("Incorrect");
			}
			//5
			System.out.println("5. What is the capital of France?");
			String a5 = s.next();
			if(a5.equals("Paris")){
				System.out.println("Correct!");
				score++;
			} else{
				System.out.println("Incorrect");
			}
			//6
			System.out.println("6. In which state can you find the Golden Gate Bridge?");
			String a6 = s.next();
			if(a6.equals("California")){
				System.out.println("Correct!");
				score++;
			} else{
				System.out.println("Incorrect");
			}
			//7
			System.out.println("7. Which country is also a continent?");
			String a7 = s.next();
			if(a7.equals("Australia")){
				System.out.println("Correct!");
				score++;
			} else{
				System.out.println("Incorrect");
			}
			//8
			System.out.println("8. Which country borders the US in the North?");
			String a8 = s.next();
			if(a8.equals("Canada")){
				System.out.println("Correct!");
				score++;
			} else{
				System.out.println("Incorrect");
			}
			//9
			System.out.println("9. Which country borders the US in the South?");
			String a9 = s.next();
			if(a9.equals("Mexico")){
				System.out.println("Correct!");
				score++;
			} else{
				System.out.println("Incorrect");
			}
			//10
			System.out.println("10. What's the largest country in the world by area?");
			String a10 = s.next();
			if(a10.equals("Russia")){
				System.out.println("Correct!");
				score++;
			} else{
				System.out.println("Incorrect");
			}		
		
		} else if(category.equals("math")) {
			Random rand = new Random();
			//1
			int length = rand.nextInt(15);
			int width = rand.nextInt(15);
			double area = length * width;
			System.out.println("1. Find the area of a rectangle if width = " + width + " and length = " + length);
			double m1 = s.nextDouble();
			if(m1 == area){
				System.out.println("Correct!");
				score ++;
			} else{
				System.out.println("Incorrect");
			}
			//2
			length = rand.nextInt(15);
			width = rand.nextInt(15);
			double perimeter = (length + width) *2;
			System.out.println("2. Find the perimeter of a rectangle if width = " + width + " and length = " + length);
			double m2 = s.nextDouble();
			if(m2 == perimeter){
				System.out.println("Correct!");
				score ++;
			} else{
				System.out.println("Incorrect");
			}
			//3
			length = rand.nextInt(15);
			width = rand.nextInt(15);
			double tarea = (length * width)/2;
			tarea = Math.round(tarea*100.0)/100.0;
			System.out.println("3. Find area of a triangle with width = " + width + " length = " + length);
			double m3 = s.nextDouble();
			if(m3 == tarea){
				System.out.println("Correct!");
				score++;
			} else{
				System.out.println("Incorrect");
			}
			//4
			width = rand.nextInt(10);
			double volume = width * width * width;
			System.out.println("4. Find volume of cube with side length = " + width);
			double m4 = s.nextDouble();
			if(m4 == volume){
				System.out.println("Correct!");
				score ++;
			} else{
				System.out.println("Incorrect");
			}
			//5
			length = rand.nextInt(15);
			width = rand.nextInt(15);
			int height = rand.nextInt(2);
			double rvolume = length * width * height;
			System.out.println("5. Find volume of box with length = " + length + ", width = " + width + " and height = " + height);
			double m5 = s.nextDouble();
			if(m5 == rvolume){
				System.out.println("Correct!");
				score ++;
			} else{
				System.out.println("Incorrect");
			}
			//6
			int radius = rand.nextInt(10);
			double pi = 3.14;
			double circumference = 2 * radius * pi;
			circumference = Math.round(circumference*100.0)/100.0;
			System.out.println("6. Find circumference of circle with radius = " + radius);
			System.out.println(circumference);
			double m6 = s.nextDouble();
			if(m6 == circumference){
				System.out.println("Correct!");
				score ++;
			} else{
				System.out.println("Incorrect");
			}
			//7
			radius = rand.nextInt(10);
			pi = 3.14;
			double carea = radius * radius * pi;
			carea = Math.round(carea*100.0)/100.0;
			System.out.println("7. Find area of circle with radius = " + radius);
			System.out.println(carea);
			double m7 = s.nextDouble();
			if(m7 == carea){
				System.out.println("Correct!");
				score ++;
			} else{
				System.out.println("Incorrect");
			}
			//8
			radius = rand.nextInt(10);
			height = rand.nextInt(10);
			double cvolume = carea * height;
			cvolume = Math.round(cvolume*100.0)/100.0;
			System.out.println("8. Find the volume of a cylinder with radius = " + radius + " and height = " + height);
			System.out.println(cvolume);
			double m8 = s.nextDouble();
			if(m8 == cvolume){
				System.out.println("Correct! ");
				score ++;
			} else{
				System.out.println("Incorrect");
			}
			//9
			double a = rand.nextInt(10);
			double b = rand.nextInt(10);
			double c = Math.sqrt((a * a) + (b * b));
			c = Math.round(c*100)/100;
			System.out.println("9. In a right triangle, if a = " + a + " and b = " + b + ", what is c?");
			System.out.println(c);
			double m9 = s.nextDouble();
			if(m9 == c){
				System.out.println("Correct!");
				score ++;
			} else{
				System.out.println("Incorrect");
			}
			//10
			a = rand.nextInt(10);
			c = rand.nextInt(10);
			b = Math.sqrt((c * c) - (a * a));
			b = Math.round(b*100.0)/100.0;
			System.out.println("10. In a right triangle, if a = " + a + " and c = " + c + ", what is b?");
			System.out.println(b);
			double m10 = s.nextDouble();
			if(m10 == b){
				System.out.println("Correct!");
				score ++;
			}
			
			
			
		} else{
			System.out.println("not a valid category");
		}
		
			System.out.println("Thanks for playing");
			System.out.println("Score: " + score);
	}
}
