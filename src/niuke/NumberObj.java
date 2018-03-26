package niuke;

public class NumberObj {
	/*
	 *输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
	 */
	public int NumberOf1(int n) {
		int flag = 1;
		int sum = 0;
		while (flag != 0) {
			if ((n & flag) != 0) {
				sum++;
			}
			flag = flag << 1;
		}
		return sum;
	}
	/*
	 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
	 * */
	//叠乘法
	public double Power(double base, int exponent) throws Exception {
		if(base == 0 && exponent <0) {
			throw new Exception("除数不能为0");
		}
		double result = 1;
		if(exponent == 0) {
			return 1;
		}else if(exponent > 0) {
			while(exponent > 0) {
				result *= base;
				exponent --;
			}
			return result;
		}else {
			while(exponent < 0) {
				result /= base;
				exponent ++;
			}
			return result;
		}
	}
	//快速幂方法
	public double PowerQuick(double base, int exponent) {
		int n = 0;
		double crr = 1;
		if(base == 0 && exponent < 0) {
			try {
				throw new Exception("除数不能为0");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(exponent > 0) {
			n = exponent;
		}
		if(exponent < 0) {
			n = -exponent;
		}
		while(n != 0) {
			if((n&1) != 0) {
				crr *= base;
			}
			base *= base;
			n = n >> 1;
		}
		if(exponent > 0) {
			return crr;
		}else {
			return 1/crr;
		}
	}
	
	public static void main(String[] args) {
		NumberObj n = new NumberObj();
		try {
			System.out.println(n.PowerQuick(2, 100));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
