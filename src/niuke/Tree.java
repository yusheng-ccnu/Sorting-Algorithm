package niuke;


class TreeNode{
	TreeNode left = null;
	TreeNode right = null;
	int val;
	public TreeNode(int val) {
		this.val = val;
	}
}
public class Tree {
	
	public static void main(String[] args) {
		int[] array = {2,1,3,5,7,2,4,6};
		int[] array1 = {1,3,5};
		Tree t = new Tree();
		TreeNode root = new TreeNode(2);
		TreeNode root1 = new TreeNode(1);
		for(int i=1; i<array.length; i++) {
			TreeNode node = new TreeNode(array[i]);
			t.insert(node, root);
		}
		for(int i=1; i<array1.length; i++) {
			TreeNode node = new TreeNode(array1[i]);
			t.insert(node, root1);
		}
		t.preOrderPrecursion(root);
		System.out.println();
		t.Mirror(root);
		t.preOrderPrecursion(root);
	}
	
	
	//输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) {
        	return false;
        }
        return HasSubtree(root1.left, root2)||HasSubtree(root1.right, root2)||CompareTree(root1, root2);
    }
	
	public boolean CompareTree(TreeNode node1,TreeNode node2) {
		if(node1 == null && node2 != null) {
			return false;
		}
		if(node2 == null) {
			return true;
		}
		if(node1.val != node2.val) {
			return false;
		}
		return CompareTree(node1.left, node2.left)  && CompareTree(node1.right, node2.right);
		
	}
	
	
	//操作给定的二叉树，将其变换为源二叉树的镜像。
	public void Mirror(TreeNode root) {
        if(root == null) {
        	return ;
        }
        TreeNode node = null;
        node = root.left;
        root.left = root.right;
        root.right = node;
        Mirror(root.left);
        Mirror(root.right);
    }
	
	
	//插入节点
	public TreeNode insert(TreeNode node,TreeNode root) {
		if(root == null) {
			return node;
		}
		if(node.val <= root.val) {
			root.left = insert(node, root.left);
		}else {
			root.right = insert(node, root.right);
		}
		return root;
		
	}
	
	//
	
	
	public void preOrderPrecursion(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.print(" "+root.val);
		preOrderPrecursion(root.left);
		preOrderPrecursion(root.right);
	}

}
