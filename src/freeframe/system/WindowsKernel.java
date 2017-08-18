package freeframe.system;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WindowsKernel extends JFrame implements WindowsAPI {

	private static final long serialVersionUID = 5302623751843434154L;

	/**
	 * 装入内核的应用程序
	 */
	private WindowsAPP app;
	
	private int fps;

	/**
	 * 窗口消息队列
	 */
	private Queue<Msg> queue;

	private ScheduledExecutorService timerExecutor;
	private Map<Integer, TimerEchoServer> timerMap;
	private JPanel contentPanel = null;

	private int windowWidth;
	private int windowHeight;
	private int windowX;
	private int windowY;

	private boolean exitWindow = false;

	/* ******** Kernel *********** */
	public WindowsKernel() {
		queue = new LinkedList<Msg>();
		timerExecutor = Executors.newScheduledThreadPool(1);
		timerMap = new HashMap<Integer, TimerEchoServer>();
	}

	public void putWndQueue(Msg msg) {
		queue.add(msg);
	}

	public void registerScene(Scene scene) {
		contentPanel.add(scene);
		this.setVisible(true);
	}

	public void CreateWindow(int x, int y, int width, int height) {
		this.windowX = x;
		this.windowY = y;
		this.windowWidth = width;
		this.windowHeight = height;

		this.contentPanel = (JPanel) this.getContentPane();
		// this.setContentPane(contentPanel);

		this.setBounds(windowX, windowY, windowWidth, windowHeight);

		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				exitWindow = true;
				putWndQueue(new Msg(Msg.WM_CLOSE, e));
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				putWndQueue(new Msg(Msg.WM_KEYUP, e));
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				putWndQueue(new Msg(Msg.WM_KEYDOWN, e));
			}
		});
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if ((e.getButton()) == MouseEvent.BUTTON1) {
					putWndQueue(new Msg(Msg.WM_LBUTTONUP, e));
				}
				if ((e.getButton()) == MouseEvent.BUTTON2) {
					putWndQueue(new Msg(Msg.WM_MBUTTONUP, e));
				}
				if ((e.getButton()) == MouseEvent.BUTTON3) {
					putWndQueue(new Msg(Msg.WM_RBUTTONUP, e));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {

				if ((e.getButton()) == MouseEvent.BUTTON1) {
					putWndQueue(new Msg(Msg.WM_LBUTTONDOWN, e));
				}
				if ((e.getButton()) == MouseEvent.BUTTON2) {
					putWndQueue(new Msg(Msg.WM_MBUTTONDOWN, e));
				}
				if ((e.getButton()) == MouseEvent.BUTTON3) {
					putWndQueue(new Msg(Msg.WM_RBUTTONDOWN, e));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				putWndQueue(new Msg(Msg.WM_MOUSELEAVE, e));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				putWndQueue(new Msg(Msg.WM_MOUSEHOVER, e));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				putWndQueue(new Msg(Msg.WM_MOUSEMOVE, e));
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				putWndQueue(new Msg(Msg.WM_MOUSEDRAGGED, e));
			}
		});
		this.addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				// TODO Auto-generated method stub
				putWndQueue(new Msg(Msg.WM_MOUSEWHEEL, e));
			}
		});
		this.setVisible(true);
		putWndQueue(new Msg(Msg.WM_CREATE, null));
	}

	/* **********load************** */
	/**
	 * 以指定的窗口大小运行游戏客户端
	 * 
	 * @param windowsAPP
	 * @param width
	 * @param height
	 */
	public void runApp(WindowsAPP windowsAPP, int width, int height,int fps) {
		this.fps = fps;
		if (300 < fps) {
			JOptionPane.showMessageDialog(null, "fps too high!");
			throw new RuntimeException("fps too high!");
		}
		this.app = windowsAPP;
		this.app.WinMain(this, width, height);
	}

	long updateAccumilatedTime = 0;// 上次刷新的时间
	boolean isStart=false;
	/* ******** Message *********** */
	public boolean GetMsg(Msg msg) {
		Msg wmsg = null;
		while (true) {
			
			long starttime = System.nanoTime();
			starttime = starttime / 1000000;// 当前毫秒
			if ((1000/fps) <= (starttime - updateAccumilatedTime)) {
				updateAccumilatedTime = starttime;
				
				if (!isStart) {
					new Thread(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							while(true){
								try {
									Thread.sleep(30);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								GameAPP gameAPP = (GameAPP) app;
								gameAPP.update();
								gameAPP.render();
								UpdateWindow();
							}
						}
					}).start();
					isStart = true;
				}
				
				/*SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						GameAPP gameAPP = (GameAPP) app;
						gameAPP.update();
						gameAPP.render();
						UpdateWindow();
					}
				});*/
			}
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (null != (wmsg = queue.poll())) {
				break;
			}
		}
		msg.setMsgParam(wmsg.getMsgParam());
		if (Msg.WM_CLOSE == msg.getMsgParam().getCode())
			return false;

		if (exitWindow)
			return false;

		return true;
	}

	public int DispatchMessage(Msg msg) {
		app.WndProc(msg);
		return 0;
	}

	/* ******** paint *********** */
	public void UpdateWindow() {
		this.repaint();
	}

	/* ******** Timer *********** */
	public void SetTimer(int id, int interval) {
		TimerEchoServer ts = new TimerEchoServer(id, interval);
		timerMap.put(id, ts);
		timerExecutor.scheduleAtFixedRate(ts, interval, interval, TimeUnit.MILLISECONDS);
	}

	public void closeTimer() {
		timerExecutor.shutdown();
		Log.error("Timer is Shutdown : " + timerExecutor.isShutdown());
	}

	public void KillTimer(int id) {
		timerMap.remove(id);
	}

	class TimerEchoServer implements Runnable {
		private int id;
		private int interval;

		@Override
		public void run() {
			if (null == timerMap.get(this.id)) {
				throw new RuntimeException("this timer is killed");
			}
			Msg msg = new Msg(Msg.WM_TIMER, null);
			msg.getMsgParam().setTimerId(this.id);
			putWndQueue(msg);
		}

		public TimerEchoServer(int id, int interval) {
			this.id = id;
			this.interval = interval;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getInterval() {
			return interval;
		}

		public void setInterval(int interval) {
			this.interval = interval;
		}
	}

}
