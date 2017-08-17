package freeframe.test;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import freeframe.system.AbstractGameObject;
import freeframe.system.ContactListener;
import freeframe.system.SceneFacade;
import freeframe.utils.ResourceUtil;

public class Map extends AbstractGameObject implements ContactListener{

	
	public Map(int x, int y, int width, int height, SceneFacade sceneFacade) {
		super(x, y, width, height, sceneFacade);
		// TODO Auto-generated constructor stub
		bodyImg = ResourceUtil.getImage("image/blackhole.png");
	}
	BufferedImage bodyImg = null;
 
	
	
	
	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(bodyImg, x, y, null);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beginContact(ContactListener target) {
		// TODO Auto-generated method stub
	}
	@Override
	public void endContact(ContactListener target) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Rectangle getBody() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, bodyImg.getWidth(), bodyImg.getHeight());
	}
}
