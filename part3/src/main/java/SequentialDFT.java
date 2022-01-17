public class SequentialDFT implements DFTStrategy {

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
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sum[i][j] = input1[i][j].plus(input2[i][j]);
			}
		}
		DFT2D.dft(sum, output);
	}
}
