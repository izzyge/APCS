import java.util.Scanner;
public class Runner{
	public static void main(String[] args){
		Career p1 = new Career("Amy", 18, "Math", "Movies", "Salad");
		Career p2 = new Career("Alex", 17, "Math", "Soccer", "Pasta");
		Career p3 = new Career("Nancy", 14, "English", "Movies", "Salad");

		while(true){
			Scanner sc = new Scanner(System.in);
			System.out.println("Which profile would you like to update? (p1, p2, p3, or quit)");
			String profile = sc.next();	
			
		if(profile.equals("p1")){
			p1.printInfo();
			p2.printInfo();
			p3.printInfo();
		
			System.out.println("Input name: ");
			String n = sc.next();
			System.out.println("Input age: ");
			int a = sc.nextInt();
			System.out.println("Input favorite subject: (Math, English, or History) ");
			String s = sc.next();
			System.out.println("Input favorite hobby: (Soccer or Movies)");
			String h = sc.next();
			System.out.println("Input favorite food: (Salad or Pasta)");
			String f = sc.next();
			System.out.println("Updating profile 1");
			p1.updateProfile(n, a, s, h, f);
			p1.printInfo();
		}
		
		if(profile.equals("p2")){
			p1.printInfo();
			p2.printInfo();
			p3.printInfo();
		
			System.out.println("Input name: ");
			String n = sc.next();
			System.out.println("Input age: ");
			int a = sc.nextInt();
			System.out.println("Input favorite subject: (Math, English, or History) ");
			String s = sc.next();
			System.out.println("Input favorite hobby: (Soccer or Movies)");
			String h = sc.next();
			System.out.println("Input favorite food: (Salad or Pasta)");
			String f = sc.next();
			System.out.println("Updating profile 2");
			p2.updateProfile(n, a, s, h, f);
			p2.printInfo();
		}
		
		if(profile.equals("p3")){
			p1.printInfo();
			p2.printInfo();
			p3.printInfo();
		
			System.out.println("Input name: ");
			String n = sc.next();
			System.out.println("Input age: ");
			int a = sc.nextInt();
			System.out.println("Input favorite subject: (Math, English, or History) ");
			String s = sc.next();
			System.out.println("Input favorite hobby: (Soccer or Movies)");
			String h = sc.next();
			System.out.println("Input favorite food: (Salad or Pasta)");
			String f = sc.next();
			System.out.println("Updating profile 3");
			p3.updateProfile(n, a, s, h, f);
			p3.printInfo();
		}
		
		if(profile.equals("quit")){
			break;
		}
		 
			 System.out.println("\n\n");
		}
	}
}
