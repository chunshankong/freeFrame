package freeframe.system;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

public abstract class FreeFrame implements WindowsAPP, GameAPP, EventListener {

	private WindowsAPI windows;

	public static int WIDTH = 0;
	public static int HEIGHT = 0;

	private static final int updateTimerId = 1;
	private static final int updateInterval = 10;// 毫秒/帧

	private ArrayList<Scene> scenes;// 框架所管理的场景

	private int fps;

	private long updateAccumilatedTime = 0;// 上次刷新的时间

	@Override
	public void WinMain(WindowsAPI windowsAPI, int width, int height,int fps) {

		scenes = new ArrayList<Scene>();
		FreeFrame.WIDTH = width;
		FreeFrame.HEIGHT = height;
		this.fps = fps;

		windows = windowsAPI;
		Msg msg = new Msg();
		// create window
		windows.CreateWindow(0, 0, WIDTH, HEIGHT);
		this.init();
		while (windows.PeekMessage(msg)) {
			if (null != msg.getMsgParam())windows.DispatchMessage(msg);
			long starttime = System.nanoTime();
			starttime = starttime / 1000000;// 当前毫秒
			if ((1000/fps) <= (starttime - updateAccumilatedTime)) {
				updateAccumilatedTime = starttime;

				this.update();
				this.render();
				UpdateWindow();
			}
		}
		this.destroy();
	}

	public void keyDown(int keyCode) {
		for (Scene scene : scenes) {
			scene.keyDown(keyCode);
		}
	}

	public void keyUp(int keyCode) {
		for (Scene scene : scenes) {
			scene.keyUp(keyCode);
		}
	}

	public void mouseLeftButtonDown(int x, int y) {
		for (Scene scene : scenes) {
			scene.mouseLeftButtonDown(x, y);
		}
	}

	public void mouseRightButtonDown(int x, int y) {
		for (Scene scene : scenes) {
			scene.mouseRightButtonDown(x, y);
		}
	}

	public void mouseMiddleButtonDown(int x, int y) {
		for (Scene scene : scenes) {
			scene.mouseMiddleButtonDown(x, y);
		}
	}

	public void mouseLeftButtonUp(int x, int y) {
		for (Scene scene : scenes) {
			scene.mouseLeftButtonUp(x, y);
		}
	}

	public void mouseRightButtonUp(int x, int y) {
		for (Scene scene : scenes) {
			scene.mouseRightButtonUp(x, y);

		}
	}

	public void mouseMiddleButtonUp(int x, int y) {
		for (Scene scene : scenes) {
			scene.mouseMiddleButtonUp(x, y);
		}
	}

	public void mouseHover(int x, int y) {
		for (Scene scene : scenes) {
			scene.mouseHover(x, y);
		}
	}

	public void mouseLeave(int x, int y) {
		for (Scene scene : scenes) {
			scene.mouseLeave(x, y);
		}
	}

	public void mouseWheel(int wheelRotation, int scrollAmount ) {
		for (Scene scene : scenes) {
			scene.mouseWheel(wheelRotation,scrollAmount);
		}
	}

	public void mouseMove(int x, int y) {
		for (Scene scene : scenes) {
			scene.mouseMove(x, y);
		}
	}

	public void mouseDragged(int x, int y) {
		for (Scene scene : scenes) {
			scene.mouseDragged(x, y);
		}
	}

	@Override
	public int WndProc(Msg msg) {
		// System.out.println(msg.getMsgParam().getCode());
		// windows.KillTimer(1);

		switch (msg.getMsgParam().getCode()) {
		case WM_CREATE: {
//			this.init();
			windows.SetTimer(updateTimerId, updateInterval);// 设置刷新帧率
			Log.info("Window was created");
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
			MouseWheelEvent me = (MouseWheelEvent) msg.getMsgParam().getEvent();
			mouseWheel(me.getWheelRotation(),me.getScrollAmount());
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

			// this.update();
			// this.render();
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
		scenes.add(scene);
	}

	public void destroy() {
		scenes.clear();
		windows.closeTimer();
		System.exit(0);
	}

}
