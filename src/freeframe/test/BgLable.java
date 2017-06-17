package freeframe.test;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import freeframe.system.GameObject;
import freeframe.utils.ResourceUtil;

public class BgLable implements GameObject{

	BufferedImage bg = null;
	int x;
	int y;
	int width;
	int height;
	
	
	public BgLable(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		bg = ResourceUtil.getImage("image/bg.jpg");
	}

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
		// TODO Auto-generated method stub
		g2d.drawImage(bg,x,y,width,height,null);
		g2d.drawImage(bg,x,y-height,width,height,null);
		
	}

	long renderAccumilatedTime = 0;// 上次渲染的时间
	@Override
	public void update() {
		// TODO Auto-generated method stub
		long starttime = System.nanoTime();
		starttime = starttime / 1000000;// 当前毫秒
		if (33 <= (starttime - renderAccumilatedTime)) {
			renderAccumilatedTime = starttime;
			this.y += 1;
			if(this.y >= height)y = 0;
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
