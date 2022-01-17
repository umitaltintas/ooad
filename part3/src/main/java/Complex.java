import java.util.Objects;

/**
 * A complex number holder class
 */
public class Complex {
	private final double re;
	private final double im;


	/**
	 * create a new object with the given real and imaginary parts
	 *
	 * @param real real part of complex number
	 * @param imag imaginary part of complex number
	 */
	public Complex(double real, double imag) {
		re = real;
		im = imag;
	}

	/**
	 * @return a string representation of the invoking Complex object
	 */
	public String toString() {
		if (im == 0) return re + "";
		if (re == 0) return im + "i";
		if (im < 0) return re + " - " + (-im) + "i";
		return re + " + " + im + "i";
	}

	// return a new Complex object whose value is (this + b)

	/**
	 * @param b complex number to use in addition
	 * @return a new Complex object whose value is (this + b)
	 */
	public Complex plus(Complex b) {
		Complex a = this;             // invoking object
		double real = a.re + b.re;
		double imag = a.im + b.im;
		return new Complex(real, imag);
	}

	// return a new Complex object whose value is (this - b)

	/**
	 * @param b complex number to use in subtraction
	 * @return a new Complex object whose value is (this - b)
	 */
	public Complex minus(Complex b) {
		Complex a = this;
		double real = a.re - b.re;
		double imag = a.im - b.im;
		return new Complex(real, imag);
	}

	/**
	 * @param b complex number to use in multiplication
	 * @return a new Complex object whose value is (this * b)
	 */
	public Complex times(Complex b) {
		Complex a = this;
		double real = a.re * b.re - a.im * b.im;
		double imag = a.re * b.im + a.im * b.re;
		return new Complex(real, imag);
	}

	/**
	 *
	 * @param a
	 * @param b
	 * @return a+b
	 */
	public static Complex plus(Complex a, Complex b) {
		double real = a.re + b.re;
		double imag = a.im + b.im;
		Complex sum = new Complex(real, imag);
		return sum;
	}

	public boolean equals(Object x) {
		if (x == null) return false;
		if (this.getClass() != x.getClass()) return false;
		Complex that = (Complex) x;
		return (this.re == that.re) && (this.im == that.im);
	}

	public int hashCode() {
		return Objects.hash(re, im);
	}


}
