package render;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;

public class GameAnimation{
	private BufferedImage image = null;
	private int frameCount, frameDelay;
	private int currentFrame, frameDelayCount;
	private int x,y,frameWidth,frameHeight;
	private boolean visible = false;
	private boolean playing = false;
	private int speed;
	private int direction;
	private double theta;
	public GameAnimation(BufferedImage image, int frameCount, int frameDelay,int speed, int direction, double theta){
		this.image = image;
		this.frameCount = frameCount;
		this.frameDelay = frameDelay;
		this.currentFrame = 0;
		this.speed = speed;
		this.direction = direction;
		this.theta = theta;
		try{
			this.frameWidth = image.getWidth()/frameCount;
			this.frameHeight = image.getHeight();
		}catch (NullPointerException e){
			this.frameWidth = 0;
			this.frameHeight = 0;
		}
	}
	
	public void topLeftAnimationAt(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void centerAnimationAt(int x, int y){
		this.x = x - frameWidth/2;
		this.y = y - frameHeight/2;
	}
	public void play(){
		currentFrame = 0;
		playing = true;
		visible = true;
	}
	public void stop(){
		currentFrame = 0;
		playing = false;
		visible = false;
	}
	public void updateAnimation(){
		if(playing == true){
			if(frameDelayCount>0){
				frameDelayCount--;
				return;
			}
			if(frameDelayCount == 0){
				frameDelayCount = frameDelay;
				currentFrame++;
				move();
			}
			if(currentFrame == frameCount){
				currentFrame = 0;
			}
		}
	}
	public void move(){
		if(direction == 0){
			this.y -= this.speed;
		}
		if(direction == 1){
			this.y += this.speed;
		}
		if(direction == 2){
			this.x -= this.speed;
		}
		if(direction == 3){
			this.x += this.speed;
		}
	}
	
	public boolean isVisible(){
		return visible;
	}
	public int getZ(){
		return 20;
	}
	public void render(Graphics2D g2) throws RasterFormatException{
		if(visible == true && image != null){
			g2.drawImage(image.getSubimage(currentFrame*frameWidth, 0, frameWidth, frameHeight),x,y,frameWidth,frameHeight,null);
			if(direction == 1){
				return;
			}
			else if(direction == 2){
				g2.rotate(Math.PI, x + frameWidth/2, y+frameHeight/2);
			}
			else if(direction == 3){
				g2.rotate(Math.PI/2 ,x + frameWidth/2,y + frameHeight/2);
			}
			else if(direction == 4){
				g2.rotate(Math.PI*3/2, x + frameWidth/2, y+frameHeight/2);
			}
			else {
				g2.rotate(theta,x + frameWidth/2, y+frameHeight/2);
			}
		}
	}
	public void start(Graphics2D g2){
		this.updateAnimation();
		this.render(g2);
	}
	
	
	
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getFrameCount() {
		return frameCount;
	}

	public void setFrameCount(int frameCount) {
		this.frameCount = frameCount;
	}

	public int getFrameDelay() {
		return frameDelay;
	}

	public void setFrameDelay(int frameDelay) {
		this.frameDelay = frameDelay;
	}

	public int getCurrentFrame() {
		return currentFrame;
	}

	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}

	public int getFrameDelayCount() {
		return frameDelayCount;
	}

	public void setFrameDelayCount(int frameDelayCount) {
		this.frameDelayCount = frameDelayCount;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getFrameWidth() {
		return frameWidth;
	}

	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}

	public int getFrameHeight() {
		return frameHeight;
	}

	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}

	public boolean isPlaying() {
		return playing;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	
	
	
	
	
}
