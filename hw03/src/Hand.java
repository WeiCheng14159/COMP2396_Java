
public class Hand extends CardList {
	public Hand( CardGamePlayer player, CardList cards){
		
	}
	private CardGamePlayer player;
	public CardGamePlayer getPlayer(){
		
	}
	public Card getTopCard(){
		
	}
	public boolean beats(Hand hand){
		
	}
	abstract boolean isValid();
	abstract String getType(); 
}
