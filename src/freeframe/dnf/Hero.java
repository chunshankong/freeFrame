package freeframe.dnf;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import freeframe.system.AbstractGameObject;
import freeframe.system.ContactListener;
import freeframe.system.KeyEventListener;
import freeframe.system.Log;
import freeframe.system.SceneFacade;
import freeframe.utils.Animation;
import freeframe.utils.ImageUtil;
import freeframe.utils.ResourceUtil;

public class Hero extends AbstractGameObject implements KeyEventListener,ContactListener{
	
	private AttackRectangle attackRectangle ;

	Animation rightAnimation = null;
	Animation beAttackedAnimation = null;
	Animation currentAnimation = null;

	public Hero(int x, int y, int width, int height, SceneFacade sceneFacade) {
		super(x, y, width, height, sceneFacade);
		// TODO Auto-generated constructor stub
		attackRectangle = new AttackRectangle(0,0,0,0,sceneFacade);
		initialAnimation();
		currentAnimation = rightAnimation;
	}

	private void initialAnimation() {
		BufferedImage[] images = new BufferedImage[42];
		for (int i = 1; i < images.length; i++) {
			images[i] = ImageUtil.flipHorizontal(ResourceUtil.getImage("image/dnf/hero/"+(i+1)+".png"));
		}
		rightAnimation = new Animation();
		rightAnimation.setKeyFrames(images);
		rightAnimation.setDuration(80);


	}


	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub

		g2d.drawImage(currentAnimation.getKeyFrame(), x, y, null);

		g2d.setColor(Color.BLUE);


//		g2d.drawRect(x, y, width, height);
		
//		attackRectangle.draw(g2d);


		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyDown(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_LEFT: {
			this.x -= 10;
			attackRectangle.setX(attackRectangle.getX() - 10);
		}
			break;
		case KeyEvent.VK_RIGHT: {
			this.x += 10;
			attackRectangle.setX(attackRectangle.getX() + 10);
		}
			break;
		case KeyEvent.VK_UP: {
			this.y -= 10;
		}
			break;
		case KeyEvent.VK_DOWN: {
			this.y += 10;
		}
		case KeyEvent.VK_J: {
			attack();
		}
			break;

		}

	}
	boolean attacked = false;
	private void attack(){
		if (attacked) {
			return;
		}
		
		Log.info("attack");
		attacked = true;
		this.attackRectangle.setbounds(x-100, y, 100, 50);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				attackRectangle.setbounds(0, 0, 0, 0);
				attacked = false;
			}
		}).start();
	}

	@Override
	public void keyUp(int keyCode) {
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


}
