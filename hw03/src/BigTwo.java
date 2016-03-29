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
		//initialization
		boolean firstPlay = true;
		handsOnTable = new ArrayList<Hand>();
		Hand prevHand=null;
		
		//who has smallest three ? 
		Card smallThree = new BigTwoCard(0,2); 		
		for( int i = 0 ; i < playerList.size();i++){
			if(playerList.get(i).getCardsInHand().contains(smallThree)){
				currentIdx = i;
				break;
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
			
			boolean nextPlayer = false;
			if( firstPlay){//first time play, player cannot pass, must play smallest three
				firstPlay = false;
				while (!nextPlayer){
					CardList userWantToPlay = playerList.get(currentIdx).play(null);//prompt user for input
					if(userWantToPlay != null){
						Hand waitToBeCheck = new Hand(playerList.get(currentIdx),userWantToPlay);
						if(userWantToPlay.contains(smallThree) && waitToBeCheck.isValid()){
							nextPlayer = true;
							//let user play 
							playerList.get(currentIdx).removeCards(userWantToPlay);
							//add to hands on table
							handsOnTable.add(waitToBeCheck);
							prevHand = waitToBeCheck;
						}else{
							System.out.println("not allow to play");
						}
					}else{
						System.out.println("cannot play nothing! ");
					}
					
				}
			}else{//normal play 
				while (!nextPlayer){
					CardList userWantToPlay = playerList.get(currentIdx).play(null);//prompt user for input
					if(userWantToPlay != null){
						Hand waitToBeCheck = new Hand(playerList.get(currentIdx),userWantToPlay);
						if(waitToBeCheck.isValid() && allowToPlay(prevHand, waitToBeCheck)){
							nextPlayer = true;
							//let user play 
							playerList.get(currentIdx).removeCards(userWantToPlay);
							
							//add to hands on table
							handsOnTable.add(waitToBeCheck);
							prevHand = waitToBeCheck;
						}else{
							System.out.println("not allow to play");
						}
					}else{//user pass
						nextPlayer = true;
					}
				}
			}
			
			if(playerList.get(0).getNumOfCards() == 0 || playerList.get(1).getNumOfCards() == 0 || playerList.get(2).getNumOfCards() == 0 || playerList.get(3).getNumOfCards() == 0 ){
				endOfGame = true;
			}else{
				currentIdx++;
				currentIdx = currentIdx % 4;
			}
			for(Hand temp : handsOnTable){
				temp.print();
			}
		}
		
		System.out.println("Game ends");
		for ( CardGamePlayer p : playerList ){
			System.out.println(p.getName()+" has "+p.getNumOfCards()+" of cards in hand. ");
		}
	}
	
	boolean allowToPlay(Hand handOnTable, Hand WhatIPlay){
		if(handOnTable.beats(WhatIPlay)){
			return false;
		}else{
			return true;
		}
	}
	
	
}
