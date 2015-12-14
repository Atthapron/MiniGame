package input;

import render.Resource;

public class InputUtility {
	public static int mouseX,mouseY;
	public static boolean mouseOnScreen = true;
	private static boolean isLeftDown = false;
	private static boolean isLeftClickedLastTick = false;
	public static String type = ""; 
	public static boolean startGame = false;
	
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
			updateInputState();
			return true;
			
		}
		return false;
			
	}
	public static void updateStartGame(){
		startGame = false;
	}
	public static boolean getStartGame(){
		return startGame;
	}

}
