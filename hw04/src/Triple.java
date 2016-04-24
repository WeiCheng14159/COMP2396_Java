/**
 * This class models Triple hand played in a BigTwo card game
 * 
 * @author chengwei
 *
 */
public class Triple extends Hand {

	/**
	 * create and return an instance of Triple class
	 * 
	 * @param player
	 *            Who play this hand
	 * @param cards
	 *            A list of cards in this Triple object
	 */
	Triple(CardGamePlayer player, CardList cards) {
		super(player, cards);
	}

	/**
	 * determining whether this object is really a Triple
	 * 
	 * @return a boolean value specifying whether this is really a Triple
	 */
	boolean isValid() {
		if (list.isEmpty()) {// not empty
			return false;
		} else if (list.size() != 3) {// size correct
			return false;
		} else {
			if (list.getCard(0).getRank() == list.getCard(1).getRank()
					&& list.getCard(1).getRank() == list.getCard(2).getRank()) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * return the top card in a Triple
	 * 
	 * @return a Card object
	 */
	public Card getTopCard() {
		return list.getCard(2);
	}

	/**
	 * return a the name of this hand
	 * 
	 * @return a "Triple" string
	 */
	String getType() {
		return "Triple";
	}

}
