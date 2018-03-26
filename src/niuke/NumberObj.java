package niuke;

public class NumberObj {
	/*
	 *����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
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
	 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
	 * */
	//���˷�
	public double Power(double base, int exponent) throws Exception {
		if(base == 0 && exponent <0) {
			throw new Exception("��������Ϊ0");
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
	//�����ݷ���
	public double PowerQuick(double base, int exponent) {
		int n = 0;
		double crr = 1;
		if(base == 0 && exponent < 0) {
			try {
				throw new Exception("��������Ϊ0");
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
