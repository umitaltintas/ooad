public class DFT2D {

	/**
	 *
	 * @param input complex numbers o calculate 2D dft
	 * @param output result of dft
	 */
	public static void dft(Complex[][] input, Complex[][] output) {
		int height = input.length;
		for (int y = 0; y < height; y++) {
			output[y] = DFT1D.fft(input[y]);
		}
	}
}
