package freeframe.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import freeframe.system.GameObject;

public class FpsLabel implements GameObject{

	int show = 0;
	int fpsCount = 0;
	long fpsTime = 0;
	
	@Override
	public void keyDown(int keyCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyUp(int keyCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseLeftButtonDown(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseRightButtonDown(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMiddleButtonDown(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseLeftButtonUp(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseRightButtonUp(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMiddleButtonUp(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseHover(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseLeave(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMove(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub
		
	}

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
		g2d.drawString("FPS:" + String.valueOf(show), 50, 100);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	

}
