package render;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameTitle extends JPanel {

	public GameTitle(){
		setPreferredSize(new Dimension(GameScreen.screenWidth,GameScreen.screenHeight));
	}
	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(Resource.titleScene, null, 0, 0);
	
	}

}
