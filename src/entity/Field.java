package entity;

import java.awt.Graphics2D;

import java.awt.image.BufferedImage;

import render.IRenderable;
import render.RenderableHolder;
import render.Resource;
import utility.DrawingUtility;

public class Field implements IRenderable {
	protected boolean isPointOver = false;
	protected boolean isDestroyed = false;

	public Field() {
		super();
		//RenderableHolder.getInstance().add(this);
	}

	// direction 1 is up
	// direction 2 is down
	// direction 3 is left
	// direction 4 is Right
	
	//-1 = tree -2=first coordinate of home and -3=area of home.
	//home use area 2row 3column.

	private static int[][] field = {
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 3, 1, 1, 5, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, -1, -2, -3, -3, -1 },
	{ 0, 0, 0, 0, 0, -1, 2, 0, 0, 2, 0, -1, -3, -3, -3, -1 },
	{ 0, -1, 3, 1, 1, 1, 6, 0, 0, 2, 0, 0, 0, 2, 0, 0 },
	{ 0, 0, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0 },
	{ 0, 0, 2, -1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, -1, 0 },
	{ 1, 1, 6, 0, 0, 0, 0, 0, 0, 4, 1, 1, 1, 6, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, -1, 0 } };
	// �͡Ẻ map
	
	public int getTerrain(int x, int y) {
		if (x < 0 || x >= field[0].length || y < 0 || y >= field.length) {
			System.out.println("Wrong Coordinate");
			return -4;
		}
		return field[y][x];
	}
	public int[][] getField() {
		return field;
	}
	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
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
		DrawingUtility.drawField(this, g2d, isPointOver);

	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return isDestroyed;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return !isDestroyed;
	}

}
