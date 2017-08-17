package freeframe.system;

public final class Log {
 
	public static void info(Object obj) {
		System.out.println(obj);
	}

	public static void error(Object obj) {
		System.err.println(obj);
	}

}
