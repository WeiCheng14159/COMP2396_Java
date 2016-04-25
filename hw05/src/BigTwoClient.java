import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

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
	
	public BigTwoClient(){
		//create a list of palyers
		this.playerList = new ArrayList<CardGamePlayer>();
		this.playerList.add(new CardGamePlayer());
		this.playerList.add(new CardGamePlayer());
		this.playerList.add(new CardGamePlayer());
		this.playerList.add(new CardGamePlayer());
		
		//create a big two table
		this.table  = new BigTwoTable(new BigTwo());
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
		
		numOfPlayers = 4;
		this.handsOnTable = new ArrayList<Hand>();
		deck = new BigTwoDeck();
		deck.initialize();
		
		// add card game players into the playerList and randomly distributes 13
		// cards for each player
		for (int i = 0; i < 4; i++) {
			CardGamePlayer player = new CardGamePlayer();
			for (int j = 0; j < 13; j++) {
				player.addCard(deck.getCard(i * 13 + j));
			}
			player.sortCardsInHand();
			playerList.add(player);
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
		
		CardGameMessage c = new CardGameMessage(CardGameMessage.MOVE, playerID, cardIdx);
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
		return this.table
	}

	@Override
	public boolean endOfGame() {
		// TODO Auto-generated method stub
		return false;
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
		this.oos = sock.getob();
		sock = new Socket(this.serverIP, this.serverPort);
		InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
		BufferedReader reader = new BufferedReader(streamReader);
		writer = new PrintWriter(sock.getOutputStream());
	}

	@Override
	public void parseMessage(GameMessage message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMessage(GameMessage message) {
		// TODO Auto-generated method stub
		
	}

	class ServerHandler implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			String message;
			try {
				while ((message = oos.readLine()) != null) {
					System.out.println("read " + message);
					incoming.append(message + "\n");
				} 
			} catch (Exception ex) {
					ex.printStackTrace();
			}
			
			
		}
		
	}
	
}
