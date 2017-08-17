package freeframe.system;

import java.awt.Rectangle;

public abstract class AbstractGameObject implements GameObject{
	
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	
	protected SceneFacade sceneFacade;
	protected boolean live = true;
	
	
	public AbstractGameObject(int x, int y, int width, int height,SceneFacade sceneFacade) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		setSceneFacade(sceneFacade);
		sceneFacade.register(this);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		sceneFacade.unregister(this);
	}

	@Override
	public Rectangle getBody() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, width, height);
	}

	@Override
	public void setSceneFacade(SceneFacade sceneFacade) {
		// TODO Auto-generated method stub
		this.sceneFacade = sceneFacade;
	}
	
	@Override
	public boolean isLive() {
		// TODO Auto-generated method stub
		return live;
	}

}
