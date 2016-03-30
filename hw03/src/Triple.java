
public class Triple extends Hand {
	
	Triple(CardGamePlayer player, CardList cards){
		super(player, cards); 
	}	
	
	boolean isValid() {
		if(list.isEmpty()){//not empty
			return false;
		}else if(list.size() != 3){//size correct
			return false;
		}else{
			if( list.getCard(0).getRank() == list.getCard(1).getRank() && list.getCard(1).getRank() == list.getCard(2).getRank() ){
				return true;
			}else{
				return false;
			}
		}
	}
	
	public Card getTopCard(){
		return list.getCard(2);
	}
	
	String getType() {
		
		return "Triple";
	}

}
