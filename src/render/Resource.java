package render;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.applet.*;
import javax.imageio.ImageIO;


//ขาดเสียงประกอบ นะจ๊ะ
public class Resource {
	//screen - incomplete
	public static BufferedImage tile;
	
	// enemy
	public final static Font standardFont = new Font("Tahoma", Font.BOLD, 30);
	public static BufferedImage zombieBoyWalkSprite;
	public static BufferedImage zombieBoyDieSprite;

	public static BufferedImage zombieDoctorWalkSprite;
	public static BufferedImage zombieDoctorDieSprite;

	// shooter
	public static BufferedImage handGunIdleSprite;
	public static BufferedImage handGunTurnSprite;
	public static BufferedImage handGunShootSprite;

	public static BufferedImage shotGunIdleSprite;
	public static BufferedImage shotGunTurnSprite;
	public static BufferedImage shotGunShootSprite;

	public static BufferedImage rifleIdleSprite;
	public static BufferedImage rifleTurnSprite;
	public static BufferedImage rifleShootSprite;

	// sound
	public static AudioClip zombieSound;
	public static AudioClip zombieDieSound;
	public static AudioClip shootSound;
	public static AudioClip collectSound;
	public static AudioClip bgSound;


	static {
		try {
			ClassLoader loader = RenderableHolder.class.getClassLoader();
			//screen
			tile = ImageIO.read(loader
					.getResource("res/screen/tile.png"));
			//enemy
			zombieBoyWalkSprite = ImageIO.read(loader
					.getResource("res/enemy/zombieBoy.png"));
			zombieBoyDieSprite = ImageIO.read(loader
					.getResource("res/enemy/zombieBoyDie.png"));
			zombieDoctorWalkSprite = ImageIO.read(loader
					.getResource("res/enemy/zombieDoc.png"));
			zombieDoctorDieSprite = ImageIO.read(loader
					.getResource("res/enemy/zombieDocDie.png"));
			//shooter
			handGunIdleSprite = ImageIO.read(loader
					.getResource("res/shooter/hidle.png"));
			handGunTurnSprite = ImageIO.read(loader
					.getResource("res/shooter/hturn.png"));
			handGunShootSprite = ImageIO.read(loader
					.getResource("res/shooter/hshoot.png"));
			
			shotGunIdleSprite = ImageIO.read(loader
					.getResource("res/shooter/sidle.png"));
			shotGunTurnSprite  = ImageIO.read(loader
					.getResource("res/shooter/sturn.png"));
			shotGunShootSprite = ImageIO.read(loader
					.getResource("res/shooter/sshoot.png"));

			rifleIdleSprite = ImageIO.read(loader
					.getResource("res/shooter/ridle.png"));
			rifleTurnSprite  = ImageIO.read(loader
					.getResource("res/shooter/rturn.png"));
			rifleShootSprite = ImageIO.read(loader
					.getResource("res/shooter/rshoot.png"));
			
			//sound
			zombieSound = Applet
					.newAudioClip((loader.getResource("res/sound/zombie.wav")).toURI()
							.toURL());
			zombieDieSound = Applet.newAudioClip((loader
					.getResource("res/sound/zombieDie.wav")).toURI().toURL());
			shootSound = Applet.newAudioClip((loader.getResource("res/sound/shoot.wav"))
					.toURI().toURL());
			collectSound = Applet.newAudioClip((loader
					.getResource("res/sound/collect.wav")).toURI().toURL());
			bgSound = Applet.newAudioClip((loader.getResource("res/sound/bg.wav"))
					.toURI().toURL());
	

		} catch (Exception e) {
			System.out.println("cannot load resources");
			e.printStackTrace();
		}
	}

	public Resource() {
		super();
	}
	
}
