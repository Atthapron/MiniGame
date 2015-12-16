package render;

import input.InputUtility;

import java.awt.*;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JComponent;

public class GameScreen extends JComponent {
	public static int screenWidth = 1024;
	public static int screenHeight = 640;

	public GameScreen() {
		super();
		applyResize();
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		setDoubleBuffered(true);
		setVisible(true);
		Graphics2D g2d = null;
		
		
		// Accept mouse "click" event
		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == 1) {
					InputUtility.mouseLeftRelease();
				}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == 1) {
					InputUtility.mouseLeftDown();
					System.out.print("Pressed ");
					}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				InputUtility.mouseOnScreen = false;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				InputUtility.mouseOnScreen = true;
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				InputUtility.setShooterClicked();
				InputUtility.clickGo();
				InputUtility.CLICK = true;
			}
		});
		// Accept mouse "move" event
		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				if (InputUtility.mouseOnScreen) {
					InputUtility.mouseX = e.getX();
					InputUtility.mouseY = e.getY();
					System.out.print("x:" + InputUtility.mouseX);
					System.out.println("y:" + InputUtility.mouseY);
					
				}

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				if (InputUtility.mouseOnScreen) {
					InputUtility.mouseX = e.getX();
					InputUtility.mouseY = e.getY();
				}
			}
		});
		
	}

	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		ArrayList<IRenderable> entities = (ArrayList<IRenderable>) RenderableHolder
				.getInstance().getRenderableList();
		for (int index = 0; index < entities.size(); index++) {
			if (entities.get(index).isVisible())
				entities.get(index).draw(g2d);
			//System.out.println("draw " + index);
		}
	}

	protected void applyResize() {
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		validate();
	}

}
