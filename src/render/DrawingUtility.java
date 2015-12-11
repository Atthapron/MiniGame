package render;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class DrawingUtility {
	public final static Font standardFont = new Font("Tahoma", Font.BOLD, 30);
	public static final Font smallFont = new Font("Tahoma", Font.PLAIN, 9);

	public static void drawStatusBar(Graphics2D g2d, int remainingEnemyB,
			int remainingEnemyD, int maxEnemyB, int maxEnemyD, int coin) {
		g2d.setColor(new Color(0, 0, 0, 100));
		g2d.fillRect(0, 0, GameScreen.screenWidth, 75);

		g2d.drawImage(Resource.iconEnemy, null, 100, 10);
		g2d.setColor(Color.white);
		g2d.setFont(smallFont);
		g2d.drawString(remainingEnemyB+"/"+maxEnemyB,100, 10);
		g2d.drawString(remainingEnemyB+"/"+maxEnemyB,164, 10);

		g2d.drawImage(Resource.iconShooter, null, 300, 10);
		g2d.setColor(Color.white);
		g2d.setFont(smallFont);
		g2d.drawString("hand gun : 5 coin",300, 10);
		g2d.drawString("shot gun : 15 coin",364, 10);
		g2d.drawString("rifle : 30 coin",428, 10);

		g2d.setColor(Color.white);
		g2d.setFont(standardFont);
		g2d.drawString("COIN : " + coin, 800, 53);
		
	}

}
