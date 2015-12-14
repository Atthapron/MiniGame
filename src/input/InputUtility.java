package input;


public class InputUtility {
	public static int mouseX,mouseY;
	public static boolean mouseOnScreen = true;
	private static boolean isLeftDown = false;
	private static boolean isLeftClickedLastTick = false;
	public static String type = ""; 
	
	
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
	

}
