package freeframe.system;

public interface WindowsAPP {
	
	public static final int WM_CREATE = 100;
    public static final int WM_CLOSE  = 0;
    public static final int WM_TIMER = 1;
    public static final int WM_KEYDOWN = 2;
    public static final int WM_KEYUP = 3;
    public static final int WM_CHAR = 4;
    public static final int WM_LBUTTONDOWN = 5;
    public static final int WM_LBUTTONUP = 6;
    public static final int WM_MBUTTONDOWN = 7;
    public static final int WM_MBUTTONUP = 8;
    public static final int WM_RBUTTONDOWN = 9;
    public static final int WM_RBUTTONUP = 10;
    public static final int WM_MOUSEHOVER = 11;
    public static final int WM_MOUSELEAVE = 12;
    public static final int WM_MOUSEMOVE = 13;
    public static final int WM_MOUSEWHEEL = 14;
    public static final int WM_MOUSEDRAGGED = 15;
   
    /**
     * @author Administrator
     * @since dd
     * 内核会从该方法启动应用程序
     *@author: 杨思国
     *@since: 2016年4月13日上午10:43:31
     *@param windowsAPI
     *@param width
     *@param height
     */
    void WinMain(WindowsAPI windowsAPI,int width,int height,int fps);
    /**
     * 应用程序从消息队列获取消息后通知内核分发消息，内核会回调该方法给应用程序传入消息
     *@Author: 杨思国
     *@Since: 2016年4月13日上午10:44:24
     *@param msg
     *@return
     */
    int  WndProc(Msg msg);
    
}
