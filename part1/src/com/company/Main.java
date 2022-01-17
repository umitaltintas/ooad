package com.company;

import com.company.bestdsever.ThreadSafeBestDSEver;

import java.time.temporal.ValueRange;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		ThreadSafeBestDSEver<Integer> bestDSEver = new ThreadSafeBestDSEver<>();
		Thread thread1 = new Thread(() -> {

			for (int i = 0; i < 200; i++) {
				bestDSEver.insert(i);
				System.out.println("inserting: " + i);

			}


		});
		Thread thread2 = new Thread(() -> {

			for (int i = 0; i < 200; i++) {
				bestDSEver.remove(i);
				System.out.println("removing: " + i);
			}

		});

		thread2.start();
		thread1.start();
		try {
			thread1.join();
			thread2.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println(bestDSEver); // cause of the iterator we can print it this way

		}

	}
}
