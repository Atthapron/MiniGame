package utility;

public class InputUtility {
	private static int x;
	private static int y;
	static{
		x = 0;
		y = 0;
	}
	
	public int getX(){
		return InputUtility.x;
	}
	public int getY(){
		return InputUtility.y;
	}
	public void setX(int x){
		InputUtility.x = x;
	}
	public void setY(int y){
		InputUtility.y = y;
	}
	public boolean isMouseOnScreen(){
		// fill code state return true;
		return false;
	}
	
}
