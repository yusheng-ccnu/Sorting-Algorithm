package niuke;

public class ReOrderArray {

	public static void main(String[] args) {
		int[] array = {1,3,5,7,2,4,6};
		reOrderArray(array);
		for(int data:array) {
			System.out.print(data+" ");
		}

	}
	/*
	 * ����һ���������飬
	 * ʵ��һ�����������������������ֵ�˳��
	 * ʹ�����е�����λ�������ǰ�벿�֣�
	 * ���е�ż��λ��λ������ĺ�벿�֣�
	 * ����֤������������
	 * ż����ż��֮������λ�ò���
	 * */
	
	public static void reOrderArray(int[] array) {
		int flag = 0;
		int length = array.length;
	    for(int i=0;i<length;i++) {
		   if(array[i]%2 == 0) {
			   int temp = array[i];
			   flag = i;
			   for(int j=i;j<array.length-1;j++) {
				   array[j] = array[j+1];
			   }
			   array[array.length-1] =temp;
			   i=flag-1;
			   length--;
		   }
		   
	   }
	}

}
