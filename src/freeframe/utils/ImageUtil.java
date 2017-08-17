package freeframe.utils;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageUtil {

	public static BufferedImage flipHorizontal(BufferedImage img) {
		AffineTransform transform = new AffineTransform();
		transform.scale(-1, 1);
		transform.translate((double) -img.getWidth(), (double) 1);

		AffineTransformOp affineTransformOp = new AffineTransformOp(transform,
				null);
		return affineTransformOp.filter(img, null);
	}

	public static BufferedImage flipVertical(BufferedImage img) {
		AffineTransform transform = new AffineTransform();
		transform.scale(1, -1);
		transform.translate((double) 1, (double) -img.getHeight());

		AffineTransformOp affineTransformOp = new AffineTransformOp(transform,
				null);
		return affineTransformOp.filter(img, null);
	}
	
	public static void main(String[] args) throws IOException {
		
		final BufferedImage image = ImageIO.read(new File("resource/image/xys8.png"));
		final JFrame frame = new JFrame();
		final Animation animation = new Animation();
		final BufferedImage[][] images = split(image, 8, 8);
		animation.setKeyFrames(images[5]);
		animation.setDuration(100);
		
		frame.setBounds(10, 10, 300, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				Graphics2D g2d = (Graphics2D) g;

				BufferedImage region = animation.getKeyFrame();
				
				region = flipHorizontal(region);
				
				g2d.drawImage(region, 10, 200, null);

				g2d.drawRect(0, 0, image.getWidth(), image.getHeight());
			
			}
		});
		frame.setVisible(true);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				
				while(true){
					frame.repaint();
					// TODO Auto-generated method stub
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			}
		}).start();

	}

	public static BufferedImage[][] split(BufferedImage image, int row,
			int column) {
		if (0 >= row || 0 >= column) {
			throw new IllegalArgumentException("非法的行或列数");
		}
		BufferedImage[][] images = new BufferedImage[row][column];
		int width = image.getWidth() / column;
		int height = image.getHeight() / row;
		int x = 0, y = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				images[i][j] = image.getSubimage(x, y, width, height);
				x += width;
			}
			x = 0;
			y += height;
		}
		return images;
	}
	

}
