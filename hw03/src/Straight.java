
public class Straight extends Hand {

	Straight(CardGamePlayer player, CardList cards){
		super(player, cards); 
	}
	
	boolean isValid() {
		if(list.isEmpty()){//not empty
			return false;
		}else if(list.size() != 5){//size correct
			return false;
		}else{//check rank
			if( list.getCard(4).rank - list.getCard(0).rank == 4 || list.getCard(4).rank - list.getCard(0).rank == 12){
				return true;
			}else{
				return false;
			}
		}
	}
	
	public Card getTopCard(){
		if( list.getCard(4).rank - list.getCard(0).rank == 4){
			return list.getCard(4);
		}else if(list.getCard(4).rank - list.getCard(0).rank == 12){
			if(list.getCard(1).rank == 1){
				return list.getCard(1);
			}else{
				return list.getCard(0);
			}
		}else{
			return null;
		}
	}
	
	String getType() {
		return "Straight";
	}

}
