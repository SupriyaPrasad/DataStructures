import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	
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
		
		return root;
	}
	
	public ArrayList<Integer> levelOrderTraversal(BinaryTreeNode root){
		ArrayList<Integer> levelList = new ArrayList<Integer>();
		Queue<BinaryTreeNode> mainQueue = new LinkedList<BinaryTreeNode>();
		
		BinaryTreeNode main_root = root;
		
		mainQueue.add(root);
		levelList.add(root.data);
		while(!mainQueue.isEmpty()) {
			BinaryTreeNode temp = mainQueue.remove();
			if(temp.right!=null) {
				levelList.add(temp.right.data);
				mainQueue.add(temp.right);
			}
			if(temp.left!=null) {
				levelList.add(temp.left.data);
				mainQueue.add(temp.left);
			}
		}
		for (int i = 0; i < levelList.size(); i++) {
			System.out.print(levelList.get(i) + " ");
		}
		return levelList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LevelOrderTraversal testLevel = new LevelOrderTraversal();
		BinaryTreeNode root = testLevel.createBinaryTree();
		testLevel.levelOrderTraversal(root);

	}

}
