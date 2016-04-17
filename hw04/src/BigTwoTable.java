import java.util.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

public class BigTwoTable implements CardGameTable {

	private	CardGame game;//what kind of game is being played
	private boolean[][] selected;//which card is selected
	private int activePlayer;//the index of active player
	private int activeSelection;//index of active player
	private JFrame frame;//main window of the game 
	private JPanel BigTwoPanel;//show the cards of each player
	private JButton playButton;//just a wing component
	private JButton passButton;
	private JTextArea textArea;//show game status same as the console output 
	private Image[][] cardImages;//load the image of each poker card
	private Image cardBackImage;//the back of the card
	private Image [] avatars;//the head icon 
	public boolean clicked ;
	public boolean passed ;
	
	
	//public constructor
	public BigTwoTable(CardGame game)
	{
		//assign a game kind to the game table, even though the game type is a abstract class so i
		//cannot actually create a real card game class @@ how can i pass a real object to this method ?
		this.game=game;	
		this.cardImages = new Image[4][13];
		
		//active player is the current player who should play this round
		this.activePlayer=game.getCurrentIdx();		
		
		//store the head icon s
		avatars = new Image[4];
		avatars[0]= new ImageIcon("images/black.png").getImage();
		avatars[1] = new ImageIcon("images/green.png").getImage();
		avatars[2] = new ImageIcon("images/purple.png").getImage();
		avatars[3] = new ImageIcon("images/red.png").getImage();
		
		//store the card front image into the 2d array
		for(int i = 0 ; i < 4 ; i++){
			for( int j = 0 ; j < 13 ; j ++){
				//System.out.println("store card with num  "+j+" and suit "+i+" into the 2d array >> images/"+j+i+".gif");
				this.cardImages[i][j] = new ImageIcon("images/"+j+i+".gif").getImage();
			}
		}
		
		//store the card back image into private variable
		this.cardBackImage=new ImageIcon("images/04.gif").getImage();
		
		this.selected = new boolean [4][13];
		
		//create needed object first
		playButton = new JButton("play game");
		passButton = new JButton ("pass the game");
		//add listener object, also called registration process  
		playButton.addActionListener(new PlayButtonListener());
		passButton.addActionListener(new PassButtonListener());
		
		textArea = new JTextArea ("text area");
		textArea.setLineWrap(true);
		
		System.out.println("big two game information:"+this.game.getCurrentIdx()+"current idx "+this.game.getNumOfPlayers()+" num of players \n");
	}
	
	//repaint method
	@Override
	public void repaint() {
		// the whole panel repaint == create a new big two panel instance
		System.out.println("big 2 table repaint");

		//create a frame here, is the main drawing panel
		this.frame = new JFrame();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create a scroller for text area
		JScrollPane scroller = new JScrollPane(textArea);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel bottomButtons = new JPanel();
		bottomButtons.setBackground(Color.YELLOW);
		bottomButtons.add(playButton);
		bottomButtons.add(passButton);
		
		this.BigTwoPanel = new BigTwoPanel();
		
		//add swing component to this panel, but how do i specify the position of the component ?
		this.frame.add(BorderLayout.SOUTH,bottomButtons);
		this.frame.add(BorderLayout.EAST,scroller);
		this.frame.add(BorderLayout.CENTER,this.BigTwoPanel);
		
		//can i use this two method to control whether i can control the panel ? like disable the touch function ?
		this.frame.setSize(1000, 1000);
		this.frame.setVisible(true);			
	}
	
	//inner class
	class BigTwoPanel extends JPanel implements MouseListener{
		
		int cardsInHand = game.getPlayerList().get(activePlayer).getNumOfCards(); 
		
