package freeframe.test;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import freeframe.system.AbstractGameObject;
import freeframe.system.ContactListener;
import freeframe.system.FreeFrame;
import freeframe.system.Log;
import freeframe.system.SceneFacade;
import freeframe.utils.ResourceUtil;

public class Missile extends AbstractGameObject implements ContactListener {

	public Missile(int x, int y, int width, int height, int speed,Direction dir,SceneFacade sceneFacade) {
		super(x, y, width, height, sceneFacade);
		// TODO Auto-generated constructor stub
		this.dir = dir;
		this.speed = speed;
		
		body = ResourceUtil.getImage("image/missile.png");
		body2 = ResourceUtil.getImage("image/missile2.png");
		currentBody = body;
	}

	private int speed;
	private Direction dir;
	
	BufferedImage body = null;
	BufferedImage body2 = null;
	BufferedImage currentBody = null;

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
//		Color c = g2d.getColor();
//		g2d.setColor(Color.RED);
//		g2d.fillOval(x, y, 15, 15);
//		g2d.setColor(c);
		
		g2d.drawImage(currentBody, x, y, width,height,null);
		 
	}

	@Override
	public void update() {
		 
			switch (dir) {
			case L: {
				x -= speed;
				if (0 >= x) {
					dir = Direction.R;
				}
			}
				break;
			case U: {
				y -= speed;
			}
				break;
			case D: {
				y += speed;
			}
				break;
			case R: {
				x += speed;
				if (FreeFrame.WIDTH <= x) {
					dir = Direction.L;
				}
			}
				break;

			default:
				break;
			}
	
	}
int life = 100;
	@Override
	public void beginContact(ContactListener target) {
		if (target instanceof Plane) {
			currentBody = body2;
			
			Log.info("撞到飞机");
			life --;
			
			if (life == 0) {
				this.live = false;
			}
			
		}
	}
	@Override
	public void endContact(ContactListener target) {
		// TODO Auto-generated method stub
		currentBody = body;
	}

}
