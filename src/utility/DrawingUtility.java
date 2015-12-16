package utility;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import entity.Field;
import entity.PlayerStatus;
import entity.Shooter;
import render.GameScreen;
import render.Resource;

public class DrawingUtility {
	protected static final Font standardFont = new Font("Tahoma", Font.BOLD, 30);
	protected static final Font smallFont = new Font("Tahoma", Font.PLAIN, 9);
	protected static final AlphaComposite translucent = AlphaComposite
			.getInstance(AlphaComposite.SRC_OVER, 0.7f);
	protected static final AlphaComposite opaque = AlphaComposite.getInstance(
			AlphaComposite.SRC_OVER, 1);
	
	
	
	public static void drawStatusBar(Graphics2D g2d, int remainingEnemyB,
			int remainingEnemyD, int maxEnemyB, int maxEnemyD, int coin,
			boolean isPointOverHandGun, boolean isPointOverShotGun,
			boolean isPointOverRifle, boolean isPointOverStart) {
		// black line on top
		g2d.setColor(new Color(0, 0, 0, 70));
		g2d.fillRect(0, 0, GameScreen.screenWidth, 75);

		// set of enemy status
		g2d.drawImage(Resource.iconEnemy, null, 50, 10);
		g2d.setColor(Color.white);
		g2d.setFont(smallFont);
		g2d.drawString(remainingEnemyB + "/" + maxEnemyB, 55, 10);
		g2d.drawString(remainingEnemyB + "/" + maxEnemyB, 119, 10);
		
		// set of shooter icon
		g2d.drawImage(Resource.iconShooter, null, 228, 10);
		g2d.setColor(Color.white);
		g2d.setFont(smallFont);
		g2d.drawString("Hand Gun : 5", 233, 10);
		g2d.drawString("Shot Gun : 15", 297, 10);
		g2d.drawString("Rifle : 30", 361, 10);
		
		
		// start zombie button
		g2d.drawImage(Resource.start_bt, null, 480, 10);
		g2d.setColor(Color.white.darker());
		g2d.setFont(smallFont);
		g2d.drawString("Zombies Run!", 485, 8);

		// status of current coin
		g2d.setColor(Color.white);
		g2d.setFont(standardFont);
		g2d.drawString("COIN : " + coin, 800, 53);

		// if point over each shooter icon ,it will fade.
		if (isPointOverHandGun) {
			g2d.setComposite(translucent);
			g2d.fillRect(PlayerStatus.xHandGunIcon, PlayerStatus.yHandGunIcon,
					64,64);
			g2d.setComposite(opaque);
		}

		if (isPointOverShotGun) {
			g2d.setComposite(translucent);
			g2d.fillRect(PlayerStatus.xShotGunIcon, PlayerStatus.yShotGunIcon,
					64,64);
			g2d.setComposite(opaque);
		}

		 if (isPointOverRifle) {
			g2d.setComposite(translucent);
			g2d.fillRect(PlayerStatus.xRifleIcon, PlayerStatus.yRifleIcon,
					64, 64);
			g2d.setComposite(opaque);
		}  if (isPointOverStart) {
			g2d.setComposite(translucent);
			g2d.fillRect(PlayerStatus.xStratIcon, PlayerStatus.yStartIcon,
					64, 64);
			g2d.setComposite(opaque);
		}

	}

	public static void drawField(Field field, Graphics2D g2d,
			boolean isPointOver) {
		for (int x = 0; x < field.getField()[0].length; x++) {
			for (int y = 0; y < field.getField().length; y++) {
				int terrain = field.getTerrain(x, y);
				int temp = terrain;
				if (terrain < 0 || terrain == 20)
					terrain = 0;
				g2d.drawImage(
						Resource.tile.getSubimage(terrain * 64, 0, 64, 64),
						null, x * 64, y * 64);
				terrain = temp;
			}
		}
	}

	public static void drawBuilding(Field field, Graphics2D g2d) {
		for (int x = 0; x < field.getField()[0].length; x++) {
			for (int y = 0; y < field.getField().length; y++) {
				int terrain = field.getTerrain(x, y);
				if (terrain == -1)
					g2d.drawImage(Resource.tree, null, x * 64, y * 64);
				else if (terrain == -2)
					g2d.drawImage(Resource.home, null, x * 64, y * 64);
			}
		}

	}
}