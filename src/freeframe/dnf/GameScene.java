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

	BgLable bgLable;

	public GameScene(int x, int y, int width, int height) {
		super(x, y, width, height);
		fpsLabel = new FpsLabel();
		bgLable = new BgLable(0,0,FreeFrame.WIDTH,FreeFrame.HEIGHT,this);
		blanka = new Blanka(20, 350, 200, 200, this);
		hero = new Hero(300,350, 200, 200, this);
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.fillRect(0, 0, FreeFrame.WIDTH, FreeFrame.HEIGHT);

		bgLable.draw(g2d);
		fpsLabel.draw(g2d);
		blanka.draw(g2d);
		hero.draw(g2d);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
