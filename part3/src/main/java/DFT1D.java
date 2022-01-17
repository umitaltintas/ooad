public class DFT1D {
	/**
	 * @param complexes complex numbers to calculate dft
	 * @return result of dft
	 */
	public static Complex[] fft(Complex[] complexes) {
		int n = complexes.length;

		if (n == 1) return new Complex[]{complexes[0]};

		if (n % 2 != 0) {
			throw new IllegalArgumentException("n is not a power of 2");
		}

		// compute FFT of even terms
		Complex[] even = new Complex[n / 2];
		for (int k = 0; k < n / 2; k++) {
			even[k] = complexes[2 * k];
		}
		Complex[] evenFFT = fft(even);

		// compute FFT of odd terms
		Complex[] odd = even;  // reuse the array (to avoid n log n space)
		for (int k = 0; k < n / 2; k++) {
			odd[k] = complexes[2 * k + 1];
		}
		Complex[] oddFFT = fft(odd);

		// combine
		Complex[] y = new Complex[n];
		for (int k = 0; k < n / 2; k++) {
			double kth = -2 * k * Math.PI / n;
			Complex wk = new Complex(Math.cos(kth), Math.sin(kth));
			y[k] = evenFFT[k].plus(wk.times(oddFFT[k]));
			y[k + n / 2] = evenFFT[k].minus(wk.times(oddFFT[k]));
		}
		return y;
	}
}
