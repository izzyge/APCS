import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormulasGraphics extends JPanel implements ActionListener {
	
	private JButton volCylinderButton;
	private JTextField radiusInput;
	private JTextField heightInput;
	private double volCylinder = 0.0;
	
	private JButton pythagoreanButton;
	private JTextField aInput;
	private JTextField bInput;
	private double cValue = 0.0;
	
	private JButton quadraticButton;
	private JTextField aqInput;
	private JTextField bqInput;
	private JTextField cqInput;
	private double x1Value = 0.0;
	private double x2Value = 0.0;
	
	private JButton areaSquareButton;
	private JTextField sideLengthInput;
	private double areaValue = 0.0;
	

	public FormulasGraphics(){
		setLayout(null); //not using layout
		
		//cylinder volume
		volCylinderButton = new JButton("Volume of a Cylinder");
		volCylinderButton.setBounds(50,190,200,30); //set location + size
		add(volCylinderButton);
		volCylinderButton.addActionListener(this);
		
		radiusInput = new JTextField();
		radiusInput.setBounds(50,75,200,30);
		add(radiusInput);
		
		heightInput = new JTextField();
		heightInput.setBounds(50,140,200,30);
		add(heightInput);
		
		//pythagorean
		pythagoreanButton = new JButton("Pythagorean Theorem");
		pythagoreanButton.setBounds(375,210,200,30); //set location + size
		add(pythagoreanButton);
		pythagoreanButton.addActionListener(this);
		
		aInput = new JTextField();
		aInput.setBounds(375,75,200,30);
		add(aInput);
		
		bInput = new JTextField();
		bInput.setBounds(375,145,200,30);
		add(bInput);
		
		//quadratic
		quadraticButton = new JButton("Quadratic Equation");
		quadraticButton.setBounds(50,560,200,30); //set location + size
		add(quadraticButton);
		quadraticButton.addActionListener(this);
		
		aqInput = new JTextField();
		aqInput.setBounds(50,320,200,30);
		add(aqInput);
		
		bqInput = new JTextField();
		bqInput.setBounds(50,395,200,30);
		add(bqInput);
		
		cqInput = new JTextField();
		cqInput.setBounds(50,470,200,30);
		add(cqInput);
		
		//area of a square
		areaSquareButton = new JButton("Area of a Square");
		areaSquareButton.setBounds(375,470,200,30); //set location + size
		add(areaSquareButton);
		areaSquareButton.addActionListener(this);
		
		sideLengthInput = new JTextField();
		sideLengthInput.setBounds(375,360,200,30);
		add(sideLengthInput);

		
		
		
		
		setFocusable(true);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(800,600);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Color brown = new Color(186, 150, 122);
		g.setColor(brown);
		g.fillRect(0,0,800,600);
		
		Color green = new Color(58, 73, 56);
		g.setColor(green);
		g.fillRect(10,10,780,580);
		
		Color white = new Color(255,255,255);
		g.setColor(white);
		
		//volume cylinder
		g.drawString("Volume of a cylinder", 50, 25);
		g.drawString("Enter in a radius", 50, 50);
		g.drawString("Enter in a height", 50, 125);
		
		g.drawString("The volume is " + volCylinder, 50,180);
		
		//pythagorean
		g.drawString("Pythagorean Theorem", 375, 25);
		g.drawString("Enter in a value for a", 375, 50);
		g.drawString("Enter in a value for b", 375, 120);
		
		g.drawString("The value for c is " + cValue, 375,190);
		
		//quadratic
		g.drawString("Quadratic Equation", 50, 270);
		g.drawString("Enter in a value for a", 50, 300);
		g.drawString("Enter in a value for b", 50, 380);
		g.drawString("Enter in a value for c", 50, 460);
		g.drawString("The values for x are " + x1Value + " and " + x2Value, 50, 540);
		
		//area of a square
		g.drawString("Area of a square", 375, 300);
		g.drawString("Enter in a value for side length", 375, 350);
		g.drawString("The value for area is " + areaValue, 375, 420);
		
		

	}
	
	//called when action happens
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == volCylinderButton){
			
			//get info from text field
			String radiusText = radiusInput.getText();
			double radius = Double.parseDouble(radiusText); //converts string to double
			String heightText = heightInput.getText();
			double height = Double.parseDouble(heightText);
			
			//calculate volume of cylinder
			volCylinder = 3.14 * Math.pow(radius,2) * height;
			
			//display graphically
		}
		
		if(e.getSource() == pythagoreanButton){
			
			String aText = aInput.getText();
			double a = Double.parseDouble(aText); 
			String bText = bInput.getText();
			double b = Double.parseDouble(bText);
			
			cValue = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
			
		}
		
		if(e.getSource() == quadraticButton){
			
			String aqText = aqInput.getText();
			double aq = Double.parseDouble(aqText); 
			String bqText = bqInput.getText();
			double bq = Double.parseDouble(bqText);
			String cqText = cqInput.getText();
			double cq = Double.parseDouble(cqText);
			
			
			x1Value = (-bq + Math.sqrt(Math.pow(bq,2) - (4*aq*cq)))/(2*aq);
			x2Value = (-bq - Math.sqrt(Math.pow(bq,2) - (4*aq*cq)))/(2*aq);
			
		}
		
		if(e.getSource() == areaSquareButton){
			
			String sideLengthText = sideLengthInput.getText();
			double sideLength = Double.parseDouble(sideLengthText); //converts string to double

			areaValue = Math.pow(sideLength,2);
			
		}
		
		
		repaint();
		
	}
	
	
	
}
