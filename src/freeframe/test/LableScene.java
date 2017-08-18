package freeframe.test;

import java.awt.Color;
import java.awt.Graphics2D;

import freeframe.system.Scene;

public class LableScene extends Scene {

	public LableScene(int x, int y, int width, int height, float alpha) {
		super(x, y, width, height, alpha);
	}

	@Override
	public void draw(Graphics2D g2d) {
		Color c = g2d.getColor();

		g2d.drawImage(GameScene.img, 0, 0, width, height, null);
		g2d.setColor(c);
	}

	@Override
	public void destroy() {

	}

}
