package freeframe.utils;

import java.awt.image.BufferedImage;

import freeframe.system.Log;

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
			if ((systemTime - lastTime) >= duration) {
				lastTime = systemTime;
				index++;
				if (index >= keyFrames.length) {
					index = 0;
				}
			}
			return keyFrames[index];
		}
	}
	public void reset(){
		start = false;
		index = 0;
	}
	
	
	
}
