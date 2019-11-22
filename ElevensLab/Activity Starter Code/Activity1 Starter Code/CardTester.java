/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card c1 = new Card("Jack", "Hearts",11);
		System.out.println(c1.suit());
		System.out.println(c1.rank());
		System.out.println(c1.pointValue());

		Card c2 = new Card("3", "Diamonds",3);
		System.out.println(c2.suit());
		System.out.println(c2.rank());
		System.out.println(c2.pointValue());

		Card c3 = new Card("10", "Spades",10);
		System.out.println(c3.suit());
		System.out.println(c3.rank());
		System.out.println(c3.pointValue());
	}
}
