package freeframe.dnf;

import freeframe.system.AbstractGameObject;
import freeframe.system.SceneFacade;
import freeframe.utils.ResourceUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BgLable extends AbstractGameObject{

	BufferedImage bg = null;
	BufferedImage cd = null;
	
	public BgLable(int x, int y, int width, int height, SceneFacade sceneFacade) {
		super(x, y, width, height, sceneFacade);
		// TODO Auto-generated constructor stub
		bg = ResourceUtil.getImage("image/dnf/bg/bg.png");
		cd = ResourceUtil.getImage("image/dnf/bg/cd.png");
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(bg,x,y,width,380,null);
//		g2d.drawImage(bg,x,y-height,width,height,null);

		g2d.drawImage(cd,x,y+370,null);
//		g2d.drawImage(cd,x+224,y+370,null);
//		g2d.drawImage(cd,x+224+224,y+370,null);
//		g2d.drawImage(cd,x+224+224+224,y+370,null);


		int addY = 0;
		for (int i = 0; i < 3; i++) {
			int addX = 0;
			for (int j = 0; j <= 3; j++) {
				g2d.drawImage(cd,x+addX,y+370+addY,null);
				addX += 224;
			}
			addY += 190;
		}

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
