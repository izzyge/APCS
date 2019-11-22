public class Runner{
	public static void main(String[] args){
		Distance d = new Distance();
		d.setDistance(2, 6, 3, 6);
		double distance = d.getDistance();
		System.out.println(distance);
	}
}