package entity;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

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
	
	protected BufferedImage image;
	protected BufferedImage diedImage;
	
	
	public Zombie(String type, Point p, int direction, Field field){
		this.position = p;
		this.direction = direction;
		this.field = field;
		this.spawnZombie = 500;
		
		if(type.equalsIgnoreCase("boyZombie")){
			this.hp = 10;
			this.score = 2;
			this.money = 5;
			this.speed = 5;
			this.image = Resource.zombieBoyWalkSprite;
		}
		if(type.equalsIgnoreCase("doctorZombie")){
			this.hp = 15;
			this.score = 5;
			this.money = 10;
			this.speed = 4;
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
	public void update(){
		
		if(direction == Direction.UP){
			this.position.y = (int) (position.getY() - speed);
		}
		if(direction == Direction.DOWN){
			this.position.y = (int) (position.getY() + speed);
		}
		if(direction == Direction.LEFT){
			this.position.x = (int) (position.getY() - speed);
		}
		if(direction == Direction.RIGHT){
			this.position.x = (int) (position.getY() - speed);
		}
	}
	public void turn(Field field){
		int x = position.x;
		int y = position.y;
		int terrain = field.getTerrain(x, y);
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
		try{
			while(isAlive()){
				Thread.sleep(50);
				synchronized (this) {
					update();
					turn(field);
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		if(!isDestroyed())
			new GameAnimation(image, 8,30,speed,direction,0);
		else
			new GameAnimation(diedImage,9,30,speed,direction,0);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		if(isDestroyed())return false;
		return true;
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
