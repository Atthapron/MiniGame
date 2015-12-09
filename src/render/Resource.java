package render;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.applet.*;
import javax.imageio.ImageIO;


//ขาดเสียงประกอบ นะจ๊ะ
public class Resource {
	// enemy
	public final static Font standardFont = new Font("Tahoma", Font.BOLD, 30);
	public static BufferedImage[] zombieBoyWalkSprite;
	public static BufferedImage[] zombieBoyDieSprite;

	public static BufferedImage[] zombieDoctorWalkSprite;
	public static BufferedImage[] zombieDoctorDieSprite;

	// shooter
	public static BufferedImage[] handGunMeleeSprite;
	public static BufferedImage[] handGunShootSprite;

	public static BufferedImage[] shotGunMeleeSprite;
	public static BufferedImage[] shotGunShootSprite;

	public static BufferedImage[] rifleMeleeSprite;
	public static BufferedImage[] rifleShootSprite;

	// sound
	public static AudioClip zombieSound;
	public static AudioClip zombieDieSound;
	public static AudioClip shootSound;
	public static AudioClip collectSound;

	public static AudioClip successSound;
	public static AudioClip dieSound;
	public static AudioClip bgSound;
	public static AudioClip loseSound;

	static {
		try {
			ClassLoader loader = RenderableHolder.class.getClassLoader();

			zombieBoyWalkSprite[0] = ImageIO.read(loader
					.getResource("res/zombieBoy/zombieBoy1.png"));
			zombieBoyWalkSprite[1] = ImageIO.read(loader
					.getResource("res/zombieBoy/zombieBoy2.png"));
			zombieBoyWalkSprite[2] = ImageIO.read(loader
					.getResource("res/zombieBoy/zombieBoy3.png"));
			zombieBoyWalkSprite[3] = ImageIO.read(loader
					.getResource("res/zombieBoy/zombieBoy4.png"));
			zombieBoyWalkSprite[4] = ImageIO.read(loader
					.getResource("res/zombieBoy/zombieBoy5.png"));
			zombieBoyWalkSprite[5] = ImageIO.read(loader
					.getResource("res/zombieBoy/zombieBoy6.png"));
			zombieBoyWalkSprite[6] = ImageIO.read(loader
					.getResource("res/zombieBoy/zombieBoy7.png"));
			zombieBoyWalkSprite[7] = ImageIO.read(loader
					.getResource("res/zombieBoy/zombieBoy8.png"));

			zombieBoyDieSprite[0] = ImageIO.read(loader
					.getResource("res/zombieBoy/zombieBoyDie1.png"));
			zombieBoyDieSprite[1] = ImageIO.read(loader
					.getResource("res/zombieBoyDie2.png"));
			zombieBoyDieSprite[2] = ImageIO.read(loader
					.getResource("res/zombieBoy/zombieBoyDie3.png"));
			zombieBoyDieSprite[3] = ImageIO.read(loader
					.getResource("res/zombieBoy/zombieBoyDie4.png"));

			zombieDoctorWalkSprite[0] = ImageIO.read(loader
					.getResource("res/zombieDoc/zombieDoc1.png"));
			zombieDoctorWalkSprite[1] = ImageIO.read(loader
					.getResource("res/zombieDoc/zombieDoc2.png"));
			zombieDoctorWalkSprite[2] = ImageIO.read(loader
					.getResource("res/zombieDoc/zombieDoc3.png"));
			zombieDoctorWalkSprite[3] = ImageIO.read(loader
					.getResource("res/zombieDoc/zombieDoc4.png"));
			zombieDoctorWalkSprite[4] = ImageIO.read(loader
					.getResource("res/zombieDoc/zombieDoc5.png"));
			zombieDoctorWalkSprite[5] = ImageIO.read(loader
					.getResource("res/zombieDoc/zombieDoc6.png"));
			zombieDoctorWalkSprite[6] = ImageIO.read(loader
					.getResource("res/zombieDoc/zombieDoc7.png"));
			zombieDoctorWalkSprite[7] = ImageIO.read(loader
					.getResource("res/zombieDoc/zombieDoc8.png"));

			zombieDoctorDieSprite[0] = ImageIO.read(loader
					.getResource("res/zombieDoc/zombieDocDie1.png"));
			zombieDoctorDieSprite[1] = ImageIO.read(loader
					.getResource("res/zombieDoc/zombieDocDie2.png"));
			zombieDoctorDieSprite[2] = ImageIO.read(loader
					.getResource("res/zombieDoc/zombieDocDie3.png"));
			zombieDoctorDieSprite[3] = ImageIO.read(loader
					.getResource("res/zombieDoc/zombieDocDie4.png"));

			handGunMeleeSprite[0] = ImageIO.read(loader
					.getResource("res/handGun/melee1.png"));
			handGunMeleeSprite[1] = ImageIO.read(loader
					.getResource("res/handGun/melee2.png"));
			handGunMeleeSprite[2] = ImageIO.read(loader
					.getResource("res/handGun/melee3.png"));
			handGunMeleeSprite[3] = ImageIO.read(loader
					.getResource("res/handGun/melee4.png"));
			handGunMeleeSprite[4] = ImageIO.read(loader
					.getResource("res/handGun/melee5.png"));
			handGunMeleeSprite[5] = ImageIO.read(loader
					.getResource("res/handGun/melee6.png"));
			handGunMeleeSprite[6] = ImageIO.read(loader
					.getResource("res/handGun/melee7.png"));
			handGunMeleeSprite[7] = ImageIO.read(loader
					.getResource("res/handGun/melee8.png"));
			handGunMeleeSprite[8] = ImageIO.read(loader
					.getResource("res/handGun/melee9.png"));
			handGunMeleeSprite[9] = ImageIO.read(loader
					.getResource("res/handGun/melee10.png"));
			handGunMeleeSprite[10] = ImageIO.read(loader
					.getResource("res/handGun/melee11.png"));
			handGunMeleeSprite[11] = ImageIO.read(loader
					.getResource("res/handGun/melee12.png"));
			handGunMeleeSprite[12] = ImageIO.read(loader
					.getResource("res/handGun/melee13.png"));
			handGunMeleeSprite[13] = ImageIO.read(loader
					.getResource("res/handGun/melee14.png"));

			handGunShootSprite[0] = ImageIO.read(loader
					.getResource("res/handGun/shoot1.png"));
			handGunShootSprite[1] = ImageIO.read(loader
					.getResource("res/handGun/shoot2.png"));
			handGunShootSprite[2] = ImageIO.read(loader
					.getResource("res/handGun/shoot3.png"));

			shotGunMeleeSprite[0] = ImageIO.read(loader
					.getResource("res/shotGun/melee1.png"));
			shotGunMeleeSprite[1] = ImageIO.read(loader
					.getResource("res/shotGun/melee2.png"));
			shotGunMeleeSprite[2] = ImageIO.read(loader
					.getResource("res/shotGun/melee3.png"));
			shotGunMeleeSprite[3] = ImageIO.read(loader
					.getResource("res/shotGun/melee4.png"));
			shotGunMeleeSprite[4] = ImageIO.read(loader
					.getResource("res/shotGun/melee5.png"));
			shotGunMeleeSprite[5] = ImageIO.read(loader
					.getResource("res/shotGun/melee6.png"));
			shotGunMeleeSprite[6] = ImageIO.read(loader
					.getResource("res/shotGun/melee7.png"));
			shotGunMeleeSprite[7] = ImageIO.read(loader
					.getResource("res/shotGun/melee8.png"));
			shotGunMeleeSprite[8] = ImageIO.read(loader
					.getResource("res/shotGun/melee9.png"));
			shotGunMeleeSprite[9] = ImageIO.read(loader
					.getResource("res/shotGun/melee10.png"));
			shotGunMeleeSprite[10] = ImageIO.read(loader
					.getResource("res/shotGun/melee11.png"));
			shotGunMeleeSprite[11] = ImageIO.read(loader
					.getResource("res/shotGun/melee12.png"));
			shotGunMeleeSprite[12] = ImageIO.read(loader
					.getResource("res/shotGun/melee13.png"));
			shotGunMeleeSprite[13] = ImageIO.read(loader
					.getResource("res/shotGun/melee14.png"));

			shotGunShootSprite[0] = ImageIO.read(loader
					.getResource("res/shotGun/shoot1.png"));
			shotGunShootSprite[1] = ImageIO.read(loader
					.getResource("res/shotGun/shoot2.png"));
			shotGunShootSprite[2] = ImageIO.read(loader
					.getResource("res/shotGun/shoot3.png"));

			rifleMeleeSprite[0] = ImageIO.read(loader
					.getResource("res/rifle/melee1.png"));
			rifleMeleeSprite[1] = ImageIO.read(loader
					.getResource("res/rifle/melee2.png"));
			rifleMeleeSprite[2] = ImageIO.read(loader
					.getResource("res/rifle/melee3.png"));
			rifleMeleeSprite[3] = ImageIO.read(loader
					.getResource("res/rifle/melee4.png"));
			rifleMeleeSprite[4] = ImageIO.read(loader
					.getResource("res/rifle/melee5.png"));
			rifleMeleeSprite[5] = ImageIO.read(loader
					.getResource("res/rifle/melee6.png"));
			rifleMeleeSprite[6] = ImageIO.read(loader
					.getResource("res/rifle/melee7.png"));
			rifleMeleeSprite[7] = ImageIO.read(loader
					.getResource("res/rifle/melee8.png"));
			rifleMeleeSprite[8] = ImageIO.read(loader
					.getResource("res/rifle/melee9.png"));
			rifleMeleeSprite[9] = ImageIO.read(loader
					.getResource("res/rifle/melee10.png"));
			rifleMeleeSprite[10] = ImageIO.read(loader
					.getResource("res/rifle/melee11.png"));
			rifleMeleeSprite[11] = ImageIO.read(loader
					.getResource("res/rifle/melee12.png"));
			rifleMeleeSprite[12] = ImageIO.read(loader
					.getResource("res/rifle/melee13.png"));
			rifleMeleeSprite[13] = ImageIO.read(loader
					.getResource("res/rifle/melee14.png"));

			rifleShootSprite[0] = ImageIO.read(loader
					.getResource("res/rifle/shoot1.png"));
			rifleShootSprite[1] = ImageIO.read(loader
					.getResource("res/rifle/shoot2.png"));
			rifleShootSprite[2] = ImageIO.read(loader
					.getResource("res/rifle/shoot3.png"));

			zombieSound = Applet
					.newAudioClip((loader.getResource("zombie.wav")).toURI()
							.toURL());
			zombieDieSound = Applet.newAudioClip((loader
					.getResource("zombieDie.wav")).toURI().toURL());
			shootSound = Applet.newAudioClip((loader.getResource("shoot.wav"))
					.toURI().toURL());
			collectSound = Applet.newAudioClip((loader
					.getResource("collect.wav")).toURI().toURL());
			successSound = Applet.newAudioClip((loader
					.getResource("success.wav")).toURI().toURL());
			dieSound = Applet.newAudioClip((loader.getResource("die.wav"))
					.toURI().toURL());
			bgSound = Applet.newAudioClip((loader.getResource("bg.wav"))
					.toURI().toURL());
			loseSound = Applet.newAudioClip((loader.getResource("lose.wav"))
					.toURI().toURL());

		} catch (Exception e) {
			System.out.println("cannot load resource");
			e.printStackTrace();

			zombieBoyWalkSprite = null;
			zombieBoyDieSprite = null;
			zombieDoctorDieSprite = null;
			zombieDoctorWalkSprite = null;
			handGunMeleeSprite = null;
			handGunShootSprite = null;
			shotGunMeleeSprite = null;
			shotGunShootSprite = null;
			handGunMeleeSprite = null;
			handGunShootSprite = null;
			rifleMeleeSprite = null;
			rifleShootSprite = null;

			zombieSound = null;
			zombieDieSound = null;
			shootSound = null;
			collectSound = null;
			successSound = null;
			dieSound = null;
			bgSound = null;
			loseSound = null;
			
		}
	}

	public Resource() {
		super();
	}
	
}
