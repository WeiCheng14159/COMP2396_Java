
public class Single extends Hand {

	Single(CardGamePlayer player, CardList cards){
		super(player, cards); 
	}

	boolean isValid() {
		if(list.size() != 1){
			return false;
		}else{
			return true;
		}
	}
	
	public Card getTopCard(){
		return list.getCard(0);
	}

	String getType() {
		return "Single";
	}

}
