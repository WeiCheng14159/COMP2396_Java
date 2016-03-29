
public abstract class Hand extends CardList {
	
	private CardGamePlayer player;
	friend CardList cardListNotVerify;
	
	public Hand(){
		
	}
	
	public Hand( CardGamePlayer player, CardList cards){
		this.cardListNotVerify=cards;
		this.player = player;
	}
	
	public CardGamePlayer getPlayer(){
		return this.player;
	}
	
	public Card getTopCard(){
		
	}
	public boolean beats(Hand hand){
		
	}
	abstract boolean isValid();
	abstract String getType(); 
}
