import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BigTwoClient implements CardGame, NetworkGame{

	private int numOfPlayers;
	private Deck deck;//card game
	private ArrayList<CardGamePlayer> playerList;//card game
	private ArrayList<Hand> handsOnTable;//card game
	private int playerID;//card game
	private String serverIP;//network game
	private int serverPort;//net work game
	private Socket sock;//network game
	private ObjectOutputStream oos;//network game
	private int currentIdx;//card game
	private BigTwoTable table;//card game
	
	/*declare by me :)*/
	private String userName;//used in game logic
	private boolean first = true;//used in game logic
	private Hand prevPlayerHand = null;//used in game logic
	private int howManyPeoplePass = 0;//used in game logic
	
	/**
	 * main method for starting a BigTwoCLient
	 * @param args
	 */
	public static void main(String[] args) {
		BigTwoClient c = new BigTwoClient();
	} 
	
	/**
	 * public constructor for BigTwoClient
	 */
	public BigTwoClient(){
		
		/*
		 * BigTwoClient() – a constructor for creating a Big Two client. 
		 * (i) create 4 players and add them to the list of players; 
		 * (ii) create a Big Two table which builds the GUI for the game and handles user actions; 
		 * (iii) make a connection to the game server by calling the makeConnection() method (from the NetworkGame interface).
		 * */
		
		//create a list of players
		this.playerList = new ArrayList<CardGamePlayer>();
		this.playerList.add(new CardGamePlayer());
		this.playerList.add(new CardGamePlayer());
		this.playerList.add(new CardGamePlayer());
		this.playerList.add(new CardGamePlayer());
		System.out.println("how many players: "+this.playerList.size());
		this.first = true;
		
		//create a big two table
		//this.table  = new BigTwoTable(this);//really important, bigtwoclient is actually a card game 	
		
		this.userName = JOptionPane.showInputDialog("Please input your name:");//set the user name
		this.makeConnection();//coolest part !!
	}
	
	/**
	 * a method returns total number of players
	 * return an integer or total number of players
	 */
	@Override
	public int getNumOfPlayers() {
		// TODO Auto-generated method stub
		return playerList.size();//when is this called, is it initialized ?
	}
	
	/**
	 * a method returns the deck used in the game
	 */

	@Override
	public Deck getDeck() {
		// TODO Auto-generated method stub
		return this.deck;
	}
	
	/**
	 * a method returns a list of players
	 */

	@Override
	public ArrayList<CardGamePlayer> getPlayerList() {
		// TODO Auto-generated method stub
		return playerList;
	}
	
	/**
	 * a method returns the latest hand player on the table
	 */

	@Override
	public ArrayList<Hand> getHandsOnTable() {
		// TODO Auto-generated method stub
		return handsOnTable;
	}
	
	/**
	 * a method returns the id of the current player
	 */

	@Override
	public int getCurrentIdx() {
		// TODO Auto-generated method stub
		return currentIdx;
	}
	
	/**
	 * a method to start the game
	 * @param Deck deck : a deck of cards which is going to be used in this game
	 */

	@Override
	public void start(Deck deck) {
		// TODO Auto-generated method stub
		
		/*
		 * a method for starting/restarting the game with a given shuffled deck of cards. You should 
		 * (i) remove all the cards from the players as well as from the table; 
		 * (ii) distribute the cards to the players; 
		 * (iii) identify the player who holds the 3 of Diamonds; 
		 * (iv) set the currentIdx of the BigTwoClient instance to the playerID (i.e., index) of the player who holds the 3 of Diamonds; 
		 * (v) set both the activePlayer and activeSelection of the BigTwoTable instance to the playerID (i.e., index) of the local player 
		 * (i.e., only shows the cards of the local player and the local player can only select cards from his/her own hand).
		 * */
		
		//prompt the user to input the name
		
		this.numOfPlayers = 4;    // is this really necessary ?
		this.handsOnTable = new ArrayList<Hand>(); //delete all the hands played on table
		this.deck = deck;//noted that this deck of cards is already shuffled
		
		// noted that four player objects are already created in as an array
		for (int i = 0; i < 4; i++) { //what if there are less than 4 players ?
			for (int j = 0; j < 13; j++) {
				this.playerList.get(i).addCard(this.deck.getCard(i * 13 + j));
			}
			this.playerList.get(i).sortCardsInHand();
		}
		
		//check who has the smallest three, and he should play first
		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).getCardsInHand().contains(new BigTwoCard(0, 2))) {
				this.currentIdx = i;
				break;
			}
		}
		
		this.table  = new BigTwoTable(this);
		
		this.table.setActivePlayer(this.getPlayerID());
		this.table.setActiveSelection(this.getPlayerID());
		this.table.repaint();
	}
	
	/**
	 * a method to make a move when the client receive a move message
	 * @param int playerID : id of the player who is playing this move
	 * @param int [] cardIdx : an array of indices specifying the indices played by the player
	 */

	@Override
	public void makeMove(int playerID, int[] cardIdx) {
		// TODO Auto-generated method stub
		
		/*
		 *  a method for making a move by a player with the specified playerID using the cards specified by the list of indices. 
		 *  This method should be called from the BigTwoTable when the local player presses either the “Play” or “Pass” button. 
		 *  You should create a CardGameMessage object of the type MOVE, with the playerID and data in this message being -1 and cardIdx, 
		 *  respectively, and send it to the game server using the sendMessage() method 
		 *  (from the NetworkGame interface).
		 * */
		
		this.sendMessage ( new CardGameMessage(CardGameMessage.MOVE, -1, cardIdx) );
		this.table.repaint();
	}
	/**
	 * a method used to check the move made by other players when client receive move message
	 * @param int playerID : id of the player who play this move
	 * @param int[] cardIdx : an array of indices specifying the indices played by the players
	 */

	@Override
	public void checkMove(int playerID, int[] cardIdx) {
		// TODO Auto-generated method stub
		/*
		 * a method for checking a move made by a player.
		 *  This method should be called from the parseMessage() method (from the NetworkGame interface) 
		 *  when a message of the type MOVE is received from the game server.
		 *  The playerID and data in this message give the playerID of the player who makes the move and 
		 *  a reference to a regular array of integers specifying the indices of the selected cards, respectively.
		 *  These are used as the arguments in calling the checkMove() method.
		 * */
		
		CardList userWantToPlay = new CardList();
		
		for (int i = 0; i < cardIdx.length; i++) {
			userWantToPlay.addCard(this.playerList.get(playerID).getCardsInHand().getCard(cardIdx[i]));
		} // what cards do user want to play ?
	
		CardGamePlayer currentPlayer = playerList.get(playerID);//define current user
		Card smallThree = new BigTwoCard(0, 2);//define small three card which should play first

		Hand h  = new Hand(currentPlayer, userWantToPlay);
		if (h.isValid()) {// hand is valid
			if (this.first) {// first hand in the game, player should play diamond three in the first round
				if (userWantToPlay.contains(smallThree)) {//user follows the rule
					this.first = false;
					currentPlayer.removeCards(userWantToPlay);
					handsOnTable.add(h);
					prevPlayerHand = h;
					this.currentIdx++;
					this.currentIdx = currentIdx % this.getNumOfPlayers();
					this.table.println("player "+playerID+" is playing : "+h.toString());
				} else {//not a legal move
					this.table.println("Player must play \u26663 in the first round.");
				}
			} else {// not first play, normal round
				if (howManyPeoplePass >= 3) {// you can play any hand, you have the biggest hand
					howManyPeoplePass = 0;
					currentIdx++;
					currentIdx = currentIdx % this.getNumOfPlayers();
					currentPlayer.removeCards(userWantToPlay);
					handsOnTable.add(h);
					prevPlayerHand = h;
					this.table.println("player "+playerID+" is playing : "+h.toString());
				} else {// your hand must beat someone
					if (h.beats(prevPlayerHand)) {// you beat it !
						howManyPeoplePass = 0;
						currentPlayer.removeCards(userWantToPlay);
						handsOnTable.add(h);
						prevPlayerHand = h;
						currentIdx++;
						currentIdx = currentIdx % this.getNumOfPlayers();
						this.table.println("player "+playerID+" is playing : "+h.toString());
					} else {// your hand cannot beat someone
						this.table.println("your card is valid but cannot beat the cards on the table");
					}
				}
			}
		} else {// this is not a valid hand in this game
			if(!this.first){
				if(h.size() == 0){
					//this.table.println("pass the game");
					currentIdx++;
					currentIdx = currentIdx % this.getNumOfPlayers();
					howManyPeoplePass++;
					this.table.println("player "+playerID+" pass the game");
				}else{
					this.table.println("Not a valid hand");
				}
			}else{
				this.table.println("you must play a valid hand with diamond three ");
			}
		}
		//end all the logic checking repaint the table
		this.table.repaint();
		
	}

	
	/**
	 * a method to check whether the game is still going on 
	 */
	@Override
	public boolean isPlaying() {
		// TODO Auto-generated method stub
		return !this.endOfGame();
		//return true;
	}
	
	/**
	 * a method checking whether the game ends or not
	 */

	@Override
	public boolean endOfGame() {
		// TODO Auto-generated method stub
		if (playerList.get(0).getNumOfCards() == 0 || playerList.get(1).getNumOfCards() == 0
				|| playerList.get(2).getNumOfCards() == 0 || playerList.get(3).getNumOfCards() == 0) {
			return true;// game ended
		} else {// game continues
			return false;
		}
	}
	
	/**
	 * a method to get the local player id
	 * @return the id od local player
	 */

	@Override
	public int getPlayerID() {
		// TODO Auto-generated method stub
		return this.playerID;//get player id of local user
	}
	
	/**
	 * a method for setting the id of local player
	 */

	@Override
	public void setPlayerID(int playerID) {
		// TODO Auto-generated method stub
		this.playerID = playerID;//set player id for local user
	}
	
	/**
	 * a method for getting the name of the local player
	 * @return the name of local player in String style
	 */

	@Override
	public String getPlayerName() {
		// TODO Auto-generated method stub
		return this.playerList.get(this.playerID).getName();//get the name of local user
	}
	
	/**
	 * a method for setting the name of local player
	 * @param String playerName : the name of player
	 */

	@Override
	public void setPlayerName(String playerName) {
		// TODO Auto-generated method stub
		this.playerList.get(this.playerID).setName(playerName);//set the name for local user, noted that the player id is the id of local user
	}
	
	/**
	 * a method to get the ip of the server
	 * @return server's ip in string
	 */

	@Override
	public String getServerIP() {
		// TODO Auto-generated method stub
		return this.serverIP;
	}
	
	/**
	 * a method setting server's ip
	 * @param ip in string 
	 */

	@Override
	public void setServerIP(String serverIP) {
		// TODO Auto-generated method stub
		this.serverIP = serverIP;
	}
	
	/**
	 * a method for getting the port of server
	 * @return serverPort in integer
	 */

	@Override
	public int getServerPort() {
		// TODO Auto-generated method stub
		return this.serverPort;
	}
	
	/**
	 * a method for setting the server port 
	 * @param server port in integer
	 */

	@Override
	public void setServerPort(int serverPort) {
		// TODO Auto-generated method stub
		this.serverPort = serverPort;
	}
	
	/**
	 * a method to make connection with the server
	 */

	@Override
	public void makeConnection() {
		// TODO Auto-generated method stub
		/*
		 *  a method for making a socket connection with the game server. Upon successful connection, you should 
		 *  (i) create an ObjectOutputStream for sending messages to the game server; 
		 *  (ii) create a thread for receiving messages from the game server; 
		 *  (iii) send a message of the type JOIN to the game server, with playerID being -1 and data being 
		 *  	a reference to a string representing the name of the local player;
		 *  (iv) send a message of the type READY to the game server, with playerID and data being -1 and null, respectively.
		 * */
		
		try {
			sock = new Socket("127.0.0.1", 2396);//create a new socket
			this.oos = new ObjectOutputStream(sock.getOutputStream());//create a new object output stream 
			Thread receiveData = new Thread(new ServerHandler());//create a new thread , for handling the incoming message
			receiveData.start();//make a thread running for receiving data, put the thread into ready mode
			
			//initialization message
			this.sendMessage( new CardGameMessage(CardGameMessage.JOIN, -1,this.userName) );// first we send a join message to the server
			this.sendMessage( new CardGameMessage(CardGameMessage.READY, -1, null) );//then we send a ready message to the server
				
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * a method for checking the message received from the server
	 * @param GameMessage : the message received from the server
	 */
	@Override
	public void parseMessage(GameMessage message) {
		// TODO Auto-generated method stub
		/*
		 * a method for parsing the messages received from the game server. 
		 * This method should be called from the thread responsible for receiving messages from the game server. 
		 * Based on the message type, different actions will be carried out
		 *  (please refer to the general behavior of the client described in the previous section).

		 * */
		
		//noted that this function is continously running in the thread, receiving the message and parsing the message
		switch(message.getType()){
		case CardGameMessage.PLAYER_LIST:
			// set player id of local user and update the name in the player list
			this.playerID = message.getPlayerID(); // got an assigned from the server
			String [] arr  = (String []) message.getData(); // the data package actually contain an array of user names
			
			for( int i = 0 ; i< arr.length ; i++){//is two array having the same order ?
				this.playerList.get(i).setName(arr[i]);
			}//update the local player list with the server player list
			break;
		case CardGameMessage.JOIN:
			// set the name and id for the new user
			this.playerList.get(message.getPlayerID()).setName( (String) message.getData() );
			break;
		case CardGameMessage.FULL:
			this.table.println("server is full cannot join the game");
			break;
		case CardGameMessage.QUIT:
			/*
			 * Upon receiving a message of the type QUIT from the server, 
			 * the client should remove a player from the game by setting his/her name to an empty string. 
			 * The playerID in this message specifies the playerID (i.e., index) of the player who leaves the game, 
			 * and data is a string representing the IP address and TCP port of this player (e.g., "/127.0.0.1:9394").
			 *  If a game is in progress, the client should stop the game and then send a message of
			 *   type READY, with playerID and data being -1 and null, respectively, to the server.
			 * */
			
			this.playerList.get(message.getPlayerID()).setName("");//set the the name of the quit player to empty string
			if(this.isPlaying()){
				//the game is still goint on 
				this.table.println("the game should be stop because someone is disconnected");
				this.sendMessage(new CardGameMessage(CardGameMessage.READY, -1 , null));
			}else{
				System.out.println("the game ends and someone is disconnected from the game, so it's ok ~~");
			}
			break;
		case CardGameMessage.READY:
			/*
			 * Upon receiving a message of the type READY from the server, 
			 * the client should display a message in the text area of the BigTwoTable that the specified player is ready.
			 *  The playerID in this message specifies the playerID (i.e., index) 
			 *  of the player who is ready, and data is null which can simply be ignored.
			 * */
			System.out.println(message.getPlayerID()+" is ready !");
			break;
		case CardGameMessage.START:
			/*
			 * Upon receiving a message of the type START from the server,
			 *  the client should start a new game with the given deck of cards (already shuffled). 
			 *  The playerID in this message is -1 which can simply be ignored, and data is a reference to a (shuffled) BigTwoDeck object.
			 *   (You should call the start() method (from the CardGame interface) to start a new game.
			 *    Note that you should NOT shuffle the deck again inside the start() method.)
			 * */
			//noted that the data package in this message contains the shuffle deck of cards packed as an object data
			this.start( (Deck) message.getData());
			this.table.println("all players ready game starts");
			break;
		case CardGameMessage.MOVE:
			if(this.isPlaying()){
				this.checkMove(message.getPlayerID(), (int [])message.getData());
			}else{
				this.table.println("\nGame ends");
				for (CardGamePlayer p : playerList) {
					//System.out.println(p.getName() + " has " + p.getNumOfCards() + " of cards in hand. ");
					this.table.println("player "+p.getName() + " has " + p.getNumOfCards() + " of cards in hand. ");
				}
			}
			//this.table.println(message.getPlayerID()+" is making a move ");
			this.table.repaint();
			break;
		case CardGameMessage.MSG:
			//System.out.println("receive a msg ...");
			this.table.printMsg("player "+(String)message.getData());
			this.table.repaint();
			break;
		default:
			this.table.println	("Wrong message type: " + message.getType());
			System.out.println("Wrong message type: " + message.getType());
			// invalid message
			break;
		}
	}
	
	/**
	 * a method for sending the message to the server
	 * @param GameMessage message : the message to be sent
	 */

	@Override
	public void sendMessage(GameMessage message) {
		// TODO Auto-generated method stub
		/*
		 *  a method for sending the specified message to the game server. 
		 *  This method should be called whenever the client wants to communicate 
		 *  with the game server or other clients.
		 * */
		
		try{
			this.oos.writeObject(message);
			this.oos.flush();
		}catch(Exception e){
			System.out.println("send message fail");
			e.printStackTrace();
		}
		
	}

	/**
	 * a thread created to handle the message received from the server
	 * @author chengwei
	 *
	 */
	class ServerHandler implements Runnable{
		
		/*
		 *  an inner class that implements the Runnable interface.
		 *   You should implement the run() method from the Runnable interface and create a thread with an instance of this class as its 
		 *   job in the makeConnection() method (from the NetworkGame interface) 
		 *   for receiving messages from the game server. Upon receiving a message, 
		 *   the parseMessage() method (from the NetworkGame interface) should be called to parse the messages accordingly.
		 * */
		
		private ObjectInputStream objReader;
		
		public ServerHandler(){
			try{
				this.objReader = new ObjectInputStream(sock.getInputStream());
			}catch (Exception ex){
				System.out.println("err in creating obj input stream");
				ex.printStackTrace();
			}
		}//constructor
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			CardGameMessage msg;
			try {
				// waits for messages from the client
				while ((msg = (CardGameMessage) this.objReader.readObject()) != null) {
					parseMessage(msg);
				} // close while
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("cannot read object from stream");
			}
				
		}
	}

}
