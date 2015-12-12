package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import render.IRenderable;
import render.RenderableHolder;
import render.Resource;

public class Field implements IRenderable {
	private boolean isPointOver;

	public Field() {
		super();
		RenderableHolder.getInstance().add(this);
	}

	// direction 1 is up
	// direction 2 is down
	// direction 3 is left
	// direction 4 is Right

	private static int[][] field = {
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 3, 1, 1, 5, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0 },
			{ 0, -1, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 3, 1, 1, 1, 6, 0, 0, 2, 0, 0, 0, 2, 0, 0 },
			{ 0, 0, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0 },
			{ 0, 0, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, -1, 0 },
			{ 1, 1, 6, 0, 0, 0, 0, 0, 0, 4, 1, 1, 1, 6, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, 0 } };

	// �͡Ẻ map

	public int getTerrain(int x, int y) {
		if (x < 0 || x >= field[0].length || y < 0 || y >= field.length) {
			System.out.println("Wrong Coordinate");
			return -3;
		}
		return field[y][x];
	}
	public boolean isPointOver() {
		return isPointOver;
	}

	public void setPointOver(boolean isPointOver) {
		this.isPointOver = isPointOver;
	}
	@Override
	public int getZ() {
		return -10;
	}

	@Override
	public void draw(Graphics2D g2d) {

		for (int x = 0; x < field[0].length; x++) {
			for (int y = 0; y < field.length; y++) {
				int terrain = getTerrain(x, y);
				if (terrain < 0)
					terrain = 0;
				g2d.drawImage(
						Resource.tile.getSubimage(terrain * 64, 0, 64, 64),
						null, x * 64, y * 64);
			}
		}

	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

}
