import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import entity.Field;
import render.GameScreen;
import render.GameTitle;
import render.PlayerStatus;
import render.RenderableHolder;


public class Main {
	public static void main(String[] args){
		
		RenderableHolder r = new RenderableHolder(); 
		PlayerStatus p = new PlayerStatus();
		Field f = new Field();
		GameScreen screenScene = new GameScreen();
		JFrame frame = new JFrame();
		
		frame.setLayout(new BorderLayout());
		frame.add(screenScene,BorderLayout.CENTER);
	
		frame.setVisible(true);
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
