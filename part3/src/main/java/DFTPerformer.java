/**
 * dft performer which calculates dft of complex matrices
 */
public class DFTPerformer {
	private DFTStrategy dftStrategy;

	/**
	 * create dftPerformer
	 *
	 * @param dftStrategy strategy of dft calculation
	 */
	public DFTPerformer(DFTStrategy dftStrategy) {
		this.dftStrategy = dftStrategy;
	}

	/**
	 * calculate dft
	 *
	 * @param input1 A
	 * @param input2 B
	 * @param output dft(A+B)
	 */
	public void perform(Complex[][] input1, Complex[][] input2, Complex[][] output) {
		dftStrategy.calculateDFT(input1, input2, output);
	}

	/**
	 * set strategy of dft calculation
	 *
	 * @param dftStrategy strategy of calculation
	 */
	public void setDftStrategy(DFTStrategy dftStrategy) {
		this.dftStrategy = dftStrategy;
	}
}
