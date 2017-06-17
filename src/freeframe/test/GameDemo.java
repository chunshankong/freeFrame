package freeframe.test;

import freeframe.system.FreeFrame;
import freeframe.system.Log;
import freeframe.system.Scene;

public class GameDemo extends FreeFrame {

	GameScene gameScene = null;
	LableScene lableScene = null;
	MapScene mapScene = null;
	
	@Override
	public void init() {

		mapScene = new MapScene(500, 50, 300, 300, 1);
		super.registerScene(mapScene);
		lableScene = new LableScene(500, 300, 300, 200,1);
		super.registerScene(lableScene);
		gameScene = new GameScene(0, 0, FreeFrame.WIDTH, FreeFrame.HEIGHT,1);
		super.registerScene(gameScene);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	

	}

	long renderAccumilatedTime = 0;// 上次渲染的时间

	int zang = 0;
	@Override
	public void render() {
//		long starttime = System.nanoTime();
//		starttime = starttime / 1000000;// 当前毫秒
//		if (33 <= (starttime - renderAccumilatedTime)) {// 每33ms绘制一帧图像
//			renderAccumilatedTime = starttime;
			
			gameScene.render();
			lableScene.render();
			mapScene.render();
			
			if (null != gameScene)
				gameScene.update();
//			super.UpdateWindow();
			Log.info(++zang);
//		}
		

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub
		super.mouseDragged(x, y);
		Log.error("dragged y:  " + y);
		

	}

	@Override
	public void keyDown(int keyCode) {
		// TODO Auto-generated method stub
		super.keyDown(keyCode);
		gameScene.keyDown(keyCode);
		
	}
}
