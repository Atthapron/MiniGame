package entity;

import java.awt.Graphics2D;

import render.IRenderable;
import render.RenderableHolder;
import utility.DrawingUtility;

public class PlayerStatus implements IRenderable {
	private boolean isDestroyed=false;
	private int remainingEnemyB = 0;
	private int remainingEnemyD = 0;
	private int maxEnemyB = 0;
	private int maxEnemyD = 0;
	private int coin = 0;
	private boolean isPointOverHandGun = false;
	private boolean isPointOverShotGun = false;
	private boolean isPointOverRifle = false;
	private boolean isPointOverStart = false;

	public static final int xHandGunIcon = 228;
	public static final int yHandGunIcon = 10;
	public static final int xShotGunIcon = 293;
	public static final int yShotGunIcon = 10;
	public static final int xRifleIcon = 358;
	public static final int yRifleIcon = 10;
	public static final int xStratIcon = 480;
	public static final int yStartIcon = 10;
	
	public PlayerStatus() {
		super();
		RenderableHolder.getInstance().add(this);
	}

	public boolean isPointOverHandGun() {
		return isPointOverHandGun;
	}

	public void setPointOverHandGun(boolean isPointOverHandGun) {
		this.isPointOverHandGun = isPointOverHandGun;
	}

	public boolean isPointOverShotGun() {
		return isPointOverShotGun;
	}

	public void setPointOverShotGun(boolean isPointOverShotGun) {
		this.isPointOverShotGun = isPointOverShotGun;
	}

	public boolean isPointOverRifle() {
		return isPointOverRifle;
	}

	public void setPointOverRifle(boolean isPointOverRifle) {
		this.isPointOverRifle = isPointOverRifle;
	}

	public boolean isPointOverStart() {
		return isPointOverStart;
	}

	public void setPointOverStart(boolean isPointOverStart) {
		this.isPointOverStart = isPointOverStart;
	}

	public int getRemainingEnemyB() {
		return remainingEnemyB;
	}

	public void setRemainingEnemyB(int remainingEnemyB) {
		this.remainingEnemyB = remainingEnemyB;
	}

	public int getRemainingEnemyD() {
		return remainingEnemyD;
	}

	public void setRemainingEnemyD(int remainingEnemyD) {
		this.remainingEnemyD = remainingEnemyD;
	}

	public int getMaxEnemyB() {
		return maxEnemyB;
	}

	public void setMaxEnemyB(int maxEnemyB) {
		this.maxEnemyB = maxEnemyB;
	}

	public int getMaxEnemyD() {
		return maxEnemyD;
	}

	public void setMaxEnemyD(int maxEnemyD) {
		this.maxEnemyD = maxEnemyD;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public void increaseCoin(int coin) {
		this.coin += coin;
	}

	public void decreaseCoin(int coin) {
		this.coin -= coin;
		if (this.coin < 0)
			this.coin = 0;
	}

	public boolean isDisplayingArea(int x, int y) {
		return y < 76;
	}

	public boolean isPointOverHandGun(int x, int y) {
		isPointOverHandGun = x >= xHandGunIcon && x < xShotGunIcon
				&& y >= yHandGunIcon && y <= 74;
		return isPointOverHandGun;
	}

	public boolean isPointOverShotGun(int x, int y) {
		isPointOverShotGun = x >= xShotGunIcon && x < xRifleIcon
				&& y >= yShotGunIcon && y <= 74;
		return isPointOverShotGun;
	}

	public boolean isPointOverRifle(int x, int y) {
		isPointOverRifle = x >= xRifleIcon && x <= xRifleIcon + 64
				&& y >= yRifleIcon && y <= 74;
		return isPointOverRifle;
	}
	public boolean isPointOverStart(int x, int y) {
		isPointOverStart = x>=xStratIcon && x<=xStratIcon+64&& y>=xStratIcon&&y<=74;
		return isPointOverStart;
	}
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		DrawingUtility.drawStatusBar(g2d, remainingEnemyB, remainingEnemyD,
				maxEnemyB, maxEnemyD, coin, isPointOverHandGun,
				isPointOverShotGun, isPointOverRifle,isPointOverStart);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return !isDestroyed;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return isDestroyed;
	}

}
