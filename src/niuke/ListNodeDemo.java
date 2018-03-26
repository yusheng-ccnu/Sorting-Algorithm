package niuke;

class ListNode{
	ListNode next = null;
	int val;
	public ListNode(int val) {
		this.val = val;
	}
}

public class ListNodeDemo {
	
	public static void main(String[] args) {
		int[] array = {1,3,5};
		int[] array1 = {2,4,6};
		ListNode root = new ListNode(1);
		ListNode head = null;
		ListNode head1 = null;
		ListNode root2 = new ListNode(2);
		for(int i=1; i<array.length; i++) {
			ListNode node = new ListNode(array[i]);
			
			head = root;
			while(head.next != null) {
				head = head.next;
			}
			head.next = node;
		}
		
		for(int i=1; i<array1.length; i++) {
			ListNode node = new ListNode(array1[i]);
			
			head = root2;
			while(head.next != null) {
				head = head.next;
			}
			head.next = node;
		}
		
		ListNodeDemo lnd = new ListNodeDemo();
		root = lnd.Merge(root, root2);
		while(root != null) {
			System.out.print(" "+root.val);
			root = root.next;
		}

	}
	
	/*
	 * 输入一个链表，输出该链表中倒数第k个结点。
	 * */
	 public ListNode FindKthToTail(ListNode head,int k) {
		 if(head == null) {
			 return null;
		 }
		 ListNode node = head;
		 int length = 1;
		 while(node.next != null) {
			 length ++;
			 node = node.next;
		 }
		 node = head;
		 if(length < k) {
			 return null;
		 }
		 int i=1;
		 while(i < length-k+1) {
			 node = node.next;
			 i++;
		 }
		 return node;
	 }
	 //最好的代码
	 public ListNode FindKthToTail_best(ListNode head,int k) {
		 ListNode p,q;
		 p = q = head;
		 int i=0;
		 for(; p!=null; i++) {
			 if(i >= k) {
				 q = q.next;
			 }
			 p = p.next;
		 }
		 return i<k ? null : q;
	 }
	 //输入一个链表，反转链表后，输出链表的所有元素。
	 public ListNode ReverseList(ListNode head) {
		 if(head == null) {
			 return null;
		 }
		 ListNode p,q;
		 p = q = head.next;
		 head.next = null;
		 while(p != null) {
			 q = p.next;
			 p.next = head;
			 head = p;
			 p = q;
		 }
		 return head;
	 }
	 /*
	  * 输入两个单调递增的链表，
	  * 输出两个链表合成后的链表，
	  * 当然我们需要合成后的链表满足单调不减规则。
	  * */
	public ListNode Merge(ListNode list1, ListNode list2) {
		ListNode root = null, node = null;
		if(list1 == null) {
			return list2;
		}
		if(list2 == null) {
			return list1;
		}
		if(list1.val > list2.val) {
			root = new ListNode(list2.val);
			list2 = list2.next;
		}else {
			root = new ListNode(list1.val);
			list1 = list1.next;
		}
		node = root;
		while (list1 != null || list2 != null) {
			ListNode insert = null;
			if(list1 == null && list2 != null) {
				insert = new ListNode(list2.val);
				list2 = list2.next;
			}
			if(list2 == null && list1 != null) {
				insert = new ListNode(list1.val);
				list1 = list1.next;
			}
			if (list1 != null && list2 != null) {
				if(list1.val <= list2.val) {
				insert = new ListNode(list1.val);
				list1 = list1.next;
				}else {
					insert = new ListNode(list2.val);
					list2 = list2.next;
				}
			} 

			while(node.next != null) {
				node = node.next;
			}
			node.next = insert;
			
		}
		return root;
	}
	
	public void insert() {
		
	}

}