		public BigTwoPanel() {
			this.addMouseListener(this);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			//System.out.println("mouse coordiante: x: "+e.getXOnScreen()+" y: "+e.getYOnScreen());
			int x = (e.getXOnScreen()-200)/30; 
			int y = (e.getYOnScreen()-50)/150;
			
			//System.out.println(activePlayer);
			
			if( activePlayer == 0){
				if( x >= 0 && x<= cardsInHand && y>= 0 && y<= 1){
					selected[0][x]=true;
				}
			}else if(activePlayer == 1 ){
				if( x >= 0 && x<= cardsInHand && y>= 1 && y<= 2){
					selected[1][x]=true;
				}
			}else if(activePlayer == 2 ){
				if( x >= 0 && x<= cardsInHand && y>= 2 && y<= 3){
					selected[2][x]=true;
				}
			}else if(activePlayer == 3){
				if( x >= 0 && x<= cardsInHand && y>= 3 && y<= 4){
					selected[3][x]=true;
				}
			}else{
				System.out.println("err");
			}
			repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		public void paintComponent(Graphics g){
			
			for( int i = 0 ; i < 4 ; i++){
				for( int j = 0 ; j < game.getPlayerList().get(i).getNumOfCards() ; j ++){
					if(i == activePlayer){
						Card temp = game.getPlayerList().get(i).getCardsInHand().getCard(j);
						if(selected[i][j] != true){
							//System.out.println("pop up");
							g.drawImage(new ImageIcon("images/"+temp.rank+temp.suit+".gif").getImage(),  200+30*j, 50 + 150*i,this);
						}else{
							g.drawImage(new ImageIcon("images/"+temp.rank+temp.suit+".gif").getImage(),  200+30*j, 20 + 150*i,this);
						}	
					}else{
						g.drawImage(new ImageIcon("images/04.gif").getImage(),  200+30*j, 50 + 150*i,this);
					}
					
				}
			}
			//draw head
			g.drawImage( avatars[0], 0 , 50 , this);
			g.drawImage( avatars[1], 0 , 200 , this);
			g.drawImage( avatars[2], 0, 350 , this);
			g.drawImage( avatars[3], 0 , 500 , this);
		}
		
	}//inner class end
	
	//class methods
	@Override
	public void setActivePlayer(int activePlayer) {
		// TODO Auto-generated method stub
		this.activePlayer=activePlayer;
	}

	@Override
	public void setActiveSelection(int activeSelection) {
		// TODO Auto-generated method stub
		this.activeSelection=activeSelection;
	}

	@Override
	public int[] getSelected() {
		// TODO Auto-generated method stub
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for( int i = 0 ; i < game.getPlayerList().get(activePlayer).getNumOfCards() ; i++){
			if(selected[activePlayer][i] == true){
				temp.add(i);
				//System.out.println("card index added");
			}
		}
		
		int [] arr = new int [temp.size()];
		for( int j = 0 ; j < temp.size();j++){
			arr[j] = temp.get(j);
		}
		return arr;
	}

	@Override
	public void resetSelected() {
		// TODO Auto-generated method stub
		for (int i = 0 ; i < 4; i++){
			for( int j =0 ; j < 13; j++){
				selected[i][j] = false;
			}
		}
	}

	@Override
	public void print(String msg) {
		// TODO Auto-generated method stub
		textArea = new JTextArea(msg);
	}

	@Override
	public void println(String msg) {
		// TODO Auto-generated method stub
		textArea = new JTextArea(msg+"\n");
	}

	@Override
	public void clearTextArea() {
		// TODO Auto-generated method stub
		textArea = new JTextArea("");
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		clearTextArea();
	}

	@Override
	public void enable() {//to enable user interaction with gui 
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}

	@Override
	public void disable() {//disable user interaction with gui -> disable touc screen
		// TODO Auto-generated method stub
		frame.setVisible(false);
	}
	
	
	//some other inner class
	class PlayButtonListener implements ActionListener{
		
		@Override
		public void actionPerformed( ActionEvent event) {
			// TODO Auto-generated method stub
			playButton.setText("i am clicked");			
		}
	}
	
	class PassButtonListener implements ActionListener{
				
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			passButton.setText("i am clicked");
		}
		
	}
	
	class RestartMenuItemListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class QuitMenuItemListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
}
