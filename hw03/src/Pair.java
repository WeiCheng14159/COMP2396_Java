
public class Pair extends Hand {
	
	Pair(CardGamePlayer player, CardList cards){
		super(player, cards); 
	}

	boolean isValid() {
		if(list.isEmpty()){//not empty
			return false;
		}else if(list.size() != 2){//size correct
			return false;
		}else{//check 
			if( list.getCard(0).rank == list.getCard(1).rank ){
				return true;
			}else{
				return false;
			}
		}
	}

	public Card getTopCard(){
		return list.getCard(1);
	}
	
	String getType() {
		return "Pair";
	}

}
