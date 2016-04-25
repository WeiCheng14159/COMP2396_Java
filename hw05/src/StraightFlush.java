import java.util.ArrayList;

/**
 * This class models StraightFlush hand played in a BigTwo card game
 * 
 * @author chengwei
 *
 */
public class StraightFlush extends Hand {

	/**
	 * create and return an instance of StraightFlush class
	 * 
	 * @param player
	 *            Who play this hand
	 * @param cards
	 *            A list of cards in this StraightFlush object
	 */
	StraightFlush(CardGamePlayer player, CardList cards) {
		super(player, cards);
	}

	/**
	 * determining whether this object is really a StraightFlush
	 * 
	 * @return a boolean value specifying whether this is really a StraightFlush
	 */
	boolean isValid() {
		if (list.isEmpty()) {// not empty
			return false;
		} else if (list.size() != 5) {// size correct
			return false;
		} else {// check getSuit()
			for (int i = 0; i < 5; i++) {
				if (list.getCard(0).getSuit() != list.getCard(i).getSuit()) {
					return false;
				}
			}
			// check getRank()
			ArrayList<Integer> rankArray = new ArrayList<Integer>();
			for (int i = 0; i < 5; i++) {// find out big 2 and ace
				rankArray.add(list.getCard(i).getRank());
				if (list.getCard(i).getRank() == 0 || list.getCard(i).getRank() == 1) {
					rankArray.set(i, rankArray.get(i) + 13);
				}
			}
			rankArray.sort(null);
			for (int i = 1; i < 5; i++) {
				if (rankArray.get(i) - rankArray.get(i - 1) != 1) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * return the top card in a StraightFlush
	 * 
	 * @return a Card object
	 */
	public Card getTopCard() {
		if (list.getCard(4).getRank() - list.getCard(0).getRank() == 4) {
			return list.getCard(4);
		} else if (list.getCard(4).getRank() - list.getCard(0).getRank() == 12) {
			if (list.getCard(1).getRank() == 1) {// big two
				return list.getCard(1);
			} else {// ace
				return list.getCard(0);
			}
		} else {
			return null;
		}
	}

	/**
	 * return a the name of this hand
	 * 
	 * @return a "StraightFlush" string
	 */
	String getType() {
		return "StraightFLush";
	}

}
