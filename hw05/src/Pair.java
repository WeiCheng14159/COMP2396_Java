/**
 * This class models Pair hand played in a BigTwo card game
 * 
 * @author chengwei
 *
 */
public class Pair extends Hand {

	/**
	 * create and return an instance of Pair class
	 * 
	 * @param player
	 *            Who play this hand
	 * @param cards
	 *            A list of cards in this Pair object
	 */
	Pair(CardGamePlayer player, CardList cards) {
		super(player, cards);
	}

	/**
	 * determining whether this object is really a Pair
	 * 
	 * @return a boolean value specifying whether this is really a Pair
	 */
	boolean isValid() {
		if (list.isEmpty()) {// not empty
			return false;
		} else if (list.size() != 2) {// size correct
			return false;
		} else {// check
			if (list.getCard(0).getRank() == list.getCard(1).getRank()) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * return the top card in a Pair
	 * 
	 * @return a Card object
	 */
	public Card getTopCard() {
		return list.getCard(1);
	}

	/**
	 * return a the name of this hand
	 * 
	 * @return a "Pair" string
	 */
	String getType() {
		return "Pair";
	}

}
