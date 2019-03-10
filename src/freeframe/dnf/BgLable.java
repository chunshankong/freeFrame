package freeframe.dnf;

import freeframe.system.AbstractGameObject;
import freeframe.system.SceneFacade;
import freeframe.utils.ResourceUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BgLable extends AbstractGameObject{

	BufferedImage bg = null;
	
	public BgLable(int x, int y, int width, int height, SceneFacade sceneFacade) {
		super(x, y, width, height, sceneFacade);
		// TODO Auto-generated constructor stub
		bg = ResourceUtil.getImage("image/dnf/bg/bg.png");
		
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
		/*long starttime = System.nanoTime();
		starttime = starttime / 1000000;// 当前毫秒
		if (33 <= (starttime - renderAccumilatedTime)) {
			renderAccumilatedTime = starttime;
			this.y += 1;
			if(this.y >= height)y = 0;
		}*/
		
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

}
