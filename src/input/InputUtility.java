package input;

import entity.PlayerStatus;
import render.Resource;

public class InputUtility {
	public static int mouseX,mouseY;
	public static boolean mouseOnScreen = true;
	private static boolean isLeftDown = false;
	private static boolean isLeftClickedLastTick = false;
	public static String type = ""; 
	public static boolean startGame = false;
	public static boolean CLICK = false;
	
	
	public static void mouseLeftDown(){
		isLeftDown = true;
		isLeftClickedLastTick = true;
	}
	
	public static void mouseLeftRelease(){
		isLeftDown = false;
	}
	public static void setType(String type){
		InputUtility.type = type;
	}
	
	public static boolean isLeftClickTriggered(){
		return isLeftClickedLastTick;
	}
	
	public static void updateInputState(){
		isLeftClickedLastTick = false;
	}
	public static void updateType(){
		InputUtility.type = "";
	}
	public static boolean clickGo(){
		if(InputUtility.mouseOnScreen && 
				mouseX>480 && mouseX<Resource.start_bt.getWidth()+480 &&
				mouseY>10 && mouseY<Resource.start_bt.getHeight()+10 &&
				isLeftClickedLastTick
				){
			System.out.print(true);
			return true;
			
		}
		System.out.print(false);
		return false;
			
	}
	public static void setShooterClicked(){
		if(InputUtility.mouseOnScreen && 
				mouseX>PlayerStatus.xHandGunIcon && mouseX<PlayerStatus.xHandGunIcon+64 &&
				mouseY>PlayerStatus.yHandGunIcon && mouseY<PlayerStatus.yHandGunIcon+64 && 
				isLeftClickedLastTick)
					type = "handgun";
		if(InputUtility.mouseOnScreen && 
				mouseX>PlayerStatus.xRifleIcon && mouseX<PlayerStatus.xRifleIcon+64 &&
				mouseY>PlayerStatus.yRifleIcon && mouseY<PlayerStatus.yRifleIcon+64 && 
				isLeftClickedLastTick)
					type = "rifle";
		if(InputUtility.mouseOnScreen && 
				mouseX>PlayerStatus.xShotGunIcon && mouseX<PlayerStatus.xShotGunIcon+64 &&
				mouseY>PlayerStatus.yShotGunIcon  && mouseY<PlayerStatus.yShotGunIcon+64 && 
				isLeftClickedLastTick)
					type = "shotgun";
		System.out.print(type);
	}
	
	
	public static void updateStartGame(){
		startGame = false;
	}
	
}
