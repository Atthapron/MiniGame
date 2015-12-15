package entity;

public class Player {
	private static int score;
	private static int money;
	static{
		Player.score = 0;
		Player.money = 1200;
		if(money<0)Player.money = 0;
	}
	
	public static void addMoney(int getMoney){
		Player.money += getMoney;
	}
	public static  void pay(int payMoney){
		Player.money -= payMoney;
	}
	public  static void addScore(int score){
		Player.score += score;
	}
	public static void reScore(){
		Player.score = 0;
	}
	public static int getMoney(){
		return Player.money;
	}
	public static int getScore(){
		return Player.score;
	}
	

}
