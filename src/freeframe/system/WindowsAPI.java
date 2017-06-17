package freeframe.system;

public interface WindowsAPI {
    
    void CreateWindow(int x,int y,int width,int height);
    void UpdateWindow();
    void registerScene(Scene scene);
    boolean GetMsg(Msg msg);
    int DispatchMessage(Msg msg);
    void SetTimer(int id,int interval);
    void KillTimer(int id);
    void closeTimer();
    
    void runApp(WindowsAPP windowsAPP, int width, int height,int fps);
    
}
