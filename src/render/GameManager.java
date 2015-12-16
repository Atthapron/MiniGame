package render;

import java.awt.Point;
import java.sql.SQLInvalidAuthorizationSpecException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import com.sun.org.apache.bcel.internal.generic.CPInstruction;
import com.sun.swing.internal.plaf.synth.resources.synth;

import entity.Field;
import entity.Shooter;
import entity.Zombie;
import input.InputUtility;
import utility.Direction;

public class GameManager {
	
	private Field field;
	//public CopyOnWriteArrayList<Zombie> zombies;
	//private CopyOnWriteArrayList<Shooter> shooters;
	private static final int SPAWN_DEALY = 100;
	private int spawnDelayCounter;
	private int zombieBoyCounter;
	private int zombieDoctorCouter;
	
	
	public Thread zombieSpawnThread;
	public Thread placeShooterThread;
	private boolean isPause;
	
	
	public GameManager(){
		this.field = new Field();
		//this.zombies = new CopyOnWriteArrayList<Zombie>();
		//this.shooters = new CopyOnWriteArrayList<Shooter>();
		this.spawnDelayCounter = 0;
		this.zombieBoyCounter = 0;
		this.zombieDoctorCouter = 0;
		this.zombieSpawnThread = new Thread(new Runnable() {
			public void run() {
					spawnZombie();
			}
		});
		this.placeShooterThread = new Thread(new Runnable() {
			public void run() {
					placeShooter(InputUtility.type);
					InputUtility.updateType();				
			}			
		});
		
	}
	public void update(){
		
		if(InputUtility.type.length() != 0){
			placeShooterThread.interrupt();
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			placeShooter(InputUtility.type);
			System.out.println("update");
			InputUtility.updateType();
		}
		//System.out.println("go " + InputUtility.zombieGo);
		if(InputUtility.zombieGo){
			spawnZombie();
		}
		for (IRenderable s : RenderableHolder.getInstance().getRenderableList())
		{
			if (s instanceof Shooter)
			{
				((Shooter)s).update();
				for (IRenderable t : RenderableHolder.getInstance().getRenderableList())
				{
					if (t instanceof Zombie)
					{
						((Shooter)s).addTarget((Zombie)t);
					}
				}
			}
			if (s instanceof Zombie)
			{
				((Zombie) s).update();
			}
			if (s.isDestroyed())
			{
				RenderableHolder.getInstance().remove(s);
			}
		}
		/*for (Zombie zombie : zombies)
		{
			System.out.println(zombie.hp);
			if (zombie.isDestroyed()) zombies.remove(zombie);
		}
		for (Shooter shooter : shooters)
		{
			for (Zombie zombie : zombies)
			{
				shooter.addTarget(zombie);
			}
		}*/
		/*if(InputUtility.startGame){
			placeShooterThread.start();
			InputUtility.updateStartGame();
		}
		
		
		if(isPause){
			try {
				zombieSpawnThread.wait();
				for(Shooter s : shooters)s.wait();
				for(Zombie z : zombies)z.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.interrupted();
			}
			
		}else {
			zombieSpawnThread.notify();
			placeShooterThread.notify();
			for(Shooter s : shooters)s.notify();
			for(Zombie z : zombies)z.notify();
		}
		if(InputUtility.clickGo()){
			try{
				placeShooterThread.wait();
				zombieSpawnThread.notify();
			}catch (InterruptedException e){
				Thread.interrupted();
			}
		}*/
		
	}
	

	
	public  void spawnZombie(){
		spawnDelayCounter++;
		String type = "";
		if(spawnDelayCounter >= SPAWN_DEALY){
			spawnDelayCounter = 0;
			if(Math.random()>=0.5)type = "boyzombie";
			else type = "doctorZombie";
			//ห้ามมีเกินกี่ตัว
			System.out.println(zombieBoyCounter + "zombieCounter");
			if(zombieBoyCounter>100){
				type = "doctorZombie";
				return;
			}
			if(zombieDoctorCouter>100){
				type = "boyzombie";
				return;
			}
			if(zombieBoyCounter>1 && zombieDoctorCouter>1){
				zombieSpawnThread.interrupt();
				return;
			}
			Zombie zombie = new Zombie(type, new Point(Zombie.startX, Zombie.startY), Direction.RIGHT, field);
			RenderableHolder.getInstance().add(zombie);
			//zombies.add(zombie);
			if(type.equalsIgnoreCase("boyZombie"))zombieBoyCounter++;
			if(type.equalsIgnoreCase("doctorZombie"))zombieDoctorCouter++;
			System.out.println(zombieBoyCounter);
			InputUtility.updateZombieGo();
			/*
		
		System.out.println("spawnDelayCounter " +spawnDelayCounter);
		
			//new Point() start point
			System.out.println("afsdhfddfghjhgdfg" + zombie.getImage().getHeight());
			
			zombies.add(zombie);
			
		*/	
		}
	}
	public  void placeShooter(String type){
		Shooter shooter = new Shooter(type);
		shooter.setVisible(true);
		shooter.setCenterAt(InputUtility.mouseX, InputUtility.mouseY);
		shooter.tryToBuy();
		//shooters.add(shooter);
		RenderableHolder.getInstance().add(shooter);
		InputUtility.updateInputState();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					System.out.println(RenderableHolder.getInstance().getRenderableList().size());
					if(InputUtility.isLeftClickTriggered() && InputUtility.mouseY>75 && canPlace(InputUtility.mouseX/64, InputUtility.mouseY/64)){
						RenderableHolder.getInstance().getRenderableList().remove(shooter);
						shooter.buy(new Point(InputUtility.mouseX, InputUtility.mouseY));
						RenderableHolder.getInstance().add(shooter);
						field.setShooterPosition(InputUtility.mouseX/64, InputUtility.mouseY/64);
						InputUtility.updateInputState();
						break;
					}
					InputUtility.updateInputState();
					
				}
			}
		}).start();
	}
		
		/*if(shooter.tryToBuy){
			if(canPlace(shooter)){
				if(InputUtility.isLeftClickTriggered()){
					shooter.buy(new Point(InputUtility.mouseX, InputUtility.mouseY));
					System.out.println(shooter.getCenterPoint().x);
					field.setShooterPosition(shooter.getCenterPoint().x/64, shooter.getCenterPoint().y/64);
					RenderableHolder.getInstance().add(shooter);
					shooters.add(shooter);
					InputUtility.updateType();
				}	
			}	
		}*/

	/*public CopyOnWriteArrayList<Shooter> getShooterS(){
		return shooters;
	}*/
	

	public boolean canPlace(int x, int y){
		
			if(field.getTerrain(x, y) != 0){
				
				return false;
			}
				
		return true;
	}
	public void startGameManager(){
		placeShooterThread.start();
	}
	

	
}
