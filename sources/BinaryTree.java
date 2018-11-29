package basic.mypackage;

import java.util.Deque;
import java.util.ArrayDeque;
import java.lang.StringBuilder;
import java.util.List;
import java.util.ArrayList;

public class BinaryTree {

	public TreeNode root = null;

	public BinaryTree(String S) {
		if(S==null || S.length()==0 || S.equals("null")) {
			root = null;
			return;
		}
		String[] sArr = S.split(",");
		root = new TreeNode(Integer.valueOf(sArr[0]));
		int ptr = 1;
		Deque<TreeNode> dq = new ArrayDeque<>();
		dq.add(root);
		while(!dq.isEmpty() && ptr<sArr.length) {
			int size = dq.size();
			for(int i=0;i<size;i++) {
				TreeNode curNode = dq.pollFirst();
				if(ptr!=sArr.length) {
					if(!sArr[ptr].equals("null")) {
						TreeNode left = new TreeNode(Integer.valueOf(sArr[ptr]));
						curNode.left = left;
						dq.add(left);
					}
					ptr++;
				}
				if(ptr!=sArr.length) {
					if(!sArr[ptr].equals("null")) {
						TreeNode right = new TreeNode(Integer.valueOf(sArr[ptr]));
						curNode.right = right;
						dq.add(right);
					}
					ptr++;
				}
			}
		}
	}

	@Override
	public String toString()
	{
		if(root==null) return "null";
		StringBuilder sb = new StringBuilder();
		Deque<TreeNode> dq = new ArrayDeque<>();
		dq.add(root);
		List<String> ls = new ArrayList<>();
		ls.add(String.valueOf(root.val));
		while(!dq.isEmpty()){
			int size = dq.size();
			for(int i=0;i<size;i++) {
				TreeNode curNode = dq.pollFirst();
				if(curNode.left==null) ls.add("null");
				else {
					dq.add(curNode.left);
					ls.add(String.valueOf(curNode.left.val));
				}
				if(curNode.right==null) ls.add("null");
				else {
					dq.add(curNode.right);
					ls.add(String.valueOf(curNode.right.val));
				}
			}
		}
		int i = ls.size()-1;
		while(i>1 && ls.get(i).equals("null")) i--;
		sb.append(ls.get(0));
		for(int t=1;t<=i;t++) sb.append(","+ls.get(t));
		return sb.toString();
	}
}