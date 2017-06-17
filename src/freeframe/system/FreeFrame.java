package freeframe.system;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

public abstract class FreeFrame implements WindowsAPP, GameAPP, EventListener {

	private WindowsAPI windows;

	public static int WIDTH = 0;
	public static int HEIGHT = 0;

	private static final int updateTimerId = 1;
	private static final int updateInterval = 10;// 毫秒/帧

	@Override
	public void WinMain(WindowsAPI windowsAPI, int width, int height) {
		FreeFrame.WIDTH = width;
		FreeFrame.HEIGHT = height;

		windows = windowsAPI;
		Msg msg = new Msg();
		// create window
		windows.CreateWindow(0, 0, WIDTH, HEIGHT);

		while (windows.GetMsg(msg)) {
			windows.DispatchMessage(msg);
		}
		this.destroy();
	}

	public void keyDown(int keyCode) {
		// Log.error("down:"+keyCode);
	}

	public void keyUp(int keyCode) {
		// Log.error("up:"+keyCode);

	}

	public void mouseLeftButtonDown(int x, int y) {

	}

	public void mouseRightButtonDown(int x, int y) {

	}

	public void mouseMiddleButtonDown(int x, int y) {

	}

	public void mouseLeftButtonUp(int x, int y) {

	}

	public void mouseRightButtonUp(int x, int y) {

	}

	public void mouseMiddleButtonUp(int x, int y) {

	}

	public void mouseHover(int x, int y) {

	}

	public void mouseLeave(int x, int y) {

	}

	public void mouseWheel() {

	}

	public void mouseMove(int x, int y) {

	}

	public void mouseDragged(int x, int y) {

	}

	@Override
	public int WndProc(Msg msg) {
		// System.out.println(msg.getMsgParam().getCode());
		// windows.KillTimer(1);

		switch (msg.getMsgParam().getCode()) {
		case WM_CREATE: {
			this.init();
			windows.SetTimer(updateTimerId, updateInterval);// 设置刷新帧率
			Log.error("Window was created");
		}
			break;
		case WM_KEYDOWN: {
			KeyEvent ke = (KeyEvent) msg.getMsgParam().getEvent();
			this.keyDown(ke.getKeyCode());
		}
			break;
		case WM_KEYUP: {
			KeyEvent ke = (KeyEvent) msg.getMsgParam().getEvent();
			this.keyUp(ke.getKeyCode());
		}
			break;
		case WM_LBUTTONDOWN: {
			MouseEvent me = (MouseEvent) msg.getMsgParam().getEvent();
			mouseLeftButtonDown(me.getX(), me.getY());
		}
			break;
		case WM_LBUTTONUP: {
			MouseEvent me = (MouseEvent) msg.getMsgParam().getEvent();
			mouseLeftButtonUp(me.getX(), me.getY());
		}
			break;
		case WM_MBUTTONDOWN: {
			MouseEvent me = (MouseEvent) msg.getMsgParam().getEvent();
			mouseMiddleButtonDown(me.getX(), me.getY());
		}
			break;
		case WM_MBUTTONUP: {
			MouseEvent me = (MouseEvent) msg.getMsgParam().getEvent();
			mouseMiddleButtonUp(me.getX(), me.getY());
		}
			break;
		case WM_RBUTTONDOWN: {
			MouseEvent me = (MouseEvent) msg.getMsgParam().getEvent();
			mouseRightButtonDown(me.getX(), me.getY());
		}
			break;
		case WM_RBUTTONUP: {
			MouseEvent me = (MouseEvent) msg.getMsgParam().getEvent();
			mouseRightButtonUp(me.getX(), me.getY());
		}
			break;
		case WM_MOUSEHOVER: {
			MouseEvent me = (MouseEvent) msg.getMsgParam().getEvent();
			mouseHover(me.getX(), me.getY());
		}
			break;
		case WM_MOUSELEAVE: {
			MouseEvent me = (MouseEvent) msg.getMsgParam().getEvent();
			mouseLeave(me.getX(), me.getY());
		}
			break;
		case WM_MOUSEWHEEL: {

		}
			break;
		case WM_MOUSEMOVE: {
			MouseEvent me = (MouseEvent) msg.getMsgParam().getEvent();
			mouseMove(me.getX(), me.getY());
		}
			break;
		case WM_MOUSEDRAGGED: {
			MouseEvent me = (MouseEvent) msg.getMsgParam().getEvent();
			mouseDragged(me.getX(), me.getY());
		}
			break;
		case WM_TIMER: {
			
//			this.update();
//			this.render();
		}
			break;
		default:
			return 0;
		}
		return 0;
	}

	protected void UpdateWindow() {
		windows.UpdateWindow();
	}

	protected void registerScene(Scene scene) {
		windows.registerScene(scene);
	}

	public void destroy() {
		windows.closeTimer();
		System.exit(0);
	}

}
