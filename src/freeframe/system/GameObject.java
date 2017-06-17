package freeframe.system;

import java.awt.Graphics2D;

public interface GameObject extends EventListener {
	
	/**
	 * 绘制
	 * @param g2d
	 */
	public void draw(Graphics2D g2d);
	/**
	 * 更新数据
	 */
	public void update();

	/**
	 * 销毁游戏资源
	 */
	public void destroy();
}
