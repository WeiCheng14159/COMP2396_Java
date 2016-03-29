import java.util.*;

public class BigTwo {
	int numOfPlayer;
	Deck deck;
	ArrayList <CardGamePlayer> playerList;
	ArrayList <Hand> handsOnTable;
	int currentIdx;
	
	public BigTwo(){
		
		numOfPlayer=4;
		playerList = new ArrayList<CardGamePlayer>();
		deck = new BigTwoDeck();
		deck.initialize();

		for ( int i = 0 ; i < 4 ; i ++){
			CardGamePlayer player = new CardGamePlayer();
			for( int j = 0 ; j < 13 ; j++){
				player.addCard(deck.getCard(i*13+j));
			}
			playerList.add(player);
		}
		
		//before everything begin make sure everything is right
		System.out.println("Num of player: "+numOfPlayer);
		deck.print();
		for( CardGamePlayer p : playerList){
			System.out.println("name: "+p.getName()+"score: "+p.getScore()+"num hand: "+p.getNumOfCards());
		}
		System.out.println("current id : "+currentIdx);
	}
	
	public void start(){
		boolean endOfGame = false;
		Hand currentHand = new Hand(); 
		while(endOfGame){
			
			currentHand = new Hand(playerList.get(currentIdx), playerList.get(currentIdx).play(currentHand));
			
			
			
			currentIdx++;
			if(playerList.get(0).getNumOfCards() == 0 || playerList.get(1).getNumOfCards() == 0 || playerList.get(2).getNumOfCards() == 0 || playerList.get(3).getNumOfCards() == 0 ){
				endOfGame = true;
			}
		}
		
		System.out.println("Game ends");
		for ( CardGamePlayer p : playerList ){
			System.out.println(p.getName()+" has "+p.getNumOfCards()+" of cards in hand. ");
		}
	}
}
