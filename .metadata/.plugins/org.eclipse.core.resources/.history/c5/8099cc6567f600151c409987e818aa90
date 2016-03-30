
public class Quad extends Hand {
	
	Quad(CardGamePlayer player, CardList cards){
		super(player, cards); 
	}

	boolean isValid() {
		if(list.isEmpty()){//not empty
			return false;
		}else if(list.size() != 5){//size correct
			return false;
		}else{//check 
			if( (list.getCard(0).getRank() == list.getCard(1).getRank() && list.getCard(1).getRank() == list.getCard(2).getRank() && list.getCard(2).getRank() == list.getCard(3).getRank()
					) || ( list.getCard(1).getRank() == list.getCard(2).getRank() && list.getCard(2).getRank() == list.getCard(3).getRank() && list.getCard(3).getRank() == list.getCard(4).getRank()) ){
				return true;
			}else{
				return false;
			}
		}
	}

	public Card getTopCard(){
		if( list.getCard(0).getRank() == list.getCard(1).getRank() && list.getCard(1).getRank() == list.getCard(2).getRank() && list.getCard(2).getRank() == list.getCard(3).getRank()){
			return list.getCard(3);
		}else if(list.getCard(1).getRank() == list.getCard(2).getRank() && list.getCard(2).getRank() == list.getCard(3).getRank() && list.getCard(3).getRank() == list.getCard(4).getRank() ){
			return list.getCard(4);
		}
		else{
			return null;
		}
	}
	
	String getType() {
		return "Quad";
	}

}
