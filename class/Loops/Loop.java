public class Loop{
	private int max;
	private int min;
	
	public Loop(int m, int n){
		min = m;
		max = n;
	}
	
	public void countWhile(){
		int count = min;
		while ( count <= max ){
			System.out.println(count);
			count += 2;
		}

	}
	
	public int getSum(){
		int total = 0;
		int count = min;
		do {
			total += count;
			count += 2;
		} while(count <= max);
		return total;

	}
}