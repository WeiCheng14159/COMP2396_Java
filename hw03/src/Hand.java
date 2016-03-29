
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
			BigTwoCard HisTopCard = new BigTwoCard(others[orderB].getTopCard().suit, others[orderB].getTopCard().rank);
			
			if( myTopCard.compareTo(HisTopCard) > 0){
				//System.out.println("haha I am biggerrrrr");
				return true;
			}else{
				//System.out.println("gg I am smalleeeer");
				return false;
			}
		}else{//type mismatch 
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
				break;
			}
		}
		if(valid != -1){
			System.out.println("card type code: "+valid);
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
