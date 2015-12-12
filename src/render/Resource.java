package render;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.applet.*;

import javax.imageio.ImageIO;

//ขาดเสียงประกอบ นะจ๊ะ
public class Resource {

	public static BufferedImage getImage(String directory) {
		try {
			ClassLoader loader = RenderableHolder.class.getClassLoader();
			return ImageIO.read(loader.getResource(directory));
		} catch (Exception e) {
			System.out.println("cannot load "+directory);
			return null;
		}
	}

	public static AudioClip getSound(String directory) {
		try {
			ClassLoader loader = RenderableHolder.class.getClassLoader();
			return Applet.newAudioClip((loader.getResource(directory)).toURI()
					.toURL());
		} catch (Exception e) {
			System.out.println("cannot load "+directory);
			return null;
		}
	}
	// screen - incomplete
	public static BufferedImage tile = getImage("res/screen/tile.png");
	public static BufferedImage titleScene = getImage("res/screen/title.png");
	public static BufferedImage newGame_bt =  getImage("res/screen/newgame.png");
	public static BufferedImage newGameOp_bt =  getImage("res/screen/newgameOp.png");
	public static BufferedImage highScore_bt =  getImage("res/screen/highscore.png");
	public static BufferedImage highScoreOp_bt =  getImage("res/screen/highscoreOp.png");
	public static BufferedImage iconEnemy =  getImage("res/screen/iconenemy.png");
	public static BufferedImage iconShooter =  getImage("res/screen/iconshooter.png");
	public static BufferedImage tree =  getImage("res/screen/tree.png");
	public static BufferedImage home =  getImage("res/screen/home.png");
	public static BufferedImage start_bt =  getImage("res/screen/start.png");


	
	// enemy
	public static BufferedImage zombieBoyWalkSprite = getImage("res/enemy/zombieBoyWalk.png");
	public static BufferedImage zombieBoyDieSprite = getImage("res/enemy/zombieBoyDie.png");

	public static BufferedImage zombieDoctorWalkSprite = getImage("res/enemy/zombieDocWalk.png");
	public static BufferedImage zombieDoctorDieSprite = getImage("res/enemy/zombieDocDie.png");

	// shooter
	public static BufferedImage handGunIdleSprite = getImage("res/shooter/hidle.png");
	public static BufferedImage handGunTurnSprite = getImage("res/shooter/hturn.png");
	public static BufferedImage handGunShootSprite = getImage("res/shooter/hshoot.png");

	public static BufferedImage shotGunIdleSprite = getImage("res/shooter/sidle.png");
	public static BufferedImage shotGunTurnSprite = getImage("res/shooter/sturn.png");
	public static BufferedImage shotGunShootSprite = getImage("res/shooter/sshoot.png");

	public static BufferedImage rifleIdleSprite = getImage("res/shooter/ridle.png");
	public static BufferedImage rifleTurnSprite = getImage("res/shooter/rturn.png");
	public static BufferedImage rifleShootSprite = getImage("res/shooter/rshoot.png");

	// sound
	public static AudioClip zombieSound = getSound("res/sound/zombie.wav");
	public static AudioClip zombieDieSound = getSound("res/sound/zombieDie.wav");
	public static AudioClip shootSound = getSound("res/sound/shoot.wav");
	public static AudioClip coinSound = getSound("res/sound/coin.wav");
	public static AudioClip bgSound = getSound("res/sound/bg.wav");

}
