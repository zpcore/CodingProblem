import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.LinkedList;

public class TopologicalSort {
	class Node {
		int val;
		Set<Node> next;
		Node(int val) {
			this.val = val;
			next = new HashSet<>();
		}
	}


	public List<Integer> topologicalSort(Set<Node> nodeSet) {
		Set<Node> visited = new HashSet<>();
		List<Integer> ls = new LinkedList<>();
		for(Node n: nodeSet) helper(visited,n,ls);
		return ls;
	}

	private void helper(Set<Node> visited, Node root, List<Integer> ls) {
		if(visited.contains(root)) return;
		visited.add(root);
		for(Node n: root.next) {				
			helper(visited,n,ls);
		}
		ls.add(0,root.val);
	}

	public boolean checkTopologicalSort(Set<Node> nodeSet) {
		Set<Node> visited = new HashSet<>();
		for(Node n: nodeSet) {
			if(!helper(visited,n,new HashSet<>())) return false;
		}
		return true;
	}

	private boolean helper(Set<Node> visited, Node root, Set<Node> checking) {
		visited.add(root);
		checking.add(root);
		for(Node n: root.next) {						
			if(checking.contains(n)) return false;
			if(visited.contains(n)) continue;		
			if(!helper(visited,n,checking)) return false;
		}
		checking.remove(root);
		return true;
	}

	public Set<Node> prepare() {
		Set<Node> nodeSet = new HashSet<>();
		Node a = new Node(3);
		Node b = new Node(4);
		Node c = new Node(5);
		Node d = new Node(6);
		Node e = new Node(7);
		Node f = new Node(8);
		nodeSet.add(a);
		nodeSet.add(b);
		nodeSet.add(c);
		nodeSet.add(d);
		nodeSet.add(e);
		a.next.add(b);
		a.next.add(c);
		b.next.add(c);
		b.next.add(d);
		d.next.add(e);
		c.next.add(d);
		//e.next.add(b);
		return nodeSet;
	}

	public static void main(String[] args) {
		TopologicalSort sol = new TopologicalSort();
		
		System.out.println(sol.checkTopologicalSort(sol.prepare()));
	}

}