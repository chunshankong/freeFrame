package freeframe.system;

import java.util.ArrayList;

public interface SceneFacade {
	
	/**
	 * 注册游戏对象
	 * @param gameObject
	 */
	void register(GameObject gameObject);
	void register(ArrayList<? extends GameObject> objs);
	
	/**
	 * 注销游戏对象
	 * @param gameObject
	 */
	void unregister(GameObject gameObject);
	void unregister(ArrayList<? extends GameObject> objs);
		 
}
