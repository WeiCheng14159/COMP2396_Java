
public class BigTwoCard extends Card {

	public BigTwoCard(int suit, int rank){
		super(suit, rank);
	}
	
	public int compareTo(Card card){
		int myRank = this.getRank();
		int HisRank = card.getRank();
		//System.out.println(myRank);
		//System.out.println(HisRank);
		 if(myRank == 0 || myRank == 1 ){//rank = 2 or A
			 myRank += 13;
		 }
		 if( HisRank == 1 || HisRank == 0){
			 HisRank += 13;
		 }
		 if (myRank > HisRank) {
				return 1;
		 }else if (myRank < HisRank) {
				return -1;
		 }else if (this.getSuit() > card.getSuit()) {
				return 1;
		 }else if (this.getSuit() < card.getSuit()) {
				return -1;
		 }else {
				System.out.println("two cards are the same");
				return 0;
		}
	}
}
