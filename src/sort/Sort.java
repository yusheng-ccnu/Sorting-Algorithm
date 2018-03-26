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
	
	public void BubbleSortArray(int []array){//ð������
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
	
	public void QuickSortArray(int[] array, int start, int end) { // �ݹ���ʽ�Ŀ�������
		if (start <= end) {
			int i = partition(array, start, end);
			QuickSortArray(array, start, i - 1);
			QuickSortArray(array, i + 1, end);
		}
	}
	//��ȡ��һ�λ��ֵ��±�
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
	
	public void QuickSort(int[] array,int start, int end){//�ǵݹ����
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
	
	public void InsertSort(int[] array){  //ֱ�Ӳ�������
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
	
	public void InsertSortArray(int[] array){ //���ֲ�������
		int target,low,high,mid;
		for(int i=1;i<array.length;i++){
			low = 0;
			high = i-1;
			target = array[i];
			while(low <= high){
				mid = (low+high)/2;
				System.out.println(mid);
				if(target < array[mid]){  //����������
					high = mid-1;
				}else{                    //���Ұ������
					low = mid+1;
				}
			}
			
			for(int j=i-1;j>=low;j--){
				array[j+1] = array[j];
			}
			array[low] = target;
		}

	}
	
	public void ShellSort(int[] array){//���������е�ϣ������
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
	
	public void SelectSort(int[] array){  //ѡ�������㷨
		
		int n = 0;  //��С��������
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
        for (j = 2 * i; j < len; j *= 2) {// �عؼ��ֽϴ�ĺ��ӽ������ɸѡ
            if (j < len && a[j] <= a[j + 1])
                ++j; // jΪ�ؼ����нϴ��¼���±�
            if (temp >= a[j])
                break;
            a[i] = a[j];
            i = j;
        }
        a[i] = temp;
    }

    public void heapSort(int[] a) {
        int i;
        for (i = a.length / 2 - 1; i >= 0; i--) {// ����һ���󶥶�
            adjustHeap(a, i, a.length - 1);
        }
        for (i = a.length - 1; i >= 0; i--) {// ���Ѷ���¼�͵�ǰδ�����������е����һ����¼����
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            adjustHeap(a, 0, i - 1);// ��a��ǰi-1����¼���µ���Ϊ�󶥶�
        }
    }
    
    //�鲢����ĵݹ�ͷǵݹ�ʵ��
    public void merge(int[] a ,int low ,int mid ,int high) {  //�ϲ�
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
    
    //�ǵݹ�Ĺ鲢����
    public void mergeSortArray(int[] a) {
    	int n = a.length;
    	int s = 2;     //����
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