public class BinaryTress {
	int max_val = 0;
	boolean b = false;
	int count_leaf = 0;
	int count_full = 0;
	int flag = 1;
	int size = 0;
	
	public BinaryTreeNode createBinaryTree() {
		BinaryTreeNode root = new BinaryTreeNode(9);
		BinaryTreeNode e3 = new BinaryTreeNode(3);
		BinaryTreeNode e4 = new BinaryTreeNode(4);
		BinaryTreeNode e6 = new BinaryTreeNode(6);
		BinaryTreeNode e17 = new BinaryTreeNode(17);
		BinaryTreeNode e18 = new BinaryTreeNode(18);
		BinaryTreeNode e19 = new BinaryTreeNode(19);
		BinaryTreeNode e7 = new BinaryTreeNode(7);
		BinaryTreeNode e11 = new BinaryTreeNode(11);
		BinaryTreeNode e8 = new BinaryTreeNode(8);
		root.left = e3;
		root.right = e4;

		e3.left = e6;
		e3.right = e17;

		e4.left = e18;
		e4.right = e19;

		e6.left = e7;
		e7.left = e8;

		e19.right = e11;

		preorder(root);
		System.out.println(" preorder");
		postorder(root);
		System.out.println(" postorder");
		inorder(root);
		System.out.println(" inorder");

		return root;
	}

	public void preorder(BinaryTreeNode root) {
		if (root == null) {
			return;
		} else {
			System.out.print(root.data+" ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public void postorder(BinaryTreeNode root) {
		if (root == null) {
			return;
		} else {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data+" ");
		}
	}

	public void inorder(BinaryTreeNode root) {
		if (root == null) {
			return;
		} else {
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}

	public int find_max(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		} else {
			find_max(root.left);
			if (root.data > max_val) {
				max_val = root.data;
			}
			find_max(root.right);
		}
		return max_val;
	}

	public boolean search_element(BinaryTreeNode root, int element) {

		if (root == null) {
			b = false;
			return b;
		}

		else {
			search_element(root.left, element);
			if (root.data == element && flag==1) {
				b = true;
				flag = 0;
			}
			search_element(root.right, element);
		}
		if (flag==0) {
			return true;
		} else {
			return false;
		}
	}

	public int count_leaf_nodes(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		} else {
			count_leaf_nodes(root.left);
			if (root.left == null && root.right == null) {
				count_leaf++;
			}
			count_leaf_nodes(root.right);
		}
		return count_leaf;
	}

	public int count_full_nodes(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		} else {
			count_full_nodes(root.left);
			if (root.left != null && root.right != null) {
				count_full++;
			}
			count_full_nodes(root.right);
		}
		return count_full;
	}
	
	public int calcSize(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		} else {
			calcSize(root.left);
			size++;
			calcSize(root.right);
		}
		return size;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTress test = new BinaryTress();
		BinaryTreeNode root = test.createBinaryTree();
		System.out.println();
		System.out.println(root.data + " root");
		System.out.println(test.find_max(root) + " max number");
		System.out.println(test.search_element(root, 19) + " present?");
		System.out.println(test.count_leaf_nodes(root) + " number of leaf nodes");
		System.out.println(test.count_full_nodes(root) + " number of full nodes");
		System.out.println(test.calcSize(root) + " size");
		// System.out.println(test.createBinaryTree().data);
	}

}
