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
		handsOnTable = new ArrayList<Hand>();
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
		Hand prevPlayerHand=null;
		Hand currentPlayerHand=null;
		boolean endOfGame = false;
		boolean nextPlayer = false;
		int howManyPeoplePass=0;
		//who has smallest three ? 
		Card smallThree = new BigTwoCard(0,2); 		
		for( int i = 0 ; i < playerList.size();i++){
			if(playerList.get(i).getCardsInHand().contains(smallThree)){
				currentIdx = i;
				break;
			}
		}
		
		while(!endOfGame){
			nextPlayer = false;
			System.out.println("people pass count"+howManyPeoplePass);
			
			for( int i = 0 ; i < 4 ; i++){
				System.out.println(playerList.get(i).getName());
				if( i == currentIdx ){
					playerList.get(i).getCardsInHand().print(true,true);
				}else{
					playerList.get(i).getCardsInHand().print(false,true);
				}
			}
			System.out.println("<table>");//print out player's cards
			if(firstPlay){
				System.out.println("[Empty]");
			}else{
				handsOnTable.get(handsOnTable.size()-1).print();
			}
			
			CardGamePlayer currentPlayer = playerList.get(currentIdx);
			
			while (!nextPlayer){
				CardList userWantToPlay = currentPlayer.play(prevPlayerHand);//prompt user for input
				if(userWantToPlay != null){//user play cards
					currentPlayerHand = new Hand(currentPlayer,userWantToPlay);
					if(currentPlayerHand.isValid()){//play hand is valid
						if(firstPlay){//first play
							if(userWantToPlay.contains(smallThree) ){
								firstPlay = false;
								nextPlayer = true;
								currentPlayer.removeCards(userWantToPlay);
								handsOnTable.add(currentPlayerHand);
								prevPlayerHand = currentPlayerHand;
							}else{
								System.out.println("you must play diamond three");
							}
						}else{//not first play, normal round
							//main loop
							
							if(howManyPeoplePass >= 3){//you can play any hand
								howManyPeoplePass=0;
								nextPlayer = true;
								currentPlayer.removeCards(userWantToPlay);
								handsOnTable.add(currentPlayerHand);
								prevPlayerHand = currentPlayerHand;
							}else{//you must beat someone
								if(currentPlayerHand.beats(prevPlayerHand)){//you beat it !
									howManyPeoplePass=0;
									nextPlayer = true;
									currentPlayer.removeCards(userWantToPlay);
									handsOnTable.add(currentPlayerHand);
									prevPlayerHand = currentPlayerHand;
								}else{//not big enough
									System.out.println("Invalid move, your hand is smaller than hands on the table !");
								}
							}
						}
						
					}else{
						System.out.println("Invalid Hand");
					}
				}else{//user play nothing
					if(firstPlay){//you must play the first hand
						System.out.println("cannot play nothing! ");
					}else{//you pass this round
						nextPlayer = true;
						howManyPeoplePass++;
					}
				}
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
	
	
}
