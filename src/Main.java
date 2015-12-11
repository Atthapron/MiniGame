import java.awt.BorderLayout;

import javax.swing.JFrame;

import render.GameScreen;
import render.GameTitle;


public class Main {
	public static void main(String[] args){
		GameScreen titleScene = new GameScreen();
		JFrame frame = new JFrame();
		
		frame.setLayout(new BorderLayout());
		frame.add(titleScene,BorderLayout.CENTER);
	
		frame.setVisible(true);
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
