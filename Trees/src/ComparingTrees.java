
public class ComparingTrees {
	boolean b= false;
	int flag = 1;
	int flag_1 = 1;
	
	public BinaryTreeNode createBinaryTree1() {
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
		
		return root;
	}
	public BinaryTreeNode createBinaryTree2() {
		BinaryTreeNode root2 = new BinaryTreeNode(9);
		BinaryTreeNode e3_2 = new BinaryTreeNode(3);
		BinaryTreeNode e4_2 = new BinaryTreeNode(4);
		BinaryTreeNode e6_2 = new BinaryTreeNode(6);
		BinaryTreeNode e17_2 = new BinaryTreeNode(17);
		BinaryTreeNode e18_2 = new BinaryTreeNode(18);
		BinaryTreeNode e19_2 = new BinaryTreeNode(19);
		BinaryTreeNode e7_2 = new BinaryTreeNode(7);
		BinaryTreeNode e11_2 = new BinaryTreeNode(11);
		BinaryTreeNode e8_2 = new BinaryTreeNode(8);
		root2.left = e3_2;
		root2.right = e4_2;

		e3_2.left = e6_2;
		e3_2.right = e17_2;

		e4_2.left = e18_2;
		e4_2.right = e19_2;

		e6_2.left = e7_2;
		e7_2.left = e8_2;

		e19_2.right = e11_2;
		
		return root2;
	}
	public BinaryTreeNode createBinaryTree3() {
		BinaryTreeNode root3 = new BinaryTreeNode(9);
		BinaryTreeNode e3_3 = new BinaryTreeNode(3);
		BinaryTreeNode e4_3 = new BinaryTreeNode(4);
		BinaryTreeNode e6_3 = new BinaryTreeNode(6);
		BinaryTreeNode e17_3 = new BinaryTreeNode(17);
		BinaryTreeNode e18_3 = new BinaryTreeNode(18);
		BinaryTreeNode e19_3 = new BinaryTreeNode(19);
		BinaryTreeNode e7_3 = new BinaryTreeNode(7);
		BinaryTreeNode e11_3 = new BinaryTreeNode(11);
		BinaryTreeNode e8_3 = new BinaryTreeNode(8);
		root3.left = e4_3;
		root3.right = e3_3;

		e3_3.left = e17_3;
		e3_3.right = e6_3;

		e4_3.left = e19_3;
		e4_3.right = e18_3;

		e6_3.right = e7_3;
		e7_3.right = e8_3;

		e19_3.left = e11_3;
		
		return root3;
	}
	
	public boolean checkIdentical(BinaryTreeNode root1,BinaryTreeNode root2 ) {
		if(root1 == null) {
			return false;
		}
		else if(root2 == null) {
			return false;
		}
		else {
			checkIdentical(root1.left,root2.left);
			if(root1.data==root2.data && flag == 1) {
				b=true;
			}
			else {
				b=false;
				flag = 0;
			}
			checkIdentical(root1.right,root2.right);
		}
		return b;
	}
	public boolean checkMirror(BinaryTreeNode root1,BinaryTreeNode root3 ) {
		if(root1 == null) {
			return false;
		}
		else if(root3 == null) {
			return false;
		} 
		else {
			checkMirror(root1.left,root3.right);
			if(root1.data==root3.data && flag_1 == 1) {
				b=true;
			}
			else {
				b=false;
				flag_1 = 0;
			}
			checkMirror(root1.right,root3.left);
		}
		return b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComparingTrees test = new ComparingTrees();
		BinaryTreeNode root1 = test.createBinaryTree1();
		BinaryTreeNode root2 = test.createBinaryTree2();
		BinaryTreeNode root3 = test.createBinaryTree3();
		System.out.println(test.checkIdentical(root1,root2));
		System.out.println(test.checkMirror(root1,root3));
	}

}
