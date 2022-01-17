package com.company.bestdsever;

/**
 * Interface that how to use the best data structure ever class.
 *  @param <T> type of the elements
 */
public interface BestDSEver<T> {
	/**
	 * insert given element
	 *
	 * @param item will insert
	 */
	void insert(T item);

	/**
	 * remove given element from data structure
	 *
	 * @param item will removed
	 */
	void remove(T item);

	/**
	 * get element from given index
	 *
	 * @param index is index of element
	 * @return element at given index
	 */
	T get(int index);


}
