package freeframe.system;

import java.awt.Rectangle;

/**
 * 碰撞监听者
 * @author siguo yang
 *
 */
public interface ContactListener {

	/**
	 * 发生碰撞
	 * @param target 碰撞到的另一个监听者 
	 */
	void beginContact(ContactListener target);
	
	/**
	 * 离开碰撞的对象
	 * @param target 碰撞到的另一个监听者 
	 */
	void endContact(ContactListener target);
	
	/**
	 * 获取自身主体矩形
	 * @return
	 */
	Rectangle getBody();
 
}
