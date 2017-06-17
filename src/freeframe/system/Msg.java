package freeframe.system;

import java.awt.AWTEvent;

public class Msg {

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
   
    
    
    
    
    
    
    
    
    
    private MsgParam msgParam;
    
    public Msg(int code,AWTEvent event)
    {
    	msgParam = new MsgParam(code,event);
    }
    public Msg(){}
    
    public MsgParam getMsgParam() {
        return msgParam;
    }
    public void setMsgParam(MsgParam msgParam) {
        this.msgParam = msgParam;
    }
    public class MsgParam
    {
        private int code;
        private int timerId;
        private AWTEvent event;
        
        public MsgParam(int code, AWTEvent event) {
        	this.code = code;
        	this.event = event;
		}
		public int getCode() {
            return code;
        }
        public void setCode(int code) {
            this.code = code;
        }
        public int getTimerId() {
            return timerId;
        }
        public void setTimerId(int timerId) {
            this.timerId = timerId;
        }
		public AWTEvent getEvent() {
			return event;
		}
		public void setEvent(AWTEvent event) {
			this.event = event;
		}
        
    }
     

}
