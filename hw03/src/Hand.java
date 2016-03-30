
public class Hand extends CardList {
	
	private CardGamePlayer player;
	protected CardList list;
	
	public Hand( CardGamePlayer player, CardList cards){
		cards.sort();
		this.removeAllCards();
		for( int i = 0 ; i < cards.size() ; i++){
			this.addCard(cards.getCard(i));
		}
		this.list=cards;
		this.player=player;
	}
	
	public CardGamePlayer getPlayer(){
		return this.player;
	}
	
	public Card getTopCard(){
		return null;
	}
	
	public boolean beats(Hand hand){
		
		int cardA = 0;
		int cardB = 0;
		
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
		
		me[0] = new Flush(player, list);
		me[1] = new FullHouse(player, list);
		me[2] = new Pair(player, list);
		me[3] = new Quad(player, list);
		me[4] = new Single(player, list);
		me[5] = new Straight(player, list);
		me[6] = new StraightFlush(player, list);
		me[7] = new Triple(player, list);
		
		for(int i = 0 ; i < 8 ; i++){
			if(others[i].isValid()){
				cardA = i;
				break;
			}
		}
		for(int i = 0 ; i < 8 ; i++){
			if(me[i].isValid()){
				cardB = i;
				break;
			}
		}
		
		if(cardA == cardB){
			BigTwoCard myTopCard = new BigTwoCard(me[cardA].getTopCard().suit, me[cardA].getTopCard().rank);
			BigTwoCard HisTopCard = new BigTwoCard(others[cardB].getTopCard().suit, others[cardB].getTopCard().rank);
			
			if( myTopCard.compareTo(HisTopCard) > 0){
				System.out.println("haha I am biggerrrrr");
				return true;
			}else{
				System.out.println("gg I am smalleeeer");
				return false;
			}
		}else{//type mismatch
			System.out.println("type mismatch");
			return false;
		}	
	}
	
	boolean isValid(){
		Hand [] me = new Hand[8];
		int valid = -1;
		me[0] = new Flush(player, list);
		me[1] = new FullHouse(player, list);
		me[2] = new Pair(player, list);
		me[3] = new Quad(player, list);
		me[4] = new Single(player, list);
		me[5] = new Straight(player, list);
		me[6] = new StraightFlush(player, list);
		me[7] = new Triple(player, list);
		
		for(int i = 0 ; i < 8 ; i++){
			if(me[i].isValid()){
				valid = i;
				System.out.println(me[i].getType());
				break;
			}
		}
		if(valid != -1 ){
			return true;
		}else{
			
			return false;
		}
	}
	
	String getType(){
		System.out.println("err");
		return "err";
	}
}
