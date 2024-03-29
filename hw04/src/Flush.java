/**
 * This class models Flush hand played in a BigTwo card game
 * 
 * @author chengwei
 *
 */
public class Flush extends Hand {

	/**
	 * create and return an instance of Flush class
	 * 
	 * @param player
	 *            Who play this hand
	 * @param cards
	 *            A list of cards in this Flush object
	 */
	Flush(CardGamePlayer player, CardList cards) {
		super(player, cards);
	}

	/**
	 * determining whether this object is really a Flush
	 * 
	 * @return a boolean value specifying whether this is really a Flush
	 */
	boolean isValid() {
		if (list.isEmpty()) {// a flush must not be empty
			return false;
		} else if (list.size() != 5) {// size should be correct
			return false;
		} else {// check suit in flush
			for (int i = 0; i < 5; i++) {
				if (list.getCard(0).getSuit() != list.getCard(i).getSuit()) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * return the top card in a Flush
	 * 
	 * @return a Card object
	 */
	public Card getTopCard() {
		return list.getCard(4);
	}

	/**
	 * return a the name of this hand
	 * 
	 * @return a "Flush" string
	 */
	String getType() {
		return "Flush";
	}

}
