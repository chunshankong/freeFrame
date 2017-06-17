package freeframe.test;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import freeframe.system.FreeFrame;
import freeframe.system.GameObject;
import freeframe.system.Log;
import freeframe.utils.ResourceUtil;

public class Explode implements GameObject{
	
	int x;
	int y;
	BufferedImage [] buf = null;
	
	public Explode(int x,int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		
		buf = new BufferedImage[11];
		for(int i=0;i<buf.length;i++){
			buf[i] = ResourceUtil.getImage("image/explode/"+i+".gif");
		}
		
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
		g2d.drawImage(buf[count],x,y,null);
	}
	int count = 0;
	long renderAccumilatedTime = 0;// 上次渲染的时间
	@Override
	public void update() {
		
		long starttime = System.nanoTime();
		starttime = starttime / 1000000;// 当前毫秒
		if (66 <= (starttime - renderAccumilatedTime)) {
			renderAccumilatedTime = starttime;
			count++;
		}
		if(buf.length <= count){
			count = 0;
			x += 20;
			if(600 < x){
				x = 0;
			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
