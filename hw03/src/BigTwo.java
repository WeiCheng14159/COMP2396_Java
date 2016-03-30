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
		Hand prevHand=null;
		Hand uncheckHand=null;
		boolean endOfGame = false;
		boolean nextPlayer = false;
		
		int roundCount=1;
		//who has smallest three ? 
		Card smallThree = new BigTwoCard(0,2); 		
		for( int i = 0 ; i < playerList.size();i++){
			if(playerList.get(i).getCardsInHand().contains(smallThree)){
				currentIdx = i;
				break;
			}
		}
		//
		
		while(!endOfGame){
			nextPlayer = false;
			System.out.println("round count"+roundCount);
			roundCount++;
			
			for( int i = 0 ; i < 4 ; i++){
				System.out.println(playerList.get(i).getName());
				if( i == currentIdx ){
					playerList.get(i).getCardsInHand().print(true,true);
				}else{
					playerList.get(i).getCardsInHand().print(false,true);
				}
			}
			
			CardGamePlayer currentPlayer = playerList.get(currentIdx);
			
			if( firstPlay){//first time play, player cannot pass, must play smallest three
				firstPlay = false;
				while (!nextPlayer){
					CardList userWantToPlay = currentPlayer.play(prevHand);//prompt user for input
					if(userWantToPlay != null){//user play cards
						uncheckHand = new Hand(currentPlayer,userWantToPlay);
						if( uncheckHand.isValid() ){//first play must contain small three card
							if(userWantToPlay.contains(smallThree) ){
								nextPlayer = true;
								//let user play 
								currentPlayer.removeCards(userWantToPlay);
								//add to hands on table
								handsOnTable.add(uncheckHand);
								prevHand = uncheckHand;
							}else{
								System.out.println("you must play small three");
							}
						}else{
							System.out.println("not valid hand");
						}
					}else{//user play nothing
						System.out.println("cannot play nothing! ");
					}
				}
			}else{//normal play 
				while (!nextPlayer){
					CardList userWantToPlay = currentPlayer.play(prevHand);//prompt user for input
					if(userWantToPlay != null){//user play cards
						uncheckHand = new Hand(currentPlayer,userWantToPlay);
						if( uncheckHand.isValid() ){
							if(uncheckHand.beats(prevHand)){
								nextPlayer = true;
								//let user play 
								currentPlayer.removeCards(userWantToPlay);
								//add to hands on table
								handsOnTable.add(uncheckHand);
								prevHand = uncheckHand;
							}
						}else{
							System.out.println("not valid hand");
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
			
		}
		
		System.out.println("Game ends");
		for ( CardGamePlayer p : playerList ){
			System.out.println(p.getName()+" has "+p.getNumOfCards()+" of cards in hand. ");
		}
	}
	
	
}
