import javax.swing.*;
import java.awt.*;

public class MydrawPanel extends JPanel {
	public void paintComponent (Graphics g){
		//g.setColor(Color.ORANGE);
		//g.fillOval(100, 100, 100, 200);
		Image img = new ImageIcon ("Apple.jpg").getImage();
		g.drawImage(img,0,0,this);
	}
}
