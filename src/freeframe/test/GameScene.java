package freeframe.test;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import freeframe.system.GameObject;
import freeframe.system.Scene;

public class GameScene extends Scene {

	private static final long serialVersionUID = 1L;

	ArrayList<GameObject> objs = null;
	BgLable bg = null;
	Tank tank = null;
	public GameScene(int x, int y, int width, int height,float alpha) {
		super(x, y, width, height,alpha);
		// TODO Auto-generated constructor stub
		objs = new ArrayList<GameObject>();
		FpsLabel fps = new FpsLabel();
		tank = new Tank(50, 50, 100, 100);
		objs.add(fps);
		objs.add(tank);
		Missile m = new Missile(100, 100, 1, Direction.R);
		Missile m2 = new Missile(150, 200, 1, Direction.R);
		Missile m3 = new Missile(200, 300, 1, Direction.R);
		objs.add(m);
		objs.add(m2);
		objs.add(m3);
		Explode explode = new Explode(100, 300);
		objs.add(explode);
		bg = new BgLable(0, 0, width, height);
	}

	static BufferedImage img ;
	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		Color c = g2d.getColor();
		
		img = getImage();
		
		bg.draw(g2d);

		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));// 透明度
		// draw spirit
		for (GameObject obj : objs) {
			obj.draw(g2d);
		}

		g2d.setColor(c);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		for (GameObject obj : objs) {
			obj.update();
		}
		bg.update();
	}

@Override
public void keyDown(int keyCode) {
	// TODO Auto-generated method stub
	super.keyDown(keyCode);
	tank.keyDown(keyCode);
}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
