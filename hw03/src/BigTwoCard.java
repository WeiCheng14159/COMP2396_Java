
public class BigTwoCard extends Card {

	public BigTwoCard(int suit, int rank){
		super(suit, rank);
	}
	
	public int compareTo(Card card){
		int myRank = this.rank;
		int HisRank = card.rank;
		 if(myRank == 0 || myRank == 1){//rank = 2 or A
			 myRank += 13;
		 }
		 if (myRank > HisRank) {
				return 1;
			} else if (myRank < HisRank) {
				return -1;
			} else if (this.suit > card.suit) {
				return 1;
			} else if (this.suit < card.suit) {
				return -1;
			} else {
				return 0;
			}
	}
}
