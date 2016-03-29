
public class FullHouse extends Hand {

	FullHouse(CardGamePlayer player, CardList cards){
		super(player, cards); 
	}
	
	boolean isValid() {
		if(list.isEmpty()){//not empty
			return false;
		}else if(list.size() != 5){//size correct
			return false;
		}else{//check 
			if( (list.getCard(0).rank == list.getCard(1).rank && list.getCard(1).rank == list.getCard(2).rank && list.getCard(3).rank == list.getCard(4).rank
					) || ( list.getCard(0).rank == list.getCard(1).rank && list.getCard(2).rank == list.getCard(3).rank && list.getCard(3).rank == list.getCard(4).rank) ){
				return true;
			}else{
				return false;
			}
		}
	}
	
	public Card getTopCard(){
		if( list.getCard(0).rank == list.getCard(1).rank && list.getCard(1).rank == list.getCard(2).rank && list.getCard(3).rank == list.getCard(4).rank ){
			return list.getCard(2);//three cards with same rank at front
		}else if(list.getCard(0).rank == list.getCard(1).rank && list.getCard(2).rank == list.getCard(3).rank && list.getCard(3).rank == list.getCard(4).rank)
			return list.getCard(4);//three cards with same rank at back
		else{
			return null;
		}
	}
	
	String getType() {	
		return "FullHouse";
	}

}
