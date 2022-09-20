//////////////// FILE HEADER //////////////////////////
//
// Title: CS 542 - Exercise 3.2: Numeric Errors
// Course: CS 542 Introduction to Software Security, Fall 2022
//
// Author: Binhao Chen, Steven Yang
// Email: bchen276@wisc.edu, yang558@wisc.edu
// Instructors' Name: Barton Miller, Elisa Heymann
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class includes functions (add, subtract, multiply, and divide) that do
 * 32-bit signed integer arithmetic returning a correct 32-bit signed integer
 * result or throw an exception when overflow occurs.
 * 
 * @author Binhao Chen, Steven Yang
 */
public class NumericErrors {

	/**
	 * Add two integers and deal with the cases of possible overflow
	 */
	public static int add(int x, int y) throws ArithmeticException {
		int sum = x + y;
		try {
			// Case 1:
			if (x >= 0 && y >= 0) {
				if (sum < 0) {
					throw new ArithmeticException("int overflow: add(" + x + ", " + y + ")");
				}
			}

			if (x <= 0 && y <= 0) {
				if (sum > 0) {
					throw new ArithmeticException("int overflow: add(" + x + ", " + y + ")");
				}
			}
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			return sum;
		}

		if ((x >= 0 && y <= 0) || (x <= 0 && y >= 0)) {
			return sum;
		}

		return sum;
	}

	/**
	 * Subtract two integers and deal with the cases of possible overflow
	 */
	public static int subtract(int x, int y) throws ArithmeticException {
		int diff = x - y;
		try {
			if (x >= 0 && y <= 0) {
				if (diff < 0) {
					throw new ArithmeticException("int overflow: subtract(" + x + ", " + y + ")");
				}
			}

			if (x <= 0 && y >= 0) {
				if (diff > 0) {
					throw new ArithmeticException("int overflow: subtract(" + x + ", " + y + ")");
				}
			}
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			return diff;
		}

		if ((x >= 0 && y >= 0) || (x <= 0 && y <= 0)) {
			return diff;
		}

		return diff;
	}

	/**
	 * Multiply two integers and deal with the cases of possible overflow
	 */
	public static int multiply(int x, int y) throws ArithmeticException {
		try {
			if (x > 0) {
				if (y > Integer.MAX_VALUE / x || y < Integer.MIN_VALUE / x) {
					throw new ArithmeticException("int overflow: multiply(" + x + ", " + y + ")");
				}
			} else if (x < 0) {
				if (x == -1 && y == Integer.MIN_VALUE) {
					throw new ArithmeticException("int overflow: multiply(" + x + ", " + y + ")");
				}

				if (y < Integer.MAX_VALUE / x || y > Integer.MIN_VALUE / x) {
					throw new ArithmeticException("int overflow: multiply(" + x + ", " + y + ")");
				}
			}
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			return x * y;
		}
		return x * y;
	}

	/**
	 * Divide two integers and deal with the cases of possible overflow
	 */
	public static int divide(int x, int y) {
		try {
			if (y == 0) {
				throw new ArithmeticException("Divide by zero exception!");
			}

			if (x == Integer.MIN_VALUE && y == -1) {
				throw new ArithmeticException("int overflow: divide(" + x + ", " + y + ")");
			}
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			return x / y;
		}

		return x / y;
	}

	/**
	 * Main Function, with several corner tests.
	 */
	public static void main(String args[]) {
		System.out.println(subtract(Integer.MIN_VALUE + 10, 100));
	}
}
