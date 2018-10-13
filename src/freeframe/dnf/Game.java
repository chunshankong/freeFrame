package freeframe.dnf;

import freeframe.system.FreeFrame;

public class Game extends FreeFrame{

	GameScene gameScene = null;
	
	@Override
	public void init() {
		gameScene = new GameScene(0, 0, FreeFrame.WIDTH	, FreeFrame.HEIGHT);
		super.registerScene(gameScene);
	}

	@Override
	public void update() {
		gameScene.update();
	}

	@Override
	public void render() {
		gameScene.render();
	}

}
