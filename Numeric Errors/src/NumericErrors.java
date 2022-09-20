public class NumericErrors {

	public static int add(int x, int y) throws ArithmeticException {
		int sum = x + y;

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

		if ((x >= 0 && y <= 0) || (x <= 0 && y >= 0)) {
			return sum;
		}

		return sum;
	}

	public static int subtract(int x, int y) throws ArithmeticException {
		int diff = x - y;
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

		if ((x >= 0 && y >= 0) || (x <= 0 && y <= 0)) {
			return diff;
		}
		return diff;
	}

	public static int multiply(int x, int y) throws ArithmeticException {
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

		return x * y;
	}

	public static int divide(int x, int y) {
		if (y == 0) {
			throw new ArithmeticException("Divide by zero exception!");
		}

		if (x == Integer.MIN_VALUE && y == -1) {
			throw new ArithmeticException("int overflow: divide(" + x + ", " + y + ")");
		}
		return x / y;
	}

	public static void main(String args[]) {
		System.out.println(divide(Integer.MIN_VALUE, -1));
	}
}
