package freeframe.system;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public interface GameObject {
	/**
	 * 绘制
	 * @param g2d
	 */
	void draw(Graphics2D g2d);

	/**
	 * 更新数据
	 */
	void update();

	/**
	 * 销毁游戏资源
	 */
	void destroy();

	/**
	 * 获取自身主体矩形
	 * @return
	 */
	Rectangle getBody();

	/**
	 * 设置自身所处的场景对象
	 * @param sceneFacade
	 */
	void setSceneFacade(SceneFacade sceneFacade);

	/**
	 * 是否存在
	 * @return
	 */
	boolean isLive();
}
