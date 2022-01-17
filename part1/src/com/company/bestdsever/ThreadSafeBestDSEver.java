package com.company.bestdsever;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Thread safe version of the BestDSEver
 * it follows proxy pattern
 *
 * @param <T> type of the object
 */
public class ThreadSafeBestDSEver<T> implements BestDSEver<T>  {

	private final BestDSEver<T> bestDSEver;

	ReadWriteLock lock = new ReentrantReadWriteLock();
	Lock writeLock = lock.writeLock();
	Lock readLock = lock.readLock();

	public ThreadSafeBestDSEver() {
		bestDSEver = new BestDSEverImpl<>();
	}


	public ThreadSafeBestDSEver(BestDSEver<T> bestDSEver) {
		this.bestDSEver = bestDSEver;
	}

	/**
	 * insert given element
	 *
	 * @param item will insert
	 */
	@Override
	public void insert(T item) {
		try {
			writeLock.lock();
			bestDSEver.insert(item);
		} finally {
			writeLock.unlock();
		}
	}

	/**
	 * remove given element from data structure
	 *
	 * @param item will remove
	 */
	@Override
	public void remove(T item) {
		try {
			writeLock.lock();
			bestDSEver.remove(item);
		} finally {
			writeLock.unlock();
		}
	}

	/**
	 * get element from given index
	 *
	 * @param index is index of element
	 * @return element at given index
	 */
	@Override
	public T get(int index) {
		try {
			readLock.lock();
			return bestDSEver.get(index);
		} finally {
			readLock.unlock();
		}
	}

	@Override
	public String toString() {
		try {
			readLock.lock();
			return bestDSEver.toString();
		} finally {
			readLock.unlock();
		}
	}
}
