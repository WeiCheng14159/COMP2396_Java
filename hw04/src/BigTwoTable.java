import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.*;

public class BigTwoTable implements CardGameTable {

	private	CardGame game;//what kind of game is being played
	private boolean[] selected;//which card is selected
	private int activePlayer;//the index of active player
	private int activeSelection;//index of active player
	private JFrame frame;//main window of the game 
	private JPanel BigTwoPanel;//show the cards of each player
	private JButton playButton;//just a wing component
	private JButton passButton;
	private JTextArea textArea;//show game status same as the console output 
	private Image[][] cardImages;//load the image of each pocker card
	private Image cardBackImage;//the back of the card
	private Image [] avatars;//the head icon 
	
	//public constructor
	public BigTwoTable(CardGame game)
	{
		//assign a game kind to the game table, even though the game type is a abstract class so i
		//cannot actually creata a real card game class @@ how can i pass a real object to this method ?
		this.game=game;	
		
		//create a frame here, is the main drawing panel
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//can i use this two method to control whether i can control the panel ? like disable the touch function ?
		frame.setSize(1000, 1000);
		frame.setVisible(true);
	
	}
	
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
		ArrayList<Integer> seleIndices = new ArrayList<Integer>();
		for( int i = 0 ; i < selected.length ; i++){
			if(selected[i] == true){
				seleIndices.add(i);
			}
		}
		int [] selectedArray = new int [seleIndices.size()];
		for( int i = 0 ; i < seleIndices.size() ; i++){
			selectedArray[i] = seleIndices.get(i);
		}
		return selectedArray;
	}

	@Override
	public void resetSelected() {
		// TODO Auto-generated method stub
		for (int i = 0 ; i < selected.length; i++){
			selected[i]=false;
		}
	}

	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		BigTwoPanel.repaint();
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
		
	}

	@Override
	public void disable() {//disable user interaction with gui -> disable touc screen
		// TODO Auto-generated method stub
		
	}
	
	class BigTwoPanel extends JPanel implements MouseListener{
		
		JPanel BigTwoPanel = new JPanel(); 
		
		//constructor function 
		BigTwoPanel(){
			
			//create object first
			playButton = new JButton("play game");
			passButton = new JButton ("pass the game");
			
			//create object for play button 
			playButton.addActionListener(new PlayButtonListener());
			passButton.addActionListener(new PassButtonListener());
			
			//add swing component to this panel, but how do i specify the position of the component ?
			frame.add(playButton);
			frame.add(passButton);
			frame.setSize(500,500);
			frame.setVisible(true);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
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
	}
	
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