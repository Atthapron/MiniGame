package render;

import java.awt.Graphics2D;

public class PlayerStatus implements IRenderable{
	private int remainingEnemyB=0;
	private int remainingEnemyD=0;
	private int maxEnemyB=0;
	private int maxEnemyD=0;
	private int coin=0;
	
	public PlayerStatus(){
	super();
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
	
	public void increaseCoin(int coin){
		this.coin += coin;
	}
	public void decreaseCoin(int coin){
		this.coin -=coin;
		if(this.coin <0) this.coin =0;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		DrawingUtility.drawStatusBar(g2d, remainingEnemyB, remainingEnemyD, maxEnemyB, maxEnemyD, coin);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

}
