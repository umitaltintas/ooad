import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	static int size = 4096;
	static double min = -5;
	static double max = 5;


	public static void main(String[] args) {
		var dftPerformer = new DFTPerformer(new MutexDFT());
		Complex[][] A = new Complex[size][size];
		Complex[][] B = new Complex[size][size];
		Complex[][] output = new Complex[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				A[i][j] = new Complex(ThreadLocalRandom.current().nextDouble(min, max), ThreadLocalRandom.current().nextDouble(min, max));
				B[i][j] = new Complex(ThreadLocalRandom.current().nextDouble(min, max), ThreadLocalRandom.current().nextDouble(min, max));
			}
		}
		Instant start = Instant.now();
		dftPerformer.perform(A, B, output);
		Instant end = Instant.now();
		System.out.println("time spent for mutex version: " + Duration.between(start, end).toMillis()+"ms");
		dftPerformer.setDftStrategy(new NonMutexDFT());
		start = Instant.now();
		dftPerformer.perform(A, B, output);
		end = Instant.now();
		System.out.println("time spent for non-mutex version: " + Duration.between(start, end).toMillis() +"ms");

		dftPerformer.setDftStrategy(new SequentialDFT());
		start = Instant.now();
		dftPerformer.perform(A, B, output);
		end = Instant.now();
		System.out.println("time spent for sequential version: " + Duration.between(start, end).toMillis()+"ms");


	}

	static void print(Complex[][] complexes) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.println(complexes[i][j]);
			}
		}
	}

}


