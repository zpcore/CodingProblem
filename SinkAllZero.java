import basic.mypackage.TreeNode;
import basic.mypackage.BinaryTree;


class SinkAllZero {
	public static void main(String[] args){
		SinkAllZero solution = new SinkAllZero();
		BinaryTree bt = new BinaryTree("1,0,0,1,1,null,0,0,1,1,0,0");
		solution.sinkAllZero(bt.root);
		System.out.println(bt);
	}

			// 		1
			// 0               0
		 //  1   1               0
		 // 0 1 1 0             0


			// 		1
			// 1               0
		 //  1   1               0
		 // 0 0 1 0             0
                     



	public TreeNode sinkAllZero(TreeNode root) {
		if(root==null) return root;	
		sinkAllZero(root.left);
		sinkAllZero(root.right);
		sink(root);
		return root;
	}


	private void sink(TreeNode root) {
		// in this time, root.val = 0.
		if(root.val==1) return;
		if((root.left==null || root.left.val==0) && (root.right==null || root.right.val==0)) return;
		if(root.left!=null && root.left.val==1) {
			root.left.val = 0;
			root.val = 1;
			sink(root.left);
		}else {
			root.right.val = 0;
			root.val = 1;
			sink(root.right);
		}
	}
}