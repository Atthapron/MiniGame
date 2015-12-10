package entity;

import java.awt.image.BufferedImage;

public abstract class Shooter {
	protected BufferedImage image;
	protected BufferedImage profile;
	public Shooter(BufferedImage image,BufferedImage profile){
		this.image = image;
		this.profile = profile;
	}
	
	public BufferedImage getImage(){
		return this.image;
	}
	public BufferedImage getProfile(){
		return this.profile;
	}
	
	public abstract void inRange(Zombie zombie);
	public abstract void shoot(Zombie zombie);
	public abstract void hire();
	public abstract void exclude();
	
}
