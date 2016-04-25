/**
 * This class models Quad hand played in a BigTwo card game
 * 
 * @author chengwei
 *
 */
public class Quad extends Hand {

	/**
	 * create and return an instance of Quad class
	 * 
	 * @param player
	 *            Who play this hand
	 * @param cards
	 *            A list of cards in this Quad object
	 */
	Quad(CardGamePlayer player, CardList cards) {
		super(player, cards);
	}

	/**
	 * determining whether this object is really a Quad
	 * 
	 * @return a boolean value specifying whether this is really a Quad
	 */
	boolean isValid() {
		if (list.isEmpty()) {// not empty
			return false;
		} else if (list.size() != 5) {// size correct
			return false;
		} else {// check
			if ((list.getCard(0).getRank() == list.getCard(1).getRank()
					&& list.getCard(1).getRank() == list.getCard(2).getRank()
					&& list.getCard(2).getRank() == list.getCard(3).getRank())
					|| (list.getCard(1).getRank() == list.getCard(2).getRank()
							&& list.getCard(2).getRank() == list.getCard(3).getRank()
							&& list.getCard(3).getRank() == list.getCard(4).getRank())) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * return the top card in a Quad
	 * 
	 * @return a Card object
	 */
	public Card getTopCard() {
		if (list.getCard(0).getRank() == list.getCard(1).getRank()
				&& list.getCard(1).getRank() == list.getCard(2).getRank()
				&& list.getCard(2).getRank() == list.getCard(3).getRank()) {
			return list.getCard(3);
		} else if (list.getCard(1).getRank() == list.getCard(2).getRank()
				&& list.getCard(2).getRank() == list.getCard(3).getRank()
				&& list.getCard(3).getRank() == list.getCard(4).getRank()) {
			return list.getCard(4);
		} else {
			return null;
		}
	}

	/**
	 * return a the name of this hand
	 * 
	 * @return a "Quad" string
	 */
	String getType() {
		return "Quad";
	}

}
