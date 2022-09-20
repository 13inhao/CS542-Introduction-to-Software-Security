public class NumericErrors {

	public static int add(int x, int y) throws ArithmeticException {
		int sum = x + y;
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
			if (y > Integer.MAX_VALUE / x || y < Integer.MAX_VALUE/ x) {
				throw new ArithmeticException("int overflow: multiply(" + x + ", " + y + ")");
			}
		} else if (x < 0) {
			if(x == -1 && y == Integer.MAX_VALUE) {
				throw new ArithmeticException("int overflow: multiply(" + x + ", " + y + ")");
			}
			
			if (y < Integer.MAX_VALUE / x || y > Integer.MAX_VALUE/ x) {
				throw new ArithmeticException("int overflow: multiply(" + x + ", " + y + ")");
			}
		}
		
		return x*y;
	}
	
	public static int divide(int x, int y) {
		
		return 0;
	}

	public static void main(String args[]) {
		System.out.println(add(Integer.MAX_VALUE-1, Integer.MAX_VALUE-1));
	}
}
