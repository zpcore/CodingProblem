import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Stack;

public class twobst{
	// input： two bst
	// output：print all elements in those two bsts in sorted form
	// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=236354&highlight=facebook
	public static class TreeNode{
		TreeNode left=null;
		TreeNode right=null;
		int val;
		TreeNode(int val){
			this.val=val;
		}
	}

	public static void main(String[] args){
		     //          15
		     //    8           23
		     // 2     9

		TreeNode n0 = new TreeNode(15);
		TreeNode n1 = new TreeNode(8);
		TreeNode n2 = new TreeNode(23);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(9);
		n0.left=n1;
		n1.left=n3;
		n1.right=n4;
		n0.right=n2;

		TreeNode m0 = new TreeNode(10);
		TreeNode m1 = new TreeNode(7);
		TreeNode m2 = new TreeNode(5);
		TreeNode m3 = new TreeNode(9);
		TreeNode m4 = new TreeNode(14);
		TreeNode m5 = new TreeNode(12);
		// 			10
		// 	   7					14
		// 5		9			12	
		m0.left=m1;
		m1.left=m2;
		m1.right=m3;
		m0.right=m4;
		m4.left=m5;
		List<Integer> res = solution(n0,n1);
		System.out.println(res);
	}

	private static void pushAllLeft(Deque<TreeNode> stack, TreeNode root){
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }

	public static List<Integer> solution(TreeNode root1, TreeNode root2){
		boolean fetch1=true, fetch2=true, stop;
		List<Integer> res = new ArrayList<>();
		//inorder traverse
		Deque<TreeNode> stack1 = new ArrayDeque<>();
		Deque<TreeNode> stack2 = new ArrayDeque<>();
		TreeNode pop1=null, pop2=null;
		pushAllLeft(stack1,root1);
		pushAllLeft(stack2,root2);

		while(!stack1.isEmpty()||!stack2.isEmpty()){
			stop = false;
			if(stack1.isEmpty()) pop1=null;
			if(stack2.isEmpty()) pop2=null;
			if(fetch1){
				while(!stop&&!stack1.isEmpty()){
		            TreeNode curNode = stack1.pop();
		            stop = true;
		            pop1 = curNode;
		            pushAllLeft(stack1,curNode.right);
				}
			}
			stop = false;
			if(fetch2){
				while(!stop&&!stack2.isEmpty()){
		            TreeNode curNode = stack2.pop();
		            stop = true;
		            pop2 = curNode;
		            pushAllLeft(stack2,curNode.right);
				}
			}

			if(pop1!=null&&pop2==null){
				res.add(pop1.val);
				fetch1=true;
				fetch2=false;
				pop1 = null;
			}else if(pop1==null&&pop2!=null){
				res.add(pop2.val);
				fetch1=false;
				fetch2=true;
				pop2=null;
			}else if(pop1!=null&&pop2!=null){
				if(pop1.val<=pop2.val){
					res.add(pop1.val);
					fetch1=true;
					fetch2=false;
					pop1 = null;
				}else{
					res.add(pop2.val);
					fetch1=false;
					fetch2=true;
					pop2=null;
				}
			}
			
			
			if(stack1.isEmpty()){
				fetch1=false;
				fetch2=true;
			} 
			if(stack2.isEmpty()){
				fetch1=true;
				fetch2=false;
			}
			

		}
		return res;

	}





}