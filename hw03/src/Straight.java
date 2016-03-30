
public class Straight extends Hand {
//hahahah
	Straight(CardGamePlayer player, CardList cards){
		super(player, cards); 
	}
	
	boolean isValid() {
		if(list.isEmpty()){//not empty
			return false;
		}else if(list.size() != 5){//size correct
			return false;
		}else{//check rank
			int [] rankArray = new int [5];
			for( int i = 0 ; i < 5 ; i++){
				if(list.getCard(i).getRank() == 0 || list.getCard(i).getRank() == 1){
					rankArray[i] += list.getCard(i).getRank();
				}
			}
			
			for(int i = 1 ; i < 5 ; i++){
				if(rankArray[i] - rankArray[i-1] != 1){
					return false;
				}
			}
			return true;
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
