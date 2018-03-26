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
	 * 输入一个整数数组，
	 * 实现一个函数来调整该数组中数字的顺序，
	 * 使得所有的奇数位于数组的前半部分，
	 * 所有的偶数位于位于数组的后半部分，
	 * 并保证奇数和奇数，
	 * 偶数和偶数之间的相对位置不变
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
