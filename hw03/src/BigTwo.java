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
			player.sortCardsInHand();
			playerList.add(player);
		}
		
		//before everything begin make sure everything is right
		System.out.println("Num of player: "+numOfPlayer);
		for( CardGamePlayer p : playerList){
			System.out.println("name: "+p.getName()+"score: "+p.getScore()+"num hand: "+p.getNumOfCards()+" list: ");
			p.getCardsInHand().print();
		}
		System.out.println("current id : "+currentIdx);
	}
	
	public void start(){
		//who has smallest three ? 
		Card smallThree = new BigTwoCard(0,2); 
		boolean firstPlay = true;
		for( int i = 0 ; i < playerList.size();i++){
			if(playerList.get(i).getCardsInHand().contains(smallThree)){
				currentIdx = i;
			}else{
				currentIdx = 0;
			}
		}
		//
		
		boolean endOfGame = false;
		while(!endOfGame){
			for( int i = 0 ; i < 4 ; i++){
				System.out.println(playerList.get(i).getName());
				if( i == currentIdx ){
					playerList.get(i).getCardsInHand().print(true,true);
				}else{
					playerList.get(i).getCardsInHand().print(false,true);
				}
			}
			
			
			
			if( playerList.get(currentIdx).play(currentHand) == null){
				
			}
			
			
			
			
			if(playerList.get(0).getNumOfCards() == 0 || playerList.get(1).getNumOfCards() == 0 || playerList.get(2).getNumOfCards() == 0 || playerList.get(3).getNumOfCards() == 0 ){
				endOfGame = true;
			}else{
				currentIdx++;
				currentIdx = currentIdx % 4;
			}
		}
		
		System.out.println("Game ends");
		for ( CardGamePlayer p : playerList ){
			System.out.println(p.getName()+" has "+p.getNumOfCards()+" of cards in hand. ");
		}
	}
	boolean allowToPlay( Hand handOnTable, Hand WhatIPlay){
		if(handOnTable.beats(WhatIPlay)){
			return false;
		}else{
			return true;
		}
	}
}
