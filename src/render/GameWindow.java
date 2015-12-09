package render;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame {
	private JPanel currentScene;

	protected GameWindow(JPanel scene) {
		super("Zombie Shot");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		this.currentScene = scene;
		add(currentScene);
		pack();
		setVisible(true);
		currentScene.requestFocus();
	}

	protected void switchScene(JPanel scene) {
		remove(currentScene);
		this.currentScene = scene;
		add(currentScene);
		validate();
		pack();
		currentScene.requestFocus();
	}

	protected JPanel getCurrentScene() {
		return currentScene;
	}

}
