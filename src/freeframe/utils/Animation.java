package freeframe.utils;

import java.awt.image.BufferedImage;

public class Animation {
	
	public enum PlayMode {
		LOOP_NORMAL,
		LOOP_PINGPONG, 
		LOOP_RANDOM,
		LOOP_REVERSED, 
		NORMAL,
		REVERSED 
	};
	private PlayMode playMode;
	private long duration;
	private BufferedImage [] keyFrames;
	private int index = 0;
	private boolean start = false;
	
	private long lastTime = 0;
	
	private long elapsedTime = 0;//切换关键帧经过的时间
 
	public void setPlayMode(PlayMode playMode) {
		this.playMode = playMode;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public void setKeyFrames(BufferedImage[] keyFrames) {
		this.keyFrames = keyFrames;
	}
	
	public BufferedImage getKeyFrame(){
		if (!start) {
			start = true;
			lastTime = System.currentTimeMillis();
			return keyFrames[0];
		}else {
			long systemTime = System.currentTimeMillis();
			long deltaTime = systemTime - lastTime;
			lastTime = systemTime;
			elapsedTime += deltaTime;
			
			if (elapsedTime >= duration) {
				elapsedTime = 0;
				index++;
				if (index >= keyFrames.length) {
					index = 0;
				}
				System.err.println("index++");
			}
			
			return keyFrames[index];
		}
		
	}
	
	
	
}
