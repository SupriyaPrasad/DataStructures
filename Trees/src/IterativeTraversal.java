import java.util.ArrayList;
import java.util.Stack;

public class IterativeTraversal {
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
		BinaryTreeNode e13 = new BinaryTreeNode(13);
		BinaryTreeNode e14 = new BinaryTreeNode(14);
		BinaryTreeNode e15 = new BinaryTreeNode(15);
		root.left = e3;
		root.right = e4;

		e3.left = e6;
		e3.right = e17;

		e4.left = e18;
		e4.right = e19;

		e6.left = e7;
		e7.left = e8;

		e19.right = e11;
		e19.left = e15;

		e17.left = e13;
		e17.right = e14;

		preorder_traversal(root);
		System.out.println(" preorder");
		postorder_traversal(root);
		System.out.println(" postorder");
		inorder_traversal(root);
		System.out.println(" inorder");

		return root;
	}


	public ArrayList<Integer> postorder_traversal(BinaryTreeNode root) {
		Stack<BinaryTreeNode> treeNodesStack = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> vistedNodesStack = new Stack<BinaryTreeNode>();
		ArrayList<Integer> orderList = new ArrayList<Integer>();
		treeNodesStack.push(root);
		BinaryTreeNode main_root = root;

		if (root.right != null) {
			root = root.right;
		} else if (root.left != null) {
			root = root.left;

		}
		treeNodesStack.push(root);
		while (root != null) {
			if (root.right != null) {
				treeNodesStack.push(root.right);

			}
			if (root.left != null) {
				treeNodesStack.push(root.left);
			}
			root = root.left;
		}
		if (root == null) {
			root = main_root.left;
			treeNodesStack.push(root);
			while (root != null) {
				if (root.right != null) {
					treeNodesStack.push(root.right);

				}
				if (root.left != null) {
					treeNodesStack.push(root.left);
				}
				root = root.left;
			}
		}
		while (!treeNodesStack.isEmpty()) {
			BinaryTreeNode temp = treeNodesStack.pop();

			if (!vistedNodesStack.isEmpty() && temp.left == vistedNodesStack.peek()) {
				if (temp.right != null) {
					vistedNodesStack.push(temp.right);
					orderList.add(temp.right.data);
					orderList.add(temp.data);
					vistedNodesStack.push(temp);
				} else if (temp.right == null) {
					vistedNodesStack.push(temp);
					orderList.add(temp.data);
				}
			} else if (temp.left != null) {
				if (!vistedNodesStack.isEmpty() && temp.left != vistedNodesStack.peek()) {
					if (!vistedNodesStack.isEmpty() && temp.right == vistedNodesStack.peek()) {
						vistedNodesStack.push(temp);
						orderList.add(temp.data);
					} else if (!vistedNodesStack.isEmpty() && temp.right != vistedNodesStack.peek()) {
						treeNodesStack.push(temp);
						treeNodesStack.push(temp.right);
						treeNodesStack.push(temp.left);
					}

				}
			} else if (temp.left == null) {
				if (temp.right == null) {
					vistedNodesStack.push(temp);
					orderList.add(temp.data);
				}
				if (temp.right != null && temp.right != vistedNodesStack.peek()) {
					treeNodesStack.push(temp);
					treeNodesStack.push(temp.right);
				}
				if (temp.right != null && temp.right == vistedNodesStack.peek()) {
					vistedNodesStack.push(temp);
					orderList.add(temp.data);
				}
			}
		}
		for (int i = 0; i < orderList.size(); i++) {
			System.out.print(orderList.get(i) + " ");
		}

		return orderList;
	}

	public ArrayList<Integer> inorder_traversal(BinaryTreeNode root) {
		ArrayList<Integer> inorderList = new ArrayList<Integer>();
		Stack<BinaryTreeNode> inorderStack = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> visitedStack = new Stack<BinaryTreeNode>();
		BinaryTreeNode main_root = root;

		if (root.right != null) {
			root = root.right;
		} else if (root.left != null) {
			root = root.left;
		}
		while (root != null) {
			if (root.right != null) {
				inorderStack.push(root.right);
				inorderStack.push(root);
			}
			if (root.left != null) {
				inorderStack.push(root.left);
			}
			root = root.left;
		}
		if (root == null) {
			inorderStack.push(main_root);
			root = main_root.left;

			while (root != null) {
				if (root.right != null) {
					inorderStack.push(root.right);
					inorderStack.push(root);
				}
				if (root.left != null) {
					inorderStack.push(root.left);
				}
				root = root.left;
			}
		}

		while (!inorderStack.isEmpty()) {
			BinaryTreeNode temp = inorderStack.pop();
			if (temp.left != null) {
				if (temp == main_root) {
					visitedStack.push(temp);
					inorderList.add(temp.data);
				} else if (!visitedStack.isEmpty() && temp.left == visitedStack.peek()) {
					inorderList.add(temp.data);
					visitedStack.push(temp);
					if (temp.right != null) {
						inorderStack.push(temp.right);
					}
				} else if (!visitedStack.isEmpty() && temp.left != visitedStack.peek()) {
					inorderStack.push(temp.left);
				}
			}
			if (temp.left == null) {
				inorderList.add(temp.data);
				visitedStack.push(temp);
				if (temp.right != null) {
					inorderStack.push(temp.right);
				}
			}
		}
		for (int i = 0; i < inorderList.size(); i++) {
			System.out.print(inorderList.get(i) + " ");
		}

		return inorderList;
	}
	
	public BinaryTreeNode preorder_traversal(BinaryTreeNode root) {
        Stack<BinaryTreeNode> treeNodesStack = new Stack<BinaryTreeNode>();
        treeNodesStack.push(root);
        while (!treeNodesStack.isEmpty()) {
               BinaryTreeNode temp = treeNodesStack.pop();
               System.out.print(temp.data + " ");
               if (temp.right != null) {
                     treeNodesStack.push(temp.right);
               }
               if (temp.left != null) {
                     treeNodesStack.push(temp.left);
               }
        }
        return root;
 }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IterativeTraversal testTraversal = new IterativeTraversal();
		BinaryTreeNode root = testTraversal.createBinaryTree();
		// System.out.println(testTraversal.preorder_traversal(root));
	}

}
