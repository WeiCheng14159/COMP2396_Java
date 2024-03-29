/**
 * This class models FullHouse hand played in a BigTwo card game
 * 
 * @author chengwei
 *
 */
public class FullHouse extends Hand {

	/**
	 * create and return an instance of FullHouse class
	 * 
	 * @param player
	 *            Who play this hand
	 * @param cards
	 *            A list of cards in this FullHouse object
	 */
	FullHouse(CardGamePlayer player, CardList cards) {
		super(player, cards);
	}

	/**
	 * determining whether this object is really a FullHouse
	 * 
	 * @return a boolean value specifying whether this is really a FullHouse
	 */
	boolean isValid() {
		if (list.isEmpty()) {// not empty
			return false;
		} else if (list.size() != 5) {// size correct
			return false;
		} else {// check rank
			if ((list.getCard(0).getRank() == list.getCard(1).getRank()
					&& list.getCard(1).getRank() == list.getCard(2).getRank()
					&& list.getCard(3).getRank() == list.getCard(4).getRank())
					|| (list.getCard(0).getRank() == list.getCard(1).getRank()
							&& list.getCard(2).getRank() == list.getCard(3).getRank()
							&& list.getCard(3).getRank() == list.getCard(4).getRank())) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * return the top card in a FullHouse
	 * 
	 * @return a Card object
	 */
	public Card getTopCard() {
		if (list.getCard(0).getRank() == list.getCard(1).getRank()
				&& list.getCard(1).getRank() == list.getCard(2).getRank()
				&& list.getCard(3).getRank() == list.getCard(4).getRank()) {
			return list.getCard(2);// three cards with same rank at front
		} else if (list.getCard(0).getRank() == list.getCard(1).getRank()
				&& list.getCard(2).getRank() == list.getCard(3).getRank()
				&& list.getCard(3).getRank() == list.getCard(4).getRank())
			return list.getCard(4);// three cards with same rank at back
		else {
			return null;
		}
	}

	/**
	 * return a the name of this hand
	 * 
	 * @return a "FullHouse" string
	 */
	String getType() {
		return "FullHouse";
	}

}
