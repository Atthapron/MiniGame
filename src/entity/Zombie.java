package entity;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.crypto.CipherInputStream;

import input.InputUtility;
import render.GameAnimation;
import render.IRenderable;
import render.Resource;
import utility.Direction;

public class Zombie implements IRenderable,Runnable{
	protected Point position;//position of top left of zombie
	protected int direction;
	protected int speed;
	protected Field field;
	protected int spawnZombie;
	
	protected int hp;
	protected int score;
	protected int money;
	protected boolean isVisible;
	
	protected BufferedImage image;
	protected BufferedImage diedImage;
	
	public static int startX = 0;// must be -32
	public static int startY = 576 - 64;
	
	public Zombie(String type, Point p, int direction, Field field){
		this.position = p;
		this.direction = direction;
		this.field = field;
		this.spawnZombie = 500;
		this.isVisible = true;
		
		if(type.equalsIgnoreCase("boyZombie")){
			this.hp = 10;
			this.score = 2;
			this.money = 5;
			this.speed = 1;
			this.image = Resource.zombieBoyWalkSprite;
		}
		if(type.equalsIgnoreCase("doctorZombie")){
			this.hp = 15;
			this.score = 5;
			this.money = 10;
			this.speed = 1;
			this.image = Resource.zombieDoctorWalkSprite;
		}
	}
	
	public void takeDamage(int damage){
		this.hp -= damage;	
	}
	public int getX(){
		return position.x;
	}
	public int getY(){
		return position.y;
	}
	public void setPosition(int x, int y){
		position = new Point(x,y);
	}
	public void setCenterPosition(int x, int y){
		position = new Point(x - 32, y - 32);
	}
	public boolean isAlive(){
		return isVisible();
	}
	public BufferedImage getImage(){
		return image;
	}
	
	public void update(){
		if(direction == Direction.UP){
			this.position.y = (int) (position.y - speed);
		}
		if(direction == Direction.DOWN){
			this.position.y = (int) (position.y + speed);
		}
		if(direction == Direction.LEFT){
			this.position.x = (int) (position.x - speed);
		}
		if(direction == Direction.RIGHT){
			this.position.x = (int) (position.x + speed);
		}
	}
	public void turn(Field field){
		int x = position.x+32;
		int y = position.y+32;
		int terrain = 0;
		if(direction == 1){
			terrain = field.getTerrain((x)/64 , (y+32)/64);
			
		}
		if(direction == 2){
			terrain = field.getTerrain(((x)/64) , (y-32)/64);
		}
		if(direction == 3){
			terrain = field.getTerrain(((x+32)/64), (y)/64);
		}
		if(direction == 4){
			terrain = field.getTerrain(((x-32)/64), (y)/64);
		}
		if(terrain == -3){
			InputUtility.isGameOver = true;
		}
		
		System.out.println(x/64 + " " + (y)/64 + " " + terrain);
		if(terrain == 1 || terrain == 2){
			return;
		}
		if(terrain == 3){
			if(this.direction == Direction.UP)this.direction = Direction.RIGHT;
			if(this.direction == Direction.LEFT)this.direction = Direction.DOWN;
			return;
		}
		if(terrain == 4){
			if(this.direction == Direction.DOWN)this.direction = Direction.RIGHT;
			if(this.direction == Direction.LEFT)this.direction = Direction.UP;
			return;
		}
		if(terrain == 5){
			if(this.direction == Direction.RIGHT)this.direction = Direction.DOWN;
			if(this.direction == Direction.UP)this.direction = Direction.LEFT;
			return;
		}
		if(terrain == 6){
			if(this.direction == Direction.RIGHT)this.direction = Direction.UP;
			if(this.direction == Direction.DOWN)this.direction = Direction.LEFT;
			return;
		}
		
	}
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
			synchronized (this) {
				int count = 0;
				while(isAlive()){	
				
				turn(field);
				System.out.println("Thread");
			}
		}
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		AffineTransform at = new AffineTransform();
		double angle = 0;
		update();
		turn(field);
		if(direction == 1){
			at.translate(position.x, position.y);
		}
		if(direction == 2){
			angle = Math.PI;
			at.translate(position.x+64, position.y+64);
		}
		if(direction == 3){
			angle = Math.PI*3/2;
			at.translate(position.x, position.y);
		}
		if(direction == 4){
			angle = Math.PI/2;
			at.translate(position.x+64, position.y);
		}
		
		
		at.rotate(angle);
		at.scale(1, 1);
		g2d.drawImage(image.getSubimage(0, 0, 64, 64),at,null);
		
		
		/*GameAnimation a = new GameAnimation(image, 8,1000,1,direction,0);
		GameAnimation b= new GameAnimation(diedImage,9,1000,0,direction,0);
		a.setTopLeftAt(position.x , position.y);
		if(!isDestroyed()){
			a.start(g2d);
			System.out.println("draw" + a.getCurrentFrame());
			return;
		}
		else{
			b.render(g2d);
			b.updateAnimation();
			if(b.getCurrentFrame() == b.getFrameCount())isVisible = false;
		}*/
		
	}
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return isVisible;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		if(hp > 0)return false;
		Player.addScore(score);
		Player.addMoney(money);
		return true;
	}
	
	
}
