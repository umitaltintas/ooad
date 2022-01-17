import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

/**
 * calculate dft by using mutex
 */
public class MutexDFT implements DFTStrategy {
	ReentrantLock mutex = new ReentrantLock();

	/**
	 * calculate dft
	 *
	 * @param input1 A
	 * @param input2 B
	 * @param output dft(A+B)
	 */
	@Override
	public void calculateDFT(Complex[][] input1, Complex[][] input2, Complex[][] output) {
		var size = input1.length;
		var sum = new Complex[size][size];
		var barrier = new CyclicBarrier(4, () -> {
			DFT2D.dft(sum, output);
		});


		var thread1 = new Thread(() -> {
			for (int i = 0; i < size / 2; i++) {
				for (int j = 0; j < size / 2; j++) {
					sum[i][j] = input1[i][j].plus(input2[i][j]);
				}
			}
			awaitBarrier(barrier);

		});
		var thread2 = new Thread(() -> {
			for (int i = size / 2; i < size; i++) {
				for (int j = 0; j < size / 2; j++) {
					sum[i][j] = input1[i][j].plus(input2[i][j]);

				}
			}
			awaitBarrier(barrier);


		});
		var thread3 = new Thread(() -> {
			for (int i = 0; i < size / 2; i++) {
				for (int j = size / 2; j < size; j++) {
					sum[i][j] = input1[i][j].plus(input2[i][j]);

				}
			}
			awaitBarrier(barrier);

		});
		var thread4 = new Thread(() -> {
			for (int i = size / 2; i < size; i++) {
				for (int j = size / 2; j < size; j++) {
					sum[i][j] = input1[i][j].plus(input2[i][j]);
				}
			}
			awaitBarrier(barrier);

		});
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();

		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}

	private void awaitBarrier(CyclicBarrier barrier) {
		try {
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}

