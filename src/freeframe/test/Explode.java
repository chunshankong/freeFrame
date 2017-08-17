package freeframe.test;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import freeframe.system.AbstractGameObject;
import freeframe.system.GameObject;
import freeframe.system.SceneFacade;
import freeframe.utils.ResourceUtil;

public class Explode extends AbstractGameObject{
	
	public Explode(int x, int y, int width, int height, SceneFacade sceneFacade) {
		super(x, y, width, height, sceneFacade);
		// TODO Auto-generated constructor stub
		buf = new BufferedImage[11];
		for(int i=0;i<buf.length;i++){
			buf[i] = ResourceUtil.getImage("image/explode/"+i+".gif");
		}
	}
	int x;
	int y;
	BufferedImage [] buf = null;
	
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
		super.destroy();
		this.buf = null;
		 
	}

	@Override
	public Rectangle getBody() {
		// TODO Auto-generated method stub
		return null;
	}

}
