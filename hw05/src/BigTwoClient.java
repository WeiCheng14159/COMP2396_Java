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
	private Deck deck;
	private ArrayList<CardGamePlayer> playerList;
	private ArrayList<Hand> handsOnTable;
	private int playerID;
	private String serverIP;
	private int serverPort;
	private Socket sock;
	private ObjectOutputStream oos;
	private int currentIdx;
	private BigTwoTable table;
	
	private String userName;
	
	
	public BigTwoClient(){
		
		//create a list of players
		this.playerList = new ArrayList<CardGamePlayer>();
		this.playerList.add(new CardGamePlayer());
		this.playerList.add(new CardGamePlayer());
		this.playerList.add(new CardGamePlayer());
		this.playerList.add(new CardGamePlayer());
		
		//create a big two table
		this.table  = new BigTwoTable(this);	
		
		this.userName = JOptionPane.showInputDialog("Please input your name:");
		this.makeConnection();
	}
	
	@Override
	public int getNumOfPlayers() {
		// TODO Auto-generated method stub
		return playerList.size();
	}

	@Override
	public Deck getDeck() {
		// TODO Auto-generated method stub
		return this.deck;
	}

	@Override
	public ArrayList<CardGamePlayer> getPlayerList() {
		// TODO Auto-generated method stub
		return playerList;
	}

	@Override
	public ArrayList<Hand> getHandsOnTable() {
		// TODO Auto-generated method stub
		return handsOnTable;
	}

	@Override
	public int getCurrentIdx() {
		// TODO Auto-generated method stub
		return currentIdx;
	}

	@Override
	public void start(Deck deck) {
		// TODO Auto-generated method stub
		
		//prompt the user to input the name
		
		this.numOfPlayers = 4;
		this.handsOnTable = new ArrayList<Hand>();
		deck = new BigTwoDeck();
		deck.initialize();
		this.deck = deck;
		
		// add card game players into the playerList and randomly distributes 13
		// cards for each player
		for (int i = 0; i < 4; i++) {
			CardGamePlayer player = new CardGamePlayer();
			for (int j = 0; j < 13; j++) {
				player.addCard(deck.getCard(i * 13 + j));
			}
			player.sortCardsInHand();
			this.playerList.add(player);
		}
		
		
		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).getCardsInHand().contains(new BigTwoCard(0, 2))) {
				this.currentIdx = i;
				break;
			}
		}
		
		this.table.setActivePlayer(this.playerID);
		this.table.setActiveSelection(this.playerID);
	}

	@Override
	public void makeMove(int playerID, int[] cardIdx) {
		// TODO Auto-generated method stub
		
		CardGameMessage c = new CardGameMessage(CardGameMessage.MOVE, -1, cardIdx);
		this.sendMessage(c);
		
	}

	@Override
	public void checkMove(int playerID, int[] cardIdx) {
		// TODO Auto-generated method stub
		//this.table.set
	}

	@Override
	public boolean isPlaying() {
		// TODO Auto-generated method stub
		//return true;
	}

	@Override
	public boolean endOfGame() {
		// TODO Auto-generated method stub
		//return false;
	}

	@Override
	public int getPlayerID() {
		// TODO Auto-generated method stub
		return this.playerID;
	}

	@Override
	public void setPlayerID(int playerID) {
		// TODO Auto-generated method stub
		this.playerID = playerID;
	}

	@Override
	public String getPlayerName() {
		// TODO Auto-generated method stub
		return this.playerList.get(this.playerID).getName();
	}

	@Override
	public void setPlayerName(String playerName) {
		// TODO Auto-generated method stub
		this.playerList.get(this.playerID).setName(playerName);
	}

	@Override
	public String getServerIP() {
		// TODO Auto-generated method stub
		return this.serverIP;
	}

	@Override
	public void setServerIP(String serverIP) {
		// TODO Auto-generated method stub
		this.serverIP = serverIP;
	}

	@Override
	public int getServerPort() {
		// TODO Auto-generated method stub
		return this.serverPort;
	}

	@Override
	public void setServerPort(int serverPort) {
		// TODO Auto-generated method stub
		this.serverPort = serverPort;
	}

	@Override
	public void makeConnection() {
		// TODO Auto-generated method stub
		try {
			sock = new Socket("127.0.0.1", 2396);
			this.oos = new ObjectOutputStream(sock.getOutputStream());
			Thread receiveData = new Thread(new ServerHandler());
			receiveData.start();//make a thread running for receiving data
			
			//initialization message
			this.oos.writeObject( new CardGameMessage(CardGameMessage.JOIN, -1,this.userName) );
			this.oos.writeObject( new CardGameMessage(CardGameMessage.READY, -1, null) );
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		//create a thread for receiving message 
	}
	@Override
	public void parseMessage(GameMessage message) {
		// TODO Auto-generated method stub
		switch(message.getType()){
		case CardGameMessage.PLAYER_LIST:
			// set player id of local user and update the name in the playerlist
			this.playerID = message.getPlayerID();
			String [] arr  = (String []) message.getData();
			//how do i change the player list ?
			for( int i = 0 ; i< arr.length ; i++){
				System.out.println("setting player name "+arr[i]);
				this.playerList.get(i).setName(arr[i]);
			}
			//update the lcoal player list with the server player list
			break;
		case CardGameMessage.JOIN:
			// marks the specified player as ready for a new game
			this.playerList.get(message.getPlayerID()).setName( (String) message.getData() );
			break;
		case CardGameMessage.FULL:
			this.table.println("server is full cannot join the game");
			break;
		case CardGameMessage.QUIT:
			//this.playerList()
			break;
		case CardGameMessage.READY:
			this.table.println(message.getPlayerID()+" is ready !");
			break;
		case CardGameMessage.START:
			this.start( (Deck) message.getData());
		default:
			this.table.println	("Wrong message type: " + message.getType());
			// invalid message
			break;
		}
	}

	@Override
	public void sendMessage(GameMessage message) {
		// TODO Auto-generated method stub
		
	}

	class ServerHandler implements Runnable{
		
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