
public class Flush extends Hand {
	
	Flush(CardGamePlayer player, CardList cards){
		super(player, cards); 
	}
	
	boolean isValid() {
		if(list.isEmpty()){//not empty
			return false;
		}else if(list.size() != 5){//size correct
			return false;
		}else{//check suit
			for(int i = 0 ; i < 5 ; i++){
				if(list.getCard(0).getSuit() != list.getCard(i).getSuit()){
					return false;
				}
			}
			return true;
		}
	}

	public Card getTopCard(){
		return list.getCard(4);
	}
	
	String getType() {
		return "Flush";
	}

}
