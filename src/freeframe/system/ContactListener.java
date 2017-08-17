package freeframe.system;

import java.awt.Rectangle;

/**
 * 碰撞监听者
 * @author yang siguo
 *
 */
public interface ContactListener {

	/**
	 * 发生碰撞
	 * @param target 碰撞到的另一个监听者 
	 */
	void beginContact(ContactListener target);
	
	void endContact(ContactListener target);
	
	/**
	 * 获取自身主体矩形
	 * @return
	 */
	Rectangle getBody();
 
}
