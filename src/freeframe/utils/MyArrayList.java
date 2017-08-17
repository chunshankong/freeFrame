package freeframe.utils;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

import freeframe.test.Missile;

public class MyArrayList<E> extends ArrayList<E> {

	public void delete(Object object){
		iteratorDelete(object);
	}
	
	public void iteratorDelete(Object object) {
		Iterator it = this.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			if (obj == object) {
				it.remove();
			}
		}
	}
	 
	
}
