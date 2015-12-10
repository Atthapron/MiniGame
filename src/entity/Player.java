package entity;

public class Player {
	private static int score;
	private static int money;
	static{
		Player.score = 0;
		Player.money = 0;
	}
	
	public void addMoney(int getMoney){
		Player.money += getMoney;
	}
	public void pay(int payMoney){
		Player.money -= payMoney;
	}
	public void addScore(int score){
		Player.score += score;
	}
	public void reScore(){
		Player.score = 0;
	}
	

}
