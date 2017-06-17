package freeframe.system;

public interface EventListener {

	void keyDown(int keyCode);

	void keyUp(int keyCode);

	public void mouseLeftButtonDown(int x, int y);

	public void mouseRightButtonDown(int x, int y);

	public void mouseMiddleButtonDown(int x, int y);

	public void mouseLeftButtonUp(int x, int y);

	public void mouseRightButtonUp(int x, int y);

	public void mouseMiddleButtonUp(int x, int y);

	public void mouseHover(int x, int y);

	public void mouseLeave(int x, int y);

	public void mouseWheel();

	public void mouseMove(int x, int y);

	public void mouseDragged(int x, int y);

}
