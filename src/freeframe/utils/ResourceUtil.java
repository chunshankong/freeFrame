package freeframe.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceUtil {
	private static final StringBuffer ROOT_PATH = new StringBuffer("resource/");
	
	private static String getFullPath(String path){
		String fullPath = ROOT_PATH.append(path).toString();
		ROOT_PATH.delete(9, ROOT_PATH.length());
		return fullPath;
	}
	public static BufferedImage getImage(String path){
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(getFullPath(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	public static void main(String[] args) {
		getImage("image/bg.jpg");
	}

}
