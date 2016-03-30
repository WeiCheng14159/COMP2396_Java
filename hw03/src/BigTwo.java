import java.util.*;

/**
 * This class represent a BigTwo card game
 * @author chengwei
 *
 */
public class BigTwo {
	
	private int numOfPlayer;
	private Deck deck;
	private ArrayList <CardGamePlayer> playerList;
	private ArrayList <Hand> handsOnTable;
	private int currentIdx;
	
	/**
	 * Create and return an instance of BigTwo game
	 */
	public BigTwo(){
		
		//initializing variables, there will be 4 players and 52 cards in a BigTwo game
		numOfPlayer=4;
		playerList = new ArrayList<CardGamePlayer>();
		handsOnTable = new ArrayList<Hand>();
		deck = new BigTwoDeck();
		deck.initialize();

		//add card game players into the playerList and randomly distributes 13 cards for each player
		for ( int i = 0 ; i < 4 ; i ++){
			CardGamePlayer player = new CardGamePlayer();
			for( int j = 0 ; j < 13 ; j++){
				player.addCard(deck.getCard(i*13+j));
			}
			player.sortCardsInHand();
			playerList.add(player);
		}
		
		//before everything begin make sure everything is right
		/*For debug use**************************************************/
		System.out.println("Num of player: "+numOfPlayer);
		for( CardGamePlayer p : playerList){
			System.out.println("name: "+p.getName()+"score: "+p.getScore()+"num hand: "+p.getNumOfCards()+" list: ");
			p.getCardsInHand().print();
		}
		System.out.println("current id : "+currentIdx);
		/*For debug use**************************************************/
	}
	
	/**
	 * start a BigTwo card game
	 */
	public void start(){
		
		//initialization variables
		boolean firstPlay = true;
		Hand prevPlayerHand=null;
		Hand currentPlayerHand=null;
		boolean endOfGame = false;
		boolean nextPlayer = false;
		int howManyPeoplePass=0;
		
		//searching who has diamond three, player with diamond three should play the first hand
		Card smallThree = new BigTwoCard(0,2); 		
		for( int i = 0 ; i < playerList.size();i++){
			if(playerList.get(i).getCardsInHand().contains(smallThree)){
				currentIdx = i;
				break;
			}
		}
		
		//game start
		while(!endOfGame){
			nextPlayer = false;
			
			System.out.println();
			for( int i = 0 ; i < 4 ; i++){
				System.out.println(playerList.get(i).getName());
				
				if( i == currentIdx ){
					System.out.print(">>>");
					playerList.get(i).getCardsInHand().print(true,true);
				}else{
					System.out.print("   ");
					playerList.get(i).getCardsInHand().print(false,true);
				}
			}
			System.out.println("<table>");//print out player's cards
			if(firstPlay){
				System.out.println("   [Empty]");
			}else{//print out the latest hand on table
				System.out.print("< "+handsOnTable.get(handsOnTable.size()-1).getPlayer().getName()+" > ");
				prevPlayerHand.isValid();
			}
			
			CardGamePlayer currentPlayer = playerList.get(currentIdx);
			
			while (!nextPlayer){
				CardList userWantToPlay = currentPlayer.play(prevPlayerHand);//prompt player to player a hand
				if(userWantToPlay != null){//user play hands
					currentPlayerHand = new Hand(currentPlayer,userWantToPlay);
					if(currentPlayerHand.isValid()){//hand is valid
						if(firstPlay){//first hand in the game, player should play diamond three
							if(userWantToPlay.contains(smallThree) ){
								firstPlay = false;
								nextPlayer = true;
								currentPlayer.removeCards(userWantToPlay);
								handsOnTable.add(currentPlayerHand);
								prevPlayerHand = currentPlayerHand;
							}else{
								System.out.println("Not a legal move!!!");
								System.out.println("Player must play \u26663 in the first round.");
							}
						}else{//not first play, normal round

							if(howManyPeoplePass >= 3){//you can play any hand, you have the largest hand
								howManyPeoplePass=0;
								nextPlayer = true;
								currentPlayer.removeCards(userWantToPlay);
								handsOnTable.add(currentPlayerHand);
								prevPlayerHand = currentPlayerHand;
							}else{//your hand must beat someone
								if(currentPlayerHand.beats(prevPlayerHand)){//you beat it !
									howManyPeoplePass=0;
									nextPlayer = true;
									currentPlayer.removeCards(userWantToPlay);
									handsOnTable.add(currentPlayerHand);
									prevPlayerHand = currentPlayerHand;
								}else{//your hand cannot beat someone
									System.out.println("Not a legal move!!!");
								}
							}
						}
						
					}else{//this is not a valid hand in this game
						System.out.println("Not a legal move!!!");
					}
				}else{//user play a "nothing" hand
					if(firstPlay){//you must play the first hand in the first round
						System.out.println("Not a legal move!!!");
					}else{//you pass this round
						System.out.println("{pass}");
						nextPlayer = true;
						howManyPeoplePass++;
					}
				}
			}
			
			//determining whether the game is ended
			if(playerList.get(0).getNumOfCards() == 0 || playerList.get(1).getNumOfCards() == 0 || playerList.get(2).getNumOfCards() == 0 || playerList.get(3).getNumOfCards() == 0 ){
				endOfGame = true;//game ended
			}else{//game continues
				currentIdx++;
				currentIdx = currentIdx % 4;
			}
		}
		
		//game ends, and show the game statistics 
		System.out.println("\nGame ends");
		for ( CardGamePlayer p : playerList ){
			System.out.println(p.getName()+" has "+p.getNumOfCards()+" of cards in hand. ");
		}
	}
}
