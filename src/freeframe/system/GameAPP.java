package freeframe.system;

public interface GameAPP {

	/**
	 * 初始化游戏资源及场景
	 */
	void init();

	/**
	 * 更新游戏数据
	 */
	void update();
	/**
	 * 渲染游戏画面
	 */
	void render();

	/**
	 * 销毁游戏资源
	 */
	void destroy();

	
}
