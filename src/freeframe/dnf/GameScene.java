package freeframe.dnf;

import java.awt.Graphics2D;

import freeframe.system.FreeFrame;
import freeframe.system.Scene;
import freeframe.test.FpsLabel;

public class GameScene extends Scene{
 
	private static final long serialVersionUID = 1L;
	
	FpsLabel fpsLabel = null;
	Blanka blanka = null;
	Hero hero = null;

	public GameScene(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		fpsLabel = new FpsLabel();
		blanka = new Blanka(20, 20, 200, 200, this);
		hero = new Hero(300,20, 200, 200, this);
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.fillRect(0, 0, FreeFrame.WIDTH, FreeFrame.HEIGHT);
		
		fpsLabel.draw(g2d);
		blanka.draw(g2d);
		hero.draw(g2d);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
