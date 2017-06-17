package freeframe.system;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import freeframe.test.LableScene;
import freeframe.utils.ResourceUtil;

public abstract class Scene extends JPanel implements GameObject {

	private static final long serialVersionUID = 1L;
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	private float alpha = 1;

	public Scene(int x, int y, int width, int height, float alpha) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.alpha = alpha;
	}
	public Scene(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	private BufferedImage bufImg = null;

	protected BufferedImage getImage(){
		return bufImg;
	}
	protected void paintComponent(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;

		if (1 != alpha) {
			graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));// 透明度
		}
		graphics2d.drawImage(this.bufImg, this.x, this.y, null);
		// graphics2d.setComposite(AlphaComposite.DstIn);
		// graphics2d.fillRect(this.x, this.y, width, height);
	}

	public Graphics2D GetWindowGraphics() {

		if (null == bufImg) {
			bufImg = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
		}
		return bufImg.createGraphics();
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

	public void render() {
		this.draw(this.GetWindowGraphics());
	}

}
