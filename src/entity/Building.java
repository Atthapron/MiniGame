package entity;

import java.awt.Graphics2D;

import render.IRenderable;
import render.RenderableHolder;
import utility.DrawingUtility;

public class Building implements IRenderable {
	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}

	protected boolean isDestroyed = false;
	protected Field field;

	public Building(Field field) {
		this.field = field;
		RenderableHolder.getInstance().add(this);
	}
	
	
	@Override
	public int getZ() {
		return 0;
	}

	@Override
	public boolean isVisible() {
		return !isDestroyed;
	}

	@Override
	public boolean isDestroyed() {
		return isDestroyed;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		DrawingUtility.drawBuilding(this.field, g2d);
	}
}
