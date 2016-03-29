
public class Hand extends CardList {
	
	private CardGamePlayer player;
	protected CardList list;
	
	public Hand( CardGamePlayer player, CardList cards){
		cards.sort();
		this.list=cards;
		this.player = player;
	}
	
	public CardGamePlayer getPlayer(){
		return this.player;
	}
	
	public Card getTopCard(){
		return null;
	}
	
	public boolean beats(Hand hand){
		
		int orderA = 0;
		int orderB = 0;
		
		Hand [] others = new Hand[8];
		
		others[0] = new Flush(hand.player, hand.list);
		others[1] = new FullHouse(hand.player, hand.list);
		others[2] = new Pair(hand.player, hand.list);
		others[3] = new Quad(hand.player, hand.list);
		others[4] = new Single(hand.player, hand.list);
		others[5] = new Straight(hand.player, hand.list);
		others[6] = new StraightFlush(hand.player, hand.list);
		others[7] = new Triple(hand.player, hand.list);
		
		Hand [] me = new Hand[8];
		
		me[0] = new Flush(hand.player, hand.list);
		me[1] = new FullHouse(hand.player, hand.list);
		me[2] = new Pair(hand.player, hand.list);
		me[3] = new Quad(hand.player, hand.list);
		me[4] = new Single(hand.player, hand.list);
		me[5] = new Straight(hand.player, hand.list);
		me[6] = new StraightFlush(hand.player, hand.list);
		me[7] = new Triple(hand.player, hand.list);
		
		for(int i = 0 ; i < 8 ; i++){
			if(others[i].isValid()){
				orderA = i;
				break;
			}
		}
		for(int i = 0 ; i < 8 ; i++){
			if(me[i].isValid()){
				orderB = i;
				break;
			}
		}
		
		if(orderA == orderB){
			BigTwoCard myTopCard = new BigTwoCard(me[orderA].getTopCard().suit, me[orderA].getTopCard().rank);
			BigTwoCard HisTopCard = new BigTwoCard(others[orderA].getTopCard().suit, others[orderA].getTopCard().rank);
			if(myTopCard.compareTo(HisTopCard) > 0){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}	
	}
	
	boolean isValid(){
		System.out.println("err");
		return false;
	}
	
	String getType(){
		System.out.println("err");
		return "err";
	}
}
