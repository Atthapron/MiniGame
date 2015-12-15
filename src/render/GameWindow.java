package render;

import javax.swing.JFrame;
import javax.swing.JPanel;

import input.InputUtility;

public class GameWindow extends JFrame {
	private JPanel currentScene;
	
	public GameWindow(JPanel scene) {
		super("Zombie Shot");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		this.currentScene = scene;
		add(currentScene);
		pack();
		setVisible(true);
		currentScene.requestFocus();
	}

	public void switchScene(JPanel scene) {
		remove(currentScene);
		this.currentScene = scene;
		add(currentScene);
		validate();
		pack();
		currentScene.requestFocus();
		//InputUtility.updateStartGame();
		
	}

	public JPanel getCurrentScene() {
		return currentScene;
	}
	

}
