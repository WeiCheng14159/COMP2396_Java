
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
		System.out.println("err");
		return null;
	}
	
	public boolean beats(Hand hand){//make sure that these two hands are all valid hands
		
		int defendorType = 0;//this hand object
		int attackerType = 0;//hand object
		
		Hand [] defendorHandList = new Hand[8];
		
		defendorHandList[0] = new Single(hand.player, hand.list);
		defendorHandList[1] = new Pair(hand.player, hand.list);
		defendorHandList[2] = new Triple(hand.player, hand.list);
		
		defendorHandList[3] = new Straight(hand.player, hand.list);
		defendorHandList[4] = new Flush(hand.player, hand.list);
		defendorHandList[5] = new FullHouse(hand.player, hand.list);
		defendorHandList[6] = new Quad(hand.player, hand.list);
		defendorHandList[7] = new StraightFlush(hand.player, hand.list);
		 
		for(int i = 0 ; i < 8 ; i++){
			if(defendorHandList[i].isValid()){
				defendorType = i;
				break;
			}
		}

		Hand [] attackerHandList = new Hand[8];
		
		attackerHandList[0] = new Single(player, list);
		attackerHandList[1] = new Pair(player, list);
		attackerHandList[2] = new Triple(player, list);
	
		attackerHandList[3] = new Straight(player, list);
		attackerHandList[4] = new Flush(player, list);
		attackerHandList[5] = new FullHouse(player, list);
		attackerHandList[6] = new Quad(player, list);
		attackerHandList[7] = new StraightFlush(player, list);
		
		
		for(int i = 0 ; i < 8 ; i++){
			if(attackerHandList[i].isValid()){
				attackerType = i;
				break;
			}
		}
		
		//System.out.println("defendor hand type :"+defendorType);
		//System.out.println("attacker hand type :"+attackerType);
		
		if(defendorType == attackerType){//same card type, compare topcard
			//System.out.println("same type comapre top card");
			BigTwoCard defendorTopCard = new BigTwoCard(defendorHandList[defendorType].getTopCard().getSuit(), defendorHandList[defendorType].getTopCard().getRank());
			BigTwoCard attackerTopCard = new BigTwoCard(attackerHandList[attackerType].getTopCard().getSuit(), attackerHandList[attackerType].getTopCard().getRank());
			//System.out.println(defendorTopCard.toString()+attackerTopCard.toString());
			//System.out.println(defendorTopCard.compareTo(attackerTopCard));
			if( defendorTopCard.compareTo(attackerTopCard) > 0){
				return false;//cannot beat validHandList
			}else{
				return true;//can beat validHandList
			}
		}else if( defendorType >= 3 && attackerType >=3){//five cards in a hand, but not the same type
			//System.out.println("five card comapre type");
			if(defendorType > attackerType){
				return false;
			}else{
				return true;
			}
		}
		else{//type mismatch
			return false;
		}	
	}
	
	boolean isValid(){
		Hand [] validHandList = new Hand[8];
		int valid = -1;
		validHandList[0] = new Single(player, list);
		validHandList[1] = new Pair(player, list);
		validHandList[2] = new Triple(player, list);
		validHandList[3] = new Straight(player, list);
		validHandList[4] = new Flush(player, list);
		validHandList[5] = new FullHouse(player, list);
		validHandList[6] = new Quad(player, list);
		validHandList[7] = new StraightFlush(player, list);
		
		for(int i = 0 ; i < 8 ; i++){
			if(validHandList[i].isValid()){
				valid = i;
				System.out.print("{"+validHandList[i].getType()+"}  ");
				print();
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
