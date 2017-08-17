package freeframe.test;

import freeframe.system.FreeFrame;

public class GameDemo extends FreeFrame {

	GameScene gameScene = null;
	LableScene lableScene = null;
	
	@Override
	public void init() {

		lableScene = new LableScene(500, 530, 300, 300,1);
		super.registerScene(lableScene);
		gameScene = new GameScene(0, 0, FreeFrame.WIDTH, FreeFrame.HEIGHT,1);
		super.registerScene(gameScene);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		gameScene.update();
	}

	long renderAccumilatedTime = 0;// 上次渲染的时间

	@Override
	public void render() {
//		long starttime = System.nanoTime();
//		starttime = starttime / 1000000;// 当前毫秒
//		if (33 <= (starttime - renderAccumilatedTime)) {// 每33ms绘制一帧图像
//			renderAccumilatedTime = starttime;
			
			gameScene.render();
			lableScene.render();
			
			if (null != gameScene)
				gameScene.update();
//			super.UpdateWindow();s
//		}
		

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	
}
