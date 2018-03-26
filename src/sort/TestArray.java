package sort;


public class TestArray {

	public static void main(String[] args) {
		int [][]array = {{}};
		System.out.println(new TestArray().Find(1, array));

	}
	public boolean Find(int target, int [][] array) {
		if(array.length <=0||array[0].length<=0){
			return false;
		}
		int j = array[0].length-1;
		int i=0;

		if(target < array[0][0]){
			return false;
		}
		while (target != array[i][j]) {
			if (target > array[i][j]) {
				i++;
			} else {
				j--;
			}
			if(j<0){
				i++;
				j = array[0].length-1;
			}
			if(i>=array.length-1){
				break;
			}
		}
		if(target == array[i][j]){
			System.out.println(i+":"+j);
			return true;
		}else{
			return false;
		}
		
	}

}
