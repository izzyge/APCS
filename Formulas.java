import java.util.Scanner;
public class Formulas{
	private Scanner s = new Scanner(System.in);
	private double  pi = 3.14;
	private double gravity = 9.8;
	
	public void volumeCone(){
		System.out.println("Volume of a cone");
		
		System.out.println("Input a radius: ");
		double radius = s.nextDouble(); 
		
		System.out.println("Input a height: ");
		double height = s.nextDouble();
		
		double vol = (pi * radius * radius * height)/3.0;
		System.out.println("Volume: " + vol);
	}
	
	public void volumeCylinder(){
		System.out.println("Volume of a Cylinder");
		
		System.out.println("Input a radius: ");
		double radius = s.nextDouble();
		
		System.out.println("Input a height: ");
		double height = s.nextDouble();
		
		double vol = radius * radius * pi *  height;
		System.out.println("Volume: " + vol);
	}
	
	public void volumeSphere(){
		System.out.println("Volume of a Sphere");
		
		System.out.println("Input a radius: ");
		double radius = s.nextDouble();
		
		double vol = (Math.pow(radius,3) * 4 * pi)/3;
		System.out.println("Volume: " + vol);
	}
	
	public void areaTriangle(){
		System.out.println("Area of a Triangle");
		
		System.out.println("Input a base: ");
		double base = s.nextDouble();
		
		System.out.println("Input a height: ");
		double height = s.nextDouble();
		
		double area = base * height * .5;
		System.out.println("Area: " + area);
	}
	
	public void areaRectangle(){
		System.out.println("Area of a Rectangle");
		
		System.out.println("Input a base: ");
		double base = s.nextDouble();
		
		System.out.println("Input a height: ");
		double height = s.nextDouble();
		
		double area = base * height;
		System.out.println("Area: " + area);
	}
	
	public void areaCircle(){
		System.out.println("Area of a Circle");
		
		System.out.println("Input a radius: ");
		double radius = s.nextDouble();
		
		double area = Math.pow(radius,2) * pi;
		System.out.println("Area: " + area);
	}
	
	public void pythagorean(){
		System.out.println("Pythagorean Theorem");
		
		System.out.println("Input a: ");
		double a = s.nextDouble();
		
		System.out.println("Input b: ");
		double b = s.nextDouble();
		
		double c = Math.sqrt((a*a) + (b*b));
		System.out.println("c: " + c);
	}
	
	public void quadraticFormula(){
		System.out.println("Quadratic Formula");
		
		System.out.println("Input a: ");
		double a = s.nextDouble();
		
		System.out.println("Input b: ");
		double b = s.nextDouble();
		
		System.out.println("Input c: ");
		double c = s.nextDouble();
		
		double xpositive = (-b + Math.sqrt(Math.pow(b,2) - (4*a*c))) /(2*a);
		double xnegative = (-b - Math.sqrt(Math.pow(b,2) - (4*a*c)))/(2*a);
		System.out.println("x = " + xpositive + ", " + xnegative);
	}
	
	public void distanceFormula(){
		System.out.println("Distance Formula");
		
		System.out.println("Input x1: ");
		double x1 = s.nextDouble(); 
		
		System.out.println("Input y1: ");
		double y1 = s.nextDouble(); 
		
		System.out.println("Input x2: ");
		double x2 = s.nextDouble(); 
		
		System.out.println("Input y2: ");
		double y2 = s.nextDouble();
		
		double distance = Math.sqrt(Math.pow((y2 - y1),2) + Math.pow((x2 - x1),2));
		System.out.println("Distance: " + distance);
	}
	
	public void slopeFormula(){
		System.out.println("Slope Formula");
		
		System.out.println("Input x1: ");
		double x1 = s.nextDouble(); 
		
		System.out.println("Input y1: ");
		double y1 = s.nextDouble(); 
		
		System.out.println("Input x2: ");
		double x2 = s.nextDouble(); 
		
		System.out.println("Input y2: ");
		double y2 = s.nextDouble();
		
		double slope = (y2 - y1)/(x2 - x1);
		System.out.println("Slope: " + slope);
	}
	
	public void speedFormula(){
		System.out.println("Speed Formula");
		
		System.out.println("Input distance: ");
		double d = s.nextDouble();
		
		System.out.println("Input time: ");
		double t = s.nextDouble();
		
		double s = d/t;
		System.out.println("Speed: " + s);
	}
	
	public void velocityFormula(){
		System.out.println("Velocity Formula");
		
		System.out.println("Input displacement: ");
		double d = s.nextDouble();
		
		System.out.println("Input time: ");
		double t = s.nextDouble();
		
		double v = d/t;
		System.out.println("Velocity: " + v);
	}
	
	public void kineticEnergyFormula(){
		System.out.println("Kinetic Energy Formula");
		
		System.out.println("Input mass: ");
		double mass = s.nextDouble();
		
		System.out.println("Input velocity: ");
		double v = s.nextDouble();
		
		double ke = .5 * mass * Math.pow(v,2);
		System.out.println("Kinetic Energy: " + ke);
	}
	
	public void tensionFormula(){
		System.out.println("Tension Formula");
		
		System.out.println("Input mass: ");
		double mass = s.nextDouble();
		
		double tension = mass * gravity;
		System.out.println("Tension: " + tension);
	}
	
	public void forceGravityFormula(){
		System.out.println("Force of Gravity Formula: ");
		
		System.out.println("Input Mass 1: ");
		double m1 = s.nextDouble();
		
		System.out.println("Input Mass 2: ");
		double m2 = s.nextDouble();
		
		System.out.println("Input Distance Between Objects: ");
		double d = s.nextDouble();
		
		double fg = (gravity * m1 * m2)/(d * d);
		System.out.println("Force of Gravity: " + fg);
	}
	
	
}
