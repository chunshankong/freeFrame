package freeframe.dnf;

import freeframe.system.WindowsKernel;

public class Main {

	public static void main(String[] args) {
		
		new WindowsKernel().runApp(new Game(), 800, 600, 30);
	}
}
