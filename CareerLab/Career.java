public class Career{
	private String name;
	private int age;
	private String subject;
	private String hobby;
	private String food;
	
	public Career(String n, int a, String s, String h, String f){
		name = n;
		age = a;
		subject = s;
		hobby = h;
		food = f;
	}
	
	public void printInfo(){
		System.out.println("name: " + name);
		System.out.println("age: " + age);
		System.out.println("subject: " + subject);
		System.out.println("hobby: " + hobby);
		System.out.println("food: " + food);
		printCareer();
		System.out.println();
		
	}
	
	private void printCareer(){
		if(subject.equals("Math") && hobby.equals("Soccer") && food.equals("Salad")){
			System.out.println("Future Career: Doctor");
		}
		
		else if(subject.equals("Math") && hobby.equals("Soccer") && food.equals("Pasta")){
			System.out.println("Future Career: Engineer");
		}
		
		else if(subject.equals("Math") && hobby.equals("Movies") && food.equals("Salad")){
			System.out.println("Future Career: Graphic Designer");
		}
		
		else if(subject.equals("Math") && hobby.equals("Movies") && food.equals("Pasta")){
			System.out.println("Future Career: Mathmetician");
		}
		
		else if(subject.equals("English") && hobby.equals("Soccer") && food.equals("Salad")){
			System.out.println("Future Career: Physical Therapist");
		}
		
		else if(subject.equals("English") && hobby.equals("Soccer") && food.equals("Pasta")){
			System.out.println("Future Career: Psychologist");
		}
		
		else if(subject.equals("English") && hobby.equals("Movies") && food.equals("Salad")){
			System.out.println("Future Career: Producer");
		}
		
		else if(subject.equals("English") && hobby.equals("Movies") && food.equals("Pasta")){
			System.out.println("Future Career: Photographer");
		}
		
		else if(subject.equals("History") && hobby.equals("Soccer") && food.equals("Salad")){
			System.out.println("Future Career: Professor");
		}
		
		else if(subject.equals("History") && hobby.equals("Soccer") && food.equals("Pasta")){
			System.out.println("Future Career: Lawyer");
		}
		
		else if(subject.equals("History") && hobby.equals("Movies") && food.equals("Salad")){
			System.out.println("Future Career: Interior Designer");
		}
		
		else if(subject.equals("History") && hobby.equals("Movies") && food.equals("Pasta")){
			System.out.println("Future Career: Musician");
		}
	}
	
	public void updateProfile(String n, int a, String s, String h, String f){
		name = n;
		age = a;
		subject = s;
		hobby = h;
		food = f;
	}
	
}
