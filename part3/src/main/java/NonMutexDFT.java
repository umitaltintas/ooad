import java.util.concurrent.atomic.AtomicInteger;

/**
 * calculate dft by using wait notify
 */
public class NonMutexDFT implements DFTStrategy {

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

		AtomicInteger finishedCount = new AtomicInteger();
		var a = new Object();

		var thread1 = new Thread(() -> {
			for (int i = 0; i < size / 2; i++) {
				for (int j = 0; j < size / 2; j++) {
					sum[i][j] = input1[i][j].plus(input2[i][j]);
				}
			}
			synchronized (a) {
				finishedCount.getAndIncrement();
				a.notify();

			}
		});
		var thread2 = new Thread(() -> {
			for (int i = size / 2; i < size; i++) {
				for (int j = 0; j < size / 2; j++) {
					sum[i][j] = input1[i][j].plus(input2[i][j]);

				}
			}
			synchronized (a) {
				finishedCount.incrementAndGet();
				a.notify();
			}

		});
		var thread3 = new Thread(() -> {
			for (int i = 0; i < size / 2; i++) {
				for (int j = size / 2; j < size; j++) {
					sum[i][j] = input1[i][j].plus(input2[i][j]);
				}
			}
			synchronized (a) {
				finishedCount.incrementAndGet();
				a.notify();
			}
		});
		var thread4 = new Thread(() -> {
			for (int i = size / 2; i < size; i++) {
				for (int j = size / 2; j < size; j++) {
					sum[i][j] = input1[i][j].plus(input2[i][j]);
				}
			}
			synchronized (a) {
				finishedCount.incrementAndGet();
				a.notify();
			}
		});
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();


		synchronized (a) {
			try {
				a.notify();
				while (finishedCount.get() != 4)
					a.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				DFT2D.dft(sum, output);
			}
		}
	}
}
