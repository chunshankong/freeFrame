package freeframe.utils;

import freeframe.system.Log;

public class Test {
	
	static class Obj{
		boolean isLive;
		String name;
		public Obj(String name,boolean isLive) {
			this.name = name;
			this.isLive = isLive;
		}
	}
	
	public static void main(String[] args) {
		
		MyArrayList<Obj> objs = new MyArrayList<>();
		objs.add(new Obj("子弹",true));
		objs.add(new Obj("坦克",true));
		objs.add(new Obj("飞机",true));
		
		for (Obj obj : objs) {
			Log.error(obj.name);
			objs.remove(obj);
		}
	 
		
	}

}
