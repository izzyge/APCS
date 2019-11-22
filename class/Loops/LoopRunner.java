public class LoopRunner{
	public static void main(String[] args){
		Loop loop = new Loop(10,20);
		
		loop.countWhile();
		
		int sum = loop.getSum();
		System.out.println(sum);
	}
}