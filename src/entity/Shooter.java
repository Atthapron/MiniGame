package entity;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.management.monitor.GaugeMonitor;

import input.InputUtility;
import render.GameAnimation;
import render.GameManager;
import render.IRenderable;
import render.Resource;
import utility.Maths;

public class Shooter implements IRenderable{
	private String type;
	private Point position;// top left
	private int cost;
	private int attack;
	private int range;
	private int shootDelay;
	private int shootDelayCount;
	
	public boolean tryToBuy;
	public boolean isVisible;
	private boolean isBought;
	public boolean isDestroyed;

	
	private BufferedImage image;
	private BufferedImage shootImage;
	private ArrayList<Zombie> zombiesInRange;
	
	
	public Shooter(String type){
		this.shootDelayCount = 0;
		this.type = type;
		zombiesInRange = new ArrayList<Zombie>();
		if(type.equalsIgnoreCase("handgun")){
			this.cost = 5;
			this.attack = 2;
			this.range = 500;
			this.shootDelay = 50;
			this.image = Resource.handGunIdleSprite;
			this.shootImage = Resource.handGunShootSprite;
			
		}
		if(type.equalsIgnoreCase("rifle")){
			this.cost = 10;
			this.attack = 10;
			this.range = 700;
			this.shootDelay = 10;
			this.image = Resource.rifleIdleSprite;
			this.shootImage = Resource.rifleShootSprite;
			
		}
		if(type.equalsIgnoreCase("shotgun")){
			this.cost = 15;
			this.attack = 15;
			this.range =  300;
			this.shootDelay = 30;
			this.image = Resource.shotGunIdleSprite;
			this.shootImage = Resource.shotGunShootSprite;
		}
		System.out.println(image.getWidth());
	}
	
	
	public BufferedImage getImage(){
		return this.image;
	}
	public boolean ready(){
		if(shootDelayCount < shootDelay){
			shootDelayCount++;
			return false;
		}
		shootDelayCount = 0;
		return true;
		
	}
	public void addTarget(Zombie zombie){
		if(Maths.distance(zombie.position, this.getCenterPoint()) <= range){
			zombiesInRange.add(zombie);	
			
		}
		for(Zombie zombies : zombiesInRange){
			if(!zombies.isAlive()){
				zombiesInRange.remove(zombiesInRange.indexOf(zombies));
			}
			else if(!(Maths.distance(zombie.position, this.getCenterPoint()) <= range))
				zombiesInRange.remove(zombiesInRange.indexOf(zombies));
			
		}
		Collections.sort(zombiesInRange, new Comparator<Zombie>() {
			public int  compare(Zombie zombie1, Zombie zombie2){
				double distanceOfZ1 = Maths.distance(zombie1.position, getCenterPoint());
				double disranceofZ2 = Maths.distance(zombie2.position, getCenterPoint());
				if(distanceOfZ1 > disranceofZ2)
					return 1;
				return -1;
			}
		});
		
	}
	public boolean shoot(){
		if(ready()){
			zombiesInRange.get(0).takeDamage(attack);
			Resource.shootSound.play();
			
			return true;
		}
		return false;
	}
	public static boolean canBuy(String type){
		if(type.equalsIgnoreCase("handgun"))return Player.getMoney() > 5;
		if(type.equalsIgnoreCase("rifle"))return Player.getMoney() > 10;
		if(type.equalsIgnoreCase("shotgun"))return 	Player.getMoney() > 15; 
		return false;
	}
	public void tryToBuy(){
		if(!canBuy(type)){
			return;
		}
		this.tryToBuy = true;
		
	}
	public void buy(Point p){
		this.tryToBuy = false;
		Player.pay(cost);
		setCenterAt((p.x/64)*64+32, ((p.y-70)/64+1)*64+32);
		this.isBought = true;
		Resource.coinSound.play();
	}
	
	
	
	public void setCenterAt(int x, int y){
		position = new Point(x-32, y-32);
	}
	public void setTopLeftAt(int x, int y){
		position.x = x;
		position.y = y;
	}
	public Point getCenterPoint(){
		return new Point(position.x + image.getWidth()/2, position.y + image.getHeight()/2);
	}
	public Point getToplLeftPoint(){
		return position;
	}
	public String getType(){
		return type;
	}
	public ArrayList<Zombie> getZombieInRange(){
		return zombiesInRange;
	}
		
	
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 100;
	}


	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		if(this.tryToBuy){
			//g2d.drawImage(image.getSubimage(64, 0, 64, 64), InputUtility.mouseX - 32, InputUtility.mouseY-32, 64, 64, null);
			g2d.drawImage(image.getSubimage(0, 0, 64, 64), null, InputUtility.mouseX-32, InputUtility.mouseY-32);
			
		}
		if(this.isBought){
			g2d.drawImage(image.getSubimage(0, 0, 64, 64), null, position.x, position.y);
		}
		
		if(zombiesInRange.size() > 0){
			Zombie nearestZombie = zombiesInRange.get(0);
			double theta = Math.asin((nearestZombie.position.y - position.y)/Maths.distance(nearestZombie.position, getCenterPoint()));
			if(nearestZombie.position.x < position.x)theta = Math.PI - theta;
			/*if(shoot()){
				//new GameAnimation(shootImage, 3, 30, 0, 0,theta);
				AffineTransform at = new AffineTransform();
				at.scale(1, 1);
				at.rotate(theta);
				at.translate(position.x + 32, position.y + 32);
				g2d.drawImage(shootImage.getSubimage(0, 0,64, 64), at, null);
				//g2d.rotate(theta, position.x + 32, position.y + 32);
			}*/
		}
		
	}


	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return isVisible;
	
	}


	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return isDestroyed;
	}


	public void update() {
		// TODO Auto-generated method stub
		if(zombiesInRange.size() > 0){
			shoot();
			zombiesInRange.clear();
		}
	}
	public void setVisible(boolean visible){
		isVisible = visible;
	}
	
	public void setType(String type){
		this.type = type;
		if(type.equalsIgnoreCase("handgun")){
			this.cost = 5;
			this.attack = 1;
			this.range = 1000;
			this.shootDelay = 50;
			this.image = Resource.handGunIdleSprite;
			this.shootImage = Resource.handGunShootSprite;
			
		}
		if(type.equalsIgnoreCase("rifle")){
			this.cost = 10;
			this.attack = 6;
			this.range = 2000;
			this.shootDelay = 10;
			this.image = Resource.rifleIdleSprite;
			this.shootImage = Resource.rifleShootSprite;
			
		}
		if(type.equalsIgnoreCase("shotgun")){
			this.cost = 15;
			this.attack = 8;
			this.range =  3000;
			this.shootDelay = 30;
			this.image = Resource.shotGunIdleSprite;
			this.shootImage = Resource.shotGunShootSprite;
		}
	}
	public void setDestroyed(boolean destroyed){
		this.isDestroyed = destroyed;
	}

}
