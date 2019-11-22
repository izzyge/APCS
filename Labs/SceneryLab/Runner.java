import javax.swing.JFrame;
import java.util.Scanner;

public class Runner{
	public static void main(String[] args){
		JFrame fr= new JFrame("Scenery");
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter 1 for day and 2 for night");
		int bInput = s.nextInt();
		
		System.out.println("Enter 1 for cloudy sky and 2 for clear sky");
		int cInput = s.nextInt();
		
		Scenery sc = new Scenery(bInput,cInput);
		
		
		
		fr.add(sc);
		
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.pack();
		fr.setVisible(true);
	}
}
