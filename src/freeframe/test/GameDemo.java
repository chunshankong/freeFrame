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
		gameScene.update();
	}
	@Override
	public void render() {
			gameScene.render();
			lableScene.render();
			gameScene.update();
	}
	@Override
	public void destroy() {
		super.destroy();
	}

	
}
