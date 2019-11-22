import java.util.ArrayList;
public class Runner {
	public static void main(String[] args) {
		int row = (int)(Math.random()*3+1);
		int col = (int)(Math.random()*3+1);
		int[][] matrix = new int[row][col];
		for(int r=0; r<matrix.length; r++) {
			for(int c=0; c<matrix[r].length; c++){
				matrix[r][c] = (int)(Math.random()*9+1);
			}
		}


		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new MountainView("John", 15));
		studentList.add(new LosAltos("Jennifer", 16));
		studentList.add(new MountainView("Jose", 14));
		studentList.add(new LosAltos("Kendra", 15));

		if( (int)(Math.random()*2) == 0 ) {
			studentList.add(new LosAltos("Carla", 16));
		}

		String email1 = "john@gmail.com";
		String email2 = "kendra@mvla.net";
		String email3 = "john.smith@yahoo.com";

		//Write the Exam class to do the following.
		Exam test = new Exam();

		//Print the Table in row major order.  Each number is separated by a tab.
		System.out.println("Print Table row:"+row+" col:"+col);
		test.printTable(matrix);

		//Find the Smallest
		System.out.println("\nFind Smallest");
		System.out.println(test.findSmallest(matrix));

		//Return how many occurrence of a given number
		System.out.println("\nFind Occurrence");
		System.out.println(test.findOccurrence(matrix, 5));


//Print the Student List
		//Print the Name, age, and school.
		//Note: Each student should have it's own line.
		//e.g.
		//John, 15, Mountain View HS
		//Jennifer, 16, Los Altos HS
		System.out.println("\nPrint Student List");
		test.printstudentList(studentList);

		//Age
		System.out.println("\nAverage Age of Student List");
		System.out.println(test.averageAge(studentList));  //Should return a double.

//Sort the ArrayList by age from least to greatest
		System.out.println("\nSort Student List by Age");
		test.sort(studentList);
		test.printstudentList(studentList);

		//Email Test
		System.out.println("\nEmail Test");

		//Print out the user john@gmail.com -> john
		System.out.println(test.getUser(email1));

		//Prints the domain john@gmail.com -> gmail
System.out.println(test.getDomain(email2));

//Prints how many 'o' there are. john.smith@yahoo.com -> 4
System.out.println(test.count(email3,'o'));
//Prints how many 'm' there are. john.smith@yahoo.com -> 2
		System.out.println(test.count(email3,'m'));
	}
}
