package freeframe.test;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import freeframe.system.GameObject;

public class Tank implements GameObject {

	private int width;
	private int height;
	private int x;
	private int y;

	public Tank(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.BLUE);
		g2d.fillRect(x, y, width, height);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.x += 1;
	}

	public void keyDown(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_LEFT: {
			this.x -= 10;
		}
			break;
		case KeyEvent.VK_RIGHT: {
			this.x += 10;
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

	public void mouseHover(int x, int y) {
		this.width = 200;
	}

	public void mouseLeave(int x, int y) {
		this.width = 300;
	}

	public void mouseDragged(int x, int y) {

		this.x = x;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
	public void mouseWheel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMove(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
