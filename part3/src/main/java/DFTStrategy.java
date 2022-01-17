/**
 * dft calculation strategy
 */
public interface DFTStrategy {
	/**
	 * calculate dft
	 *
	 * @param input1 A
	 * @param input2 B
	 * @param output dft(A+B)
	 */
	public void calculateDFT(Complex[][] input1, Complex[][] input2, Complex[][] output);
}
