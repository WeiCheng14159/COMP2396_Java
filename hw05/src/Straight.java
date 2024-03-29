import java.util.*;

/**
 * This class models Straight hand played in a BigTwo card game
 * 
 * @author chengwei
 *
 */
public class Straight extends Hand {

	/**
	 * create and return an instance of Straight class
	 * 
	 * @param player
	 *            Who play this hand
	 * @param cards
	 *            A list of cards in this Straight object
	 */
	Straight(CardGamePlayer player, CardList cards) {
		super(player, cards);
	}

	/**
	 * determining whether this object is really a Straight
	 * 
	 * @return a boolean value specifying whether this is really a Straight
	 */
	boolean isValid() {
		if (list.isEmpty()) {// not empty
			return false;
		} else if (list.size() != 5) {// size correct
			return false;
		} else {// check rank
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
	 * return the top card in a Straight
	 * 
	 * @return a Card object
	 */
	public Card getTopCard() {
		if (list.getCard(4).rank - list.getCard(0).rank == 4) {
			return list.getCard(4);
		} else if (list.getCard(4).rank - list.getCard(0).rank == 12) {
			if (list.getCard(1).rank == 1) {
				return list.getCard(1);
			} else {
				return list.getCard(0);
			}
		} else {
			return null;
		}
	}

	/**
	 * return a the name of this hand
	 * 
	 * @return a "Straight" string
	 */
	String getType() {
		return "Straight";
	}
}
