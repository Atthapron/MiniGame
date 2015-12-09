package render;

import java.awt.Graphics;

public interface IRenderable {
	public int getZ();
	public void draw(Graphics g2);
	public boolean isDestroyed();
}
