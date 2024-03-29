/**
 * This class models a BigTwo card in BigTwo card game
 * 
 * @author chengwei
 *
 */
public class BigTwoCard extends Card {

	/**
	 * create and return an instance of a BigTwoCard class,
	 * 
	 * @param suit
	 *            an int value between 0 and 3 representing the suit of a card:
	 *            <p>
	 *            0 = Diamond, 1 = Club, 2 = Heart, 3 = Spade
	 * @param rank
	 *            an int value between 0 and 12 representing the rank of a card:
	 *            <p>
	 *            0 = 'A', 1 = '2', 2 = '3', ..., 8 = '9', 9 = '0', 10 = 'J', 11
	 *            = 'Q', 12 = 'K'
	 */
	public BigTwoCard(int suit, int rank) {
		super(suit, rank);
	}

	/**
	 * compare this card and other cards according to the BigTwo game rules The
	 * order of ranks from high to low is 2, A, K, Q, J, 10, 9, 8, 7, 6, 5, 4,
	 * 3. The order of suits from high to low is Spades, Hearts, Clubs,
	 * Diamonds.
	 * 
	 * @param card
	 *            which card should this card compare with
	 * @return an integer show whether this card is larger(1) or smaller(-1) or
	 *         equal(0) the specified card
	 */
	public int compareTo(Card card) {
		int myRank = this.getRank();
		int HisRank = card.getRank();
		if (myRank == 0 || myRank == 1) {// rank = 2 or A
			myRank += 13;
		}
		if (HisRank == 1 || HisRank == 0) {
			HisRank += 13;
		}
		if (myRank > HisRank) {
			return 1;
		} else if (myRank < HisRank) {
			return -1;
		} else if (this.getSuit() > card.getSuit()) {
			return 1;
		} else if (this.getSuit() < card.getSuit()) {
			return -1;
		} else {
			// System.out.println("two cards are the same");
			return 0;
		}
	}
}
