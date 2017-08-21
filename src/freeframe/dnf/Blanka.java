package freeframe.dnf;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import freeframe.system.AbstractGameObject;
import freeframe.system.ContactListener;
import freeframe.system.KeyEventListener;
import freeframe.system.SceneFacade;
import freeframe.utils.Animation;
import freeframe.utils.ResourceUtil;

public class Blanka extends AbstractGameObject implements KeyEventListener,ContactListener{

	Animation rightAnimation = null;
	public Blanka(int x, int y, int width, int height, SceneFacade sceneFacade) {
		super(x, y, width, height, sceneFacade);
		// TODO Auto-generated constructor stub
		
		initialAnimation();
	}
	private void initialAnimation() {
		BufferedImage [] images = new BufferedImage[6];
		for (int i = 0; i < images.length; i++) {
			images[i] = ResourceUtil.getImage("image/dnf/blanka/"+(9+i)+".png");
		}
		rightAnimation = new Animation();
		rightAnimation.setKeyFrames(images);
		rightAnimation.setDuration(200);
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(rightAnimation.getKeyFrame(), x, y, null);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
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
	public void beginContact(ContactListener target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endContact(ContactListener target) {
		// TODO Auto-generated method stub
		
	}

}
