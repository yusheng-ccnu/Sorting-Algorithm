package sort;

import java.util.Stack;

public class Sort {
	public static int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1,1};
	
	public static void main(String[] args){
		Sort s = new Sort();
		s.mergeSortArray(a);
		for(int data:a){
			System.out.print(data+" ");
		}
	}
	
	public void BubbleSortArray(int []array){//冒泡排序
		int temp = 0;
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length-i-1;j++){
				if(array[j+1]<array[j]){
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		
		for(int data:array){
			System.out.print(data+" ");
		}
		
	} 
	
	public void QuickSortArray(int[] array, int start, int end) { // 递归形式的快速排序
		if (start <= end) {
			int i = partition(array, start, end);
			QuickSortArray(array, start, i - 1);
			QuickSortArray(array, i + 1, end);
		}
	}
	//获取下一次划分的下标
	public int partition(int[] array, int i, int j){
		int temp = array[i];
		
		while (i < j) {
			while (array[j] >= temp && i < j)
				j--;
			array[i] = array[j];
			while (array[i] < temp && i < j)
				i++;
			array[j] = array[i];
			
		}
		array[i] = temp;
		return i;
	}
	
	public void QuickSort(int[] array,int start, int end){//非递归快排
		Stack<Integer>s = new Stack<Integer>();
		if(start <= end){
			int p=partition(array, start, end);
			if(p-1 > start){
				s.push(start);
				s.push(p-1);
			}
			if(p+1 < end){
				s.push(p+1);
				s.push(end);
			}
			
			while(!s.isEmpty()){
				int right = s.pop();
				int left = s.pop();
				p = partition(array, left, right);
				if(p-1 > left){
					s.push(left);
					s.push(p-1);
				}
				if(p+1 < end){
					s.push(p+1);
					s.push(end);
				}
			}
		}
		
	}
	
	public void InsertSort(int[] array){  //直接插入排序
		int target,mark;
		for(int i=1;i<array.length;i++){
			target = array[i];
			mark = i;
			while(mark>0 && target < array[mark-1]){
				array[mark] = array[mark-1];
				mark --;
			}
			array[mark] = target;
		}
	}
	
	public void InsertSortArray(int[] array){ //二分插入排序
		int target,low,high,mid;
		for(int i=1;i<array.length;i++){
			low = 0;
			high = i-1;
			target = array[i];
			while(low <= high){
				mid = (low+high)/2;
				System.out.println(mid);
				if(target < array[mid]){  //在左半边区域
					high = mid-1;
				}else{                    //在右半边区域
					low = mid+1;
				}
			}
			
			for(int j=i-1;j>=low;j--){
				array[j+1] = array[j];
			}
			array[low] = target;
		}

	}
	
	public void ShellSort(int[] array){//插入排序中的希尔排序
		int d = array.length;
		while(d != 1){
			d = d/2;
			for(int x=0;x<d;x++){
				for(int i=x+d;i<array.length;i=i+d){
					int temp = array[i];
					int j;
					for(j=i-d;j>=0&&array[j]>temp;j=j-d){
						array[j+d] = array[j];
					}
					array[j+d] = temp;
				}
			}
		}
	}
	
	public void SelectSort(int[] array){  //选择排序算法
		
		int n = 0;  //最小数的索引
		for(int i=0; i<array.length; i++){
			int min = array[i];
			for(int j=i; j<array.length ;j++){
				if(min>a[j]){
					min = a[j];
					n = j;
				}
			}
			int temp = a[i];
			a[i] = min;
			a[n] = temp;
			
		}
		
	}
	
	public void adjustHeap(int[] a, int i, int len) {
        int temp, j;
        temp = a[i];
        for (j = 2 * i; j < len; j *= 2) {// 沿关键字较大的孩子结点向下筛选
            if (j < len && a[j] <= a[j + 1])
                ++j; // j为关键字中较大记录的下标
            if (temp >= a[j])
                break;
            a[i] = a[j];
            i = j;
        }
        a[i] = temp;
    }

    public void heapSort(int[] a) {
        int i;
        for (i = a.length / 2 - 1; i >= 0; i--) {// 构建一个大顶堆
            adjustHeap(a, i, a.length - 1);
        }
        for (i = a.length - 1; i >= 0; i--) {// 将堆顶记录和当前未经排序子序列的最后一个记录交换
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            adjustHeap(a, 0, i - 1);// 将a中前i-1个记录重新调整为大顶堆
        }
    }
    
    //归并排序的递归和非递归实现
    public void merge(int[] a ,int low ,int mid ,int high) {  //合并
    	int[] temp = new int[high - low + 1];
    	int i = low;
    	int j = mid + 1;
    	int k=0;
    	for(;i <= mid && j<= high;k++) {
    		if(a[i] <= a[j]) {
    			temp[k] = a[i++];
    		}else {
    			temp[k] = a[j++];
    		}
    	}
    	while(i <= mid) {
    		temp[k++] = a[i++];
    	}
    	while(j <= high) {
    		temp[k++] = a[j++];
    	}
    	
    	for(int n=0; n<temp.length; n++) {
    		a[low + n] = temp[n];
    	}
    	
    }
    
    public void mergeSort(int[] a ,int low ,int high) {
    	int mid = low + (high - low)/2;
    	if(low < high) {
    		mergeSort(a, low, mid);
    		mergeSort(a, mid + 1, high);
    		merge(a, low, mid, high);
    	}
    }
    
    //非递归的归并排序
    public void mergeSortArray(int[] a) {
    	int n = a.length;
    	int s = 2;     //步长
    	int i;
    	while(s <= n) {
    		i = 0;
    		while(i+s <= n) {
    			merge(a, i, i+s/2-1, i+s-1);
    			i += s;
    		}
    		merge(a, i-s, i-1, n-1);
    		s *= 2;
    	}
    	merge(a,0,s/2-1,n-1);
    }

}