import javax.swing.*;
import java.awt.*;

public class MydrawPanel extends JPanel {
	
	public void paintComponent (Graphics g){
		//g.setColor(Color.green);
		//g.fillRect(0, 0, 300, 600);
		
		Image img = new ImageIcon ("a.jpg").getImage();
		g.drawImage(img,0,0,this);
	}
}