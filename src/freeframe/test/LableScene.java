package freeframe.test;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import freeframe.system.Scene;
import freeframe.utils.ResourceUtil;

public class LableScene extends Scene{
 
	private static final long serialVersionUID = 1L;

	BufferedImage img = null;
	
	public LableScene(int x, int y, int width, int height,float alpha) {
		super(x, y, width, height,alpha);
		// TODO Auto-generated constructor stub
		
		img = ResourceUtil.getImage("image/explode/10.gif");
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		Color c = g2d.getColor();
		
//		g2d.setColor(Color.RED);
//		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));//透明度
//		g2d.fillRect(0, 0, width, height);
//		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));//透明度
//		g2d.drawImage(img, 0, 0, null);
//		g2d.setColor(Color.DARK_GRAY);
//		g2d.fillRect(0, 0, width, height);
//		g2d.setFont(new Font("", 20, 30));
//		g2d.setColor(Color.WHITE);
//		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));//透明度
//		g2d.drawString("开始游戏", 30, 30);
		
	g2d.drawImage(GameScene.img, 0, 0, null);
		g2d.setColor(c);
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
