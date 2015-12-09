package utility;

import java.applet.Applet;
import java.applet.AudioClip;

public class AudioUtility {
	private static AudioClip shooter1_shoot;
	private static AudioClip shooter2_shoot;
	private static AudioClip shooter3_shoot;
	private static AudioClip shooter4_shoot;
	private static AudioClip shooterIsPlaced;
	private static AudioClip soundGround1;
	private static AudioClip soundGround2;
	private static AudioClip soundGround3;
	static{
		ClassLoader loader = AudioUtility.class.getClassLoader();
		shooter1_shoot = Applet.newAudioClip(loader.getResource("res/se/shooter1_shoot.wav"));
		shooter2_shoot = Applet.newAudioClip(loader.getResource("res/se/shooter2_shoot"));
		shooter3_shoot = Applet.newAudioClip(loader.getResource("res/se/shooter3_shoot"));
		shooter4_shoot = Applet.newAudioClip(loader.getResource("res/se/shooter4_shoot"));
		shooterIsPlaced = Applet.newAudioClip(loader.getResource("res/se/shooterIsPlaced"));
		soundGround1 = Applet.newAudioClip(loader.getResource("res/se/soundGround1"));
		soundGround2 = Applet.newAudioClip(loader.getResource("res/se/soundGround2"));
		soundGround3 = Applet.newAudioClip(loader.getResource("res/se/soundGround3"));
	}
	
	public static void playSound(String identifier){
		if(identifier.equalsIgnoreCase("shooter1_shoot"))shooter1_shoot.play();
		if(identifier.equalsIgnoreCase("shooter2_shoot"))shooter2_shoot.play();
		if(identifier.equalsIgnoreCase("shooter3_shoot"))shooter3_shoot.play();
		if(identifier.equalsIgnoreCase("shooter4_shoot"))shooter4_shoot.play();
		if(identifier.equalsIgnoreCase("shooterIsPlaced"))shooterIsPlaced.play();
		if(identifier.equalsIgnoreCase("soundGround1"))soundGround1.play();
		if(identifier.equalsIgnoreCase("soundGround2"))soundGround2.play();
		if(identifier.equalsIgnoreCase("soundGround3"))soundGround3.play();
	}
}
