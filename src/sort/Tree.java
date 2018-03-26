package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode{
	int value;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int value) {
		this.value = value;
	}
	
	public void print() {
		System.out.println(" "+this.value);
	}
}
public class Tree {
	static TreeNode root;

	
	
	public static void main(String[] args) {
		int[] a={49,38,65,97,76,13,27,49,78,34,12,64};
		Tree t = new Tree();
		for(int data:a) {
			TreeNode node = new TreeNode(data);
			t.inertNode(node);
		}
		//t.preOrderPrecursion(root);
		//t.prePrecursion();
//		t.midOrderPrecursion(root);
		t.backOrderPrecursion(root);
	}
	
	public void preOrderPrecursion(TreeNode node) {
		if(node == null)
			return;
		node.print();
		preOrderPrecursion(node.left);
		preOrderPrecursion(node.right);
	}
	
	public void prePrecursion() {
		Stack<TreeNode>t = new Stack<TreeNode>();
		t.push(root);
		while(!t.isEmpty()) {
			TreeNode top = t.pop();
			if (top != null) {
				top.print();
				t.push(top.right);
				t.push(top.left);
			}
		}
		
	}
	
	public void midOrderPrecursion(TreeNode node) {
		if(node == null) {
			return ;
		}
		midOrderPrecursion(node.left);
		node.print();
		midOrderPrecursion(node.right);
	}
	
	public void midPrecursion(TreeNode node) {
		if(node == null) {
			return ;
		}
		TreeNode cur = node;
		Stack<TreeNode>t = new Stack<TreeNode>();
		while(!t.empty() || cur != null) {
			while(cur != null) {
				t.push(cur);
				cur = cur.left;
			}
			cur = t.pop();
			cur.print();
			cur = cur.right;
		}
		
	}
	
	public void backOrderPrecursion(TreeNode node) {
		if(node == null) {
			return ;
		}
		Stack<TreeNode>t = new Stack<TreeNode>();
		Stack<TreeNode>back = new Stack<TreeNode>();
		t.push(node);
		while(!t.empty()) {
			TreeNode cur = t.pop();
			if(cur != null) {
				back.push(cur);
				t.push(cur.left);
				t.push(cur.right);
			}
		}
		
		while(!back.empty()) {
			TreeNode curback = back.pop();
			if(curback != null) {
				curback.print();
			}
		}
	}
	
	public void inertNode(TreeNode node) {
		
		if(root == null) {
			root = node;
			return;
		}
		TreeNode mark = root;
		while(mark != null) {
			if(mark.value > node.value) {
				if(mark.left == null) {
					mark.left = node;
					break;
				}else {
					mark = mark.left;
				}
				
			}else {
				if(mark.right == null) {
					mark.right = node;
					break;
				}else {
					mark = mark.right;
				}
			}
		}
		
	}

}
