import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.swing.internal.plaf.synth.resources.synth;

import entity.Field;
import render.GameManager;
import render.GameScreen;
import render.GameTitle;
import render.GameWindow;
import entity.PlayerStatus;
import input.InputUtility;
import render.RenderableHolder;


public class Main {
	public static void main(String[] args){
		
		RenderableHolder.getInstance();
		PlayerStatus p = new PlayerStatus();
		Field f = new Field();
		GameScreen screenScene = new GameScreen();
		JPanel p1 = new JPanel();
		p1.add(screenScene);
		GameTitle beginScene = new GameTitle();
		GameWindow gameWindow = new GameWindow(beginScene);
		GameManager gameManager  = new GameManager();
		
		
		Thread a = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					if(InputUtility.startGame){
						gameWindow.switchScene(p1);
						System.out.println(InputUtility.startGame+" e");	
						gameManager.startGameManager();
						gameManager.update();
					}
					p1.repaint();
				}
		
			}
		});
		a.start();
	
	}

}
