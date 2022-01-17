package com.company.bestdsever;

import java.util.ArrayList;
import java.util.List;

/**
 * class that written by old developer
 *
 * @param <T> type of the elements
 */
public class BestDSEverImpl<T> implements BestDSEver<T> {

	List<T> bdse;

	public BestDSEverImpl() {
		bdse = new ArrayList<>();
	}


	/**
	 * insert given element
	 *
	 * @param item will insert
	 */
	@Override
	public void insert(T item) {
		bdse.add(item);
	}

	/**
	 * remove given element from data structure
	 *
	 * @param item will removed
	 */
	@Override
	public void remove(T item) {
		bdse.remove(item);
	}

	/**
	 * get element from given index
	 *
	 * @param index is index of element
	 * @return element at given index
	 */
	@Override
	public T get(int index) {
		return bdse.get(index);
	}

	@Override
	public String toString() {
		return bdse.toString();
	}
}
