package freeframe.system;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

public abstract class Scene extends JPanel implements GameObject,EventListener,SceneFacade{

	private static final long serialVersionUID = 1L;
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	private float alpha = 1;
	private ArrayList<GameObject> gameObjects = null;// 场景管理的游戏对象
	private ArrayList<KeyEventListener> keyEventListeners = null;
	private ArrayList<MouseEventListener> mouseEventListeners = null;
	private ArrayList<ContactListener> contactListeners = null;
	
	private HashMap<ContactListener, ArrayList<ContactListener>> contactMap = null;
	
	public Scene(int x, int y, int width, int height, float alpha) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.alpha = alpha;
		this.gameObjects = new ArrayList<GameObject>();
		this.keyEventListeners = new ArrayList<KeyEventListener>();
		this.mouseEventListeners = new ArrayList<MouseEventListener>();
		this.contactListeners = new ArrayList<ContactListener>();
		
		this.contactMap = new HashMap<ContactListener, ArrayList<ContactListener>>();
	}

	public Scene(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.gameObjects = new ArrayList<GameObject>();
		this.keyEventListeners = new ArrayList<KeyEventListener>();
		this.mouseEventListeners = new ArrayList<MouseEventListener>();
		this.contactListeners = new ArrayList<ContactListener>();
		
		this.contactMap = new HashMap<ContactListener, ArrayList<ContactListener>>();
	}

	private BufferedImage bufImg = null;

	protected BufferedImage getImage() {
		return bufImg;
	}

	protected void paintComponent(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;

		if (1 != alpha) {
			graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));// 透明度
		}
		graphics2d.drawImage(this.bufImg, this.x, this.y, null);
		// graphics2d.setComposite(AlphaComposite.DstIn);
		// graphics2d.fillRect(this.x, this.y, width, height);
	}

	public Graphics2D GetWindowGraphics() {

		if (null == bufImg) {
			bufImg = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
		}
		return bufImg.createGraphics();
	}
	
	@Override
	public void setSceneFacade(SceneFacade sceneFacade) {
		// TODO Auto-generated method stub
	}
	
	private void addListener(GameObject gameObject){
		if (gameObject instanceof KeyEventListener) {
			keyEventListeners.add((KeyEventListener) gameObject);
		}
		if (gameObject instanceof MouseEventListener) {
			mouseEventListeners.add((MouseEventListener) gameObject);
		}
		if (gameObject instanceof ContactListener) {
			contactListeners.add((ContactListener) gameObject);
			contactMap.put((ContactListener) gameObject, new ArrayList<ContactListener>());
		}
	}
	private void removeListener(GameObject gameObject){
		if (gameObject instanceof KeyEventListener) {
			keyEventListeners.remove(gameObject);
		}
		if (gameObject instanceof MouseEventListener) {
			mouseEventListeners.remove(gameObject);
		}
		if (gameObject instanceof ContactListener) {
			contactListeners.remove(gameObject);
			contactMap.remove(gameObject);
		}
		Log.info("对象移除");
	}
	
	@Override
	public void register(GameObject gameObject) {
		gameObjects.add(gameObject);
		addListener(gameObject);
	}
	@Override
	public void register(ArrayList<? extends GameObject> objs) {
		gameObjects.addAll(objs);
		for (GameObject gameObject : objs) {
			addListener(gameObject);
		}
	}
	@Override
	public void unregister(GameObject gameObject) {
		gameObjects.remove(gameObject);
		removeListener(gameObject);
	}
	@Override
	public void unregister(ArrayList<? extends GameObject> objs) {
		gameObjects.removeAll(objs);
		for (GameObject gameObject : objs) {
			removeListener(gameObject);
		}
	}
	
	@Override
	public void keyDown(int keyCode) { 
		for (KeyEventListener keyEventListener : keyEventListeners) {
			keyEventListener.keyDown(keyCode);
		}
	}

	@Override
	public void keyUp(int keyCode) {
		for (KeyEventListener keyEventListener : keyEventListeners) {
			keyEventListener.keyUp(keyCode);
		}
	}

	@Override
	public void mouseLeftButtonDown(int x, int y) {
		for (MouseEventListener mouseEventListener : mouseEventListeners) {
			mouseEventListener.mouseLeftButtonDown(x, y);
		}
	}

	@Override
	public void mouseRightButtonDown(int x, int y) {
		for (MouseEventListener mouseEventListener : mouseEventListeners) {
			mouseEventListener.mouseRightButtonDown(x, y);
		}
	}

	@Override
	public void mouseMiddleButtonDown(int x, int y) {
		for (MouseEventListener mouseEventListener : mouseEventListeners) {
			mouseEventListener.mouseMiddleButtonDown(x, y);
		}
	}

	@Override
	public void mouseLeftButtonUp(int x, int y) {
		for (MouseEventListener mouseEventListener : mouseEventListeners) {
			mouseEventListener.mouseLeftButtonUp(x, y);
		}
	}

	@Override
	public void mouseRightButtonUp(int x, int y) {
		for (MouseEventListener mouseEventListener : mouseEventListeners) {
			mouseEventListener.mouseRightButtonUp(x, y);
		}
	}

	@Override
	public void mouseMiddleButtonUp(int x, int y) {
		for (MouseEventListener mouseEventListener : mouseEventListeners) {
			mouseEventListener.mouseMiddleButtonUp(x, y);
		}
	}

	@Override
	public void mouseHover(int x, int y) {
		for (MouseEventListener mouseEventListener : mouseEventListeners) {
			mouseEventListener.mouseHover(x, y);
		}
	}

	@Override
	public void mouseLeave(int x, int y) {
		for (MouseEventListener mouseEventListener : mouseEventListeners) {
			mouseEventListener.mouseLeave(x, y);
		}
	}

	@Override
	public void mouseWheel(int wheelRotation, int scrollAmount) {
		for (MouseEventListener mouseEventListener : mouseEventListeners) {
			mouseEventListener.mouseWheel(wheelRotation,scrollAmount);
		}
	}

	@Override
	public void mouseMove(int x, int y) {
		for (MouseEventListener mouseEventListener : mouseEventListeners) {
			mouseEventListener.mouseMove(x, y);
		}
	}

	@Override
	public void mouseDragged(int x, int y) {
		for (MouseEventListener mouseEventListener : mouseEventListeners) {
			mouseEventListener.mouseDragged(x, y);
		}
	}
	
	@Override
	public Rectangle getBody() {
		return new Rectangle(x, y, width, height);
	}

	public void render() {
		Graphics2D graphics2d = this.GetWindowGraphics();
		Color color = graphics2d.getColor();
		this.draw(graphics2d);
		graphics2d.setColor(color);
	}

	/**
	 * 碰撞检测回调
	 */
	private void collisionDetection() {
		for (ContactListener contactListener : contactListeners) {
			for (ContactListener contactListener2 : contactListeners) {
				if (contactListener != contactListener2) {
					ArrayList<ContactListener> contacteds = contactMap.get(contactListener);
					if (contacteds.contains(contactListener2)) {
						if (contactListener.getBody().intersects(contactListener2.getBody())) {
							contactListener.beginContact(contactListener2);
						} else {
							contactListener.endContact(contactListener2);
							contacteds.remove(contactListener2);
						}
					} else {
						if (contactListener.getBody().intersects(contactListener2.getBody())) {
							contactListener.beginContact(contactListener2);
							contacteds.add(contactListener2);
						} else {
						}
					}

				}
			}
		}
	}
	/**
	 * 碰撞检测回调
	 */
	private void collisionDetection2() {
		for(int i = 0;i<contactListeners.size();i++){
			ContactListener contactListener = contactListeners.get(i);
			for(int j = 0;j<contactListeners.size();j++){
				ContactListener contactListener2 = contactListeners.get(j);
				if (contactListener != contactListener2) {
					ArrayList<ContactListener> contacteds = contactMap.get(contactListener);
					if (contacteds == null) {
						continue;
					}
					if (contacteds.contains(contactListener2)) {
						if (contactListener.getBody().intersects(contactListener2.getBody())) {
							contactListener.beginContact(contactListener2);
						} else {
							contactListener.endContact(contactListener2);
							contacteds.remove(contactListener2);
						}
					} else {
						if (contactListener.getBody().intersects(contactListener2.getBody())) {
							contactListener.beginContact(contactListener2);
							contacteds.add(contactListener2);
						} else {
						}
					}

				}
			}
		}
		 
	}
	public void update(){
		
		collisionDetection2();
		for (GameObject gameObject : gameObjects) {
			gameObject.update();
		}
	}
	
	@Override
	public boolean isLive() {
		return true;
	}
	
	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return new Point(x, y);
	}

}
