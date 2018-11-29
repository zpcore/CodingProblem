import java.util.HashMap;
import java.util.Map;

class UnionFind{

	int[] array = new int[100];

	public void makeSet(int i) {
		array[i] = i;
	}

	public void union(int a, int b) {
		if(findSet(a)!=findSet(b)) {
			array[array[a]] = array[b]; 
		}
	}

	public int findSet(int a) {
		if(array[a]!=a) {
			array[a] = findSet(array[a]);
		}
		return array[a];
	}

	public static void main(String[] args) {
		UnionFind uf = new UnionFind();
		uf.makeSet(23);
		uf.makeSet(12);
		uf.makeSet(37);
		uf.makeSet(47);
		uf.makeSet(3);
		
		uf.union(23,12);
		uf.union(47,47);
		uf.union(47,3);
		uf.union(47,12);
		System.out.println(uf.findSet(12));
		System.out.println(uf.findSet(23));
		System.out.println(uf.findSet(47));
		//System.out.println(uf.findSet(23));

	}


}
