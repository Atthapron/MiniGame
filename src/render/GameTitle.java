package render;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import input.InputUtility;

public class GameTitle extends JPanel{

	public GameTitle() {
		setPreferredSize(new Dimension(GameScreen.screenWidth,
				GameScreen.screenHeight));
		setBackground(Color.black);
		setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(0,0,0,0));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0	, 30, 40));
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

		// use new game image button
		JButton newGame_bt = new JButton(new ImageIcon(Resource.newGame_bt));
		newGame_bt.setContentAreaFilled(false);
		newGame_bt.setBorder(null);
		newGame_bt.setPressedIcon(new ImageIcon(Resource.newGameOp_bt));
		newGame_bt.setAlignmentX(RIGHT_ALIGNMENT);
		buttonPanel.add(newGame_bt);

		// use high score image button
		JButton highScore_bt = new JButton(new ImageIcon(Resource.highScore_bt));
		highScore_bt.setContentAreaFilled(false);
		highScore_bt.setBorder(null);
		highScore_bt.setPressedIcon(new ImageIcon(Resource.highScoreOp_bt));
		highScore_bt.setAlignmentX(RIGHT_ALIGNMENT);
		buttonPanel.add(highScore_bt);
		add(buttonPanel,BorderLayout.PAGE_END);
		
		
		newGame_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//fill code
				InputUtility.startGame = true;
			}
		});
		
		highScore_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//new HighScore();
			}
		});
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(Resource.titleScene, null, -100, 0);
	
	}
}
