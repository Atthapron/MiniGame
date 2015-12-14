package render;

import java.awt.Point;
import java.sql.SQLInvalidAuthorizationSpecException;
import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.CPInstruction;
import com.sun.swing.internal.plaf.synth.resources.synth;

import entity.Field;
import entity.Shooter;
import entity.Zombie;
import input.InputUtility;
import utility.Direction;

public class GameManager {
	
	private Field field;
	private ArrayList<Zombie> zombies;
	private ArrayList<Shooter> shooters;
	private static final int SPAWN_DEALY = 100;
	private int spawnDelayCounter;
	private int zombieBoyCounter;
	private int zombieDoctorCouter;
	
	public Thread zombieSpawnThread;
	public Thread placeShooterThread;
	private boolean isPause;
	
	
	public GameManager(){
		this.field = new Field();
		this.zombies = new ArrayList<Zombie>();
		this.shooters = new ArrayList<Shooter>();
		this.spawnDelayCounter = 0;
		this.zombieBoyCounter = 0;
		this.zombieDoctorCouter = 0;
		this.zombieSpawnThread = new Thread(new Runnable() {
			public void run() {
				while(true){
					spawnZombie();
				}
			}
		});
		this.placeShooterThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					zombieSpawnThread.join();
					for(int i=0;i<shooters.size();i++){
						new Thread(shooters.get(i)).join();
					}
					
					while(true){
						placeShooter(InputUtility.type);
						InputUtility.updateType();
					}
				}catch (InterruptedException e){
						e.printStackTrace();
						Thread.interrupted();
					}
			}
			
		});
	
	}
	public void update(){
		RenderableHolder.getInstance().add(field);
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
				notify();
			}catch (InterruptedException e){
				Thread.interrupted();
			}
		}
	}
	

	
	public  void spawnZombie(){
		spawnDelayCounter++;
		String type = "";
		if(Math.random()>=0.5)type = "boyzombie";
		else type = "doctorZombie";
		if(spawnDelayCounter >= SPAWN_DEALY){
			spawnDelayCounter = 0;
			//�������Թ�����
			if(zombieBoyCounter>30){
				type = "doctorZombie";
				return;
			}
			if(zombieDoctorCouter>30){
				type = "boyzombie";
				return;
			}
			if(zombieBoyCounter>30 && zombieDoctorCouter>30){
				zombieSpawnThread.interrupt();
				return;
			}
			Zombie zombie = new Zombie(type, new Point(0, 0), Direction.RIGHT, field);
			//new Point() start point
			RenderableHolder.getInstance().add(zombie);
			new Thread(zombie).start();
			zombies.add(zombie);
			if(type.equalsIgnoreCase("boyZombie"))zombieBoyCounter++;
			if(type.equalsIgnoreCase("doctorZombie"))zombieDoctorCouter++;
			
		}
	}
	public synchronized  void placeShooter(String type){
		
		Shooter shooter = new Shooter(type);
		if(shooter.tryToBuy){
			if(canPlace(shooter)){
				if(InputUtility.isLeftClickTriggered() && InputUtility.mouseY>75){
					shooter.buy(new Point(InputUtility.mouseX, InputUtility.mouseY));
					RenderableHolder.getInstance().add(shooter);
					shooters.add(shooter);
				}	
			}	
		}
			
	}
	public ArrayList<Shooter> getShooterS(){
		return shooters;
	}
	

	public boolean canPlace(Shooter shooter){
		for(int i=0;i<shooters.size();i++){
			if(shooters.get(i).getCenterPoint() == shooter.getCenterPoint())
				return false;
		}
		return true;
	}
	public Thread getPlacedShooterThread(){
		return placeShooterThread;
	}

	
}
