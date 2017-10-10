package freeframe.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import freeframe.system.GameObject;
import freeframe.system.SceneFacade;

public class FpsLabel implements GameObject{

	int show = 0;
	int fpsCount = 0;
	long fpsTime = 0;
	
	int x = 50;
	int y = 100;

	@Override
	public void draw(Graphics2D g2d) {
		
		long starttime = System.nanoTime();
		starttime = starttime / 1000000;// 当前毫秒
		
		//compute FPS
		if (1000 <= starttime - fpsTime) {
			fpsTime = starttime;
			show = fpsCount;
			fpsCount = 0;
		}
		fpsCount++;
		
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.setFont(new Font("", 10, 20));
		g2d.drawString("FPS:" + String.valueOf(show), x, y);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getBody() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSceneFacade(SceneFacade sceneFacade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isLive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return new Point(x, y);
	}

}
