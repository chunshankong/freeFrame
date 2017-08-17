package freeframe.test;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import freeframe.system.AbstractGameObject;
import freeframe.system.ContactListener;
import freeframe.system.KeyEventListener;
import freeframe.system.Log;
import freeframe.system.SceneFacade;
import freeframe.utils.ResourceUtil;

public class Plane extends AbstractGameObject implements KeyEventListener,ContactListener {

	public Plane(int x, int y, int width, int height, SceneFacade sceneFacade) {
		super(x, y, width, height, sceneFacade);
		// TODO Auto-generated constructor stub
		this.body = ResourceUtil.getImage("image/plane.png");
	}
	private Direction dir = Direction.S;
	
	BufferedImage body = null;
 
	@Override
	public void draw(Graphics2D g2d) {
//		g2d.setColor(Color.BLUE);
//		g2d.fillRect(x, y, width, height);
		g2d.drawImage(body, x, y, width, height, null);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
//		this.x += 1;
		switch (dir) {
		case L: {
			this.x -= 10;
		}
			break;
		case R: {
			this.x+=10;
		}
			break;

		}
	}

	public void keyDown(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_LEFT: {
			dir = Direction.L;
		}
			break;
		case KeyEvent.VK_RIGHT: {
			dir = Direction.R;
		}
			break;
		case KeyEvent.VK_UP: {
			this.y -= 10;
		}
			break;
		case KeyEvent.VK_DOWN: {
			this.y += 10;
		}
			break;

		}

	}

	@Override
	public void keyUp(int keyCode) {
		// TODO Auto-generated method stub
		dir = Direction.S;
	}
 
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beginContact(ContactListener target) {
		if (target instanceof Missile) {
			this.width += 1;
			this.height += 1;
		}
		if (target instanceof Map) {
			this.width -= 1;
			this.height -= 1;
		}
		
	}
	@Override
	public void endContact(ContactListener target) {
		// TODO Auto-generated method stub
		Log.error("离开");
	}

}
