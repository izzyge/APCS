import java.util.Scanner;
public class Runner{
	public static void main(String[] args){
	
		for(int i = 1; i>0; i++){
		
		Scanner s = new Scanner(System.in);
		System.out.println("Select a Formula. Enter in a number");
		System.out.println("1. Volume of a Cone");
		System.out.println("2. Volume of a Cylinder");
		System.out.println("3. Volume of a Sphere");
		System.out.println("4. Area of a Triangle");
		System.out.println("5. Area of a Rectangle");
		System.out.println("6. Area of a Circle");
		System.out.println("7. Pythagorean Theorem");
		System.out.println("8. Quadratic Equation");
		System.out.println("9. Distance Formula");
		System.out.println("10. Slope Formula");
		System.out.println("11. Speed Formula");
		System.out.println("12. Velocity Formula");
		System.out.println("13. Kinetic Energy Formula");
		System.out.println("14. Tension Formula");
		System.out.println("15. Force of Gravity Formula");
		System.out.println("0. QUIT");
		

			int selection = s.nextInt();
			Formulas fm = new Formulas();
			
			if(selection == 1){
				fm.volumeCone();
			
			} else if(selection == 2){
				fm.volumeCylinder();
			
			} else if(selection == 3){
				fm.volumeSphere();
			
			} else if(selection == 4){
				fm.areaTriangle();
			
			} else if(selection == 5){
				fm.areaRectangle();
			
			} else if(selection == 6){
				fm.areaCircle();
			
			} else if(selection == 7){
				fm.pythagorean();
			
			} else if(selection == 8){
				fm.quadraticFormula();
			
			} else if(selection == 9){
				fm.distanceFormula();
			
			} else if(selection == 10){
				fm.slopeFormula();
			
			} else if(selection == 11){
				fm.speedFormula();
					
			} else if(selection == 12){
				fm.velocityFormula();
				
			} else if(selection == 13){
				fm.kineticEnergyFormula();
				
			} else if(selection == 14){
				fm.tensionFormula();
				
			} else if(selection == 15){
				fm.forceGravityFormula();
			
			} else if (selection == 0){
				System.out.println("Quitting...");
				break;
			}
			
			
		}
		
	}
	
}


