package freeframe.test;

import java.awt.Color;
import java.awt.Graphics2D;

import freeframe.system.FreeFrame;
import freeframe.system.GameObject;

public class Missile implements GameObject {

	private int x;
	private int y;

	private int speed;
	private Direction dir;

	Missile(int x, int y, int speed, Direction dir) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.dir = dir;

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
	public void mouseLeftButtonDown(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseRightButtonDown(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMiddleButtonDown(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseLeftButtonUp(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseRightButtonUp(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMiddleButtonUp(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseHover(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseLeave(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseWheel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMove(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		Color c = g2d.getColor();
		g2d.setColor(Color.RED);
		g2d.fillOval(x, y, 10, 10);
		g2d.setColor(c);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		switch (dir) {
		case L: {
			x -= speed;
			if (0 >= x) {
				dir = Direction.R;
			}
		}
			break;
		case T: {
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

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
