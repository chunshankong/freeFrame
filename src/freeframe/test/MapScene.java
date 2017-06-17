package freeframe.test;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import freeframe.system.Scene;
import freeframe.utils.ResourceUtil;

@SuppressWarnings("serial")
public class MapScene extends Scene{

	BufferedImage map = null;
	
	public MapScene(int x, int y, int width, int height, float alpha) {
		super(x, y, width, height, alpha);
		// TODO Auto-generated constructor stub
		map = ResourceUtil.getImage("image/map.png");
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(map, 0, 0, null);
		g2d.fillOval(50, 10, 10, 10);
//		g2d.drawOval(0, 0, 200, 200);
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
