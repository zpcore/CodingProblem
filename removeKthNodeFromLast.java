public class removeKthNodeFromLast{
	private static class ListNode{
		ListNode next; 
		int val;
		ListNode(int val){
			this.val = val;
		}
	}

	public static void main(String[] args){		
		ListNode[] n = new ListNode[6];
		for(int i=0;i<6;i++){
			n[i] = new ListNode(i);
			if(i!=0) n[i-1].next = n[i];
		}
		removeKthNodeFromLast sol = new removeKthNodeFromLast();		
		ListNode head = sol.solution(n[0],1);;
		while(head!=null){
			System.out.format("%4d",head.val);
			head = head.next;
		}
	}

	public ListNode solution(ListNode head, int k){
		ListNode curNode = head;
		int cnt = 0;
		while(curNode!=null){
			curNode = curNode.next;
			cnt++;
		}
		// 1,2,3,4
		int cutNode = cnt-k+1;
		if(cutNode<=0) return null;
		int i = 1;
		curNode = head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode preNode = dummy;
		while(i<cutNode){
			preNode = curNode;
			curNode = curNode.next;
			i++;
		}
		preNode.next = curNode.next;
		return dummy.next;
	}

}