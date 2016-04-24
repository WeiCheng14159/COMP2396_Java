/**
 * This class models Single hand played in a BigTwo card game
 * 
 * @author chengwei
 *
 */
public class Single extends Hand {

	/**
	 * create and return an instance of Single class
	 * 
	 * @param player
	 *            Who play this hand
	 * @param cards
	 *            A list of cards in this Single object
	 */
	Single(CardGamePlayer player, CardList cards) {
		super(player, cards);
	}

	/**
	 * determining whether this object is really a Single
	 * 
	 * @return a boolean value specifying whether this is really a Single
	 */
	boolean isValid() {
		if (list.size() != 1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * return the top card in a Single
	 * 
	 * @return a Card object
	 */
	public Card getTopCard() {
		return list.getCard(0);
	}

	/**
	 * return a the name of this hand
	 * 
	 * @return a "Single" string
	 */
	String getType() {
		return "Single";
	}

}
