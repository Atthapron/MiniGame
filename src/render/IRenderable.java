package render;

import java.awt.Graphics2D;

public interface IRenderable {
	public int getZ();
	public void draw(Graphics2D g2d);
	public boolean isVisible();
}
