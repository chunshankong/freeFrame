package freeframe.test;

import freeframe.system.WindowsKernel;

public class TestMain {

 
    public static void main(String[] args) {
    	WindowsKernel windowsKernel = new WindowsKernel();
        windowsKernel.runApp(new GameDemo(),1000,900,30);
    }
    
    
}
