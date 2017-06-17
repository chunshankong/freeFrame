package freeframe.utils;

import java.awt.Point;
import java.awt.Rectangle;

public class CollisionDetectionUtil {

	public static boolean collided(Rectangle r1, Rectangle r2)
	{
		if (r1.intersects(r2))
			return true;
		return false;
	}
	public static boolean containsPoint(Rectangle r ,Point p){
		return r.contains(p);
	}

}