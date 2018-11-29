public class BIT{
	
	int[] BITArray;

	BIT(int[] nums) { // the size of numbers
		// construct the BIT from array, time complexity(O(nlogn))
		int len = nums.length;
		BITArray = new int[len+1];
		for(int i=0; i<len; i++) { 
			// start from i+1 pos in the BIT
			update(i,nums[i]);
		}
	}

	//get range sum [0,n]: Find the node n+1, sum up from n+1 to its root.
	public int getSum(int n) {
		int parent = n+1;
		int sum = 0;
		while(parent!=0) {
			sum += BITArray[parent];
			parent = getParent(parent);
		}
		return sum;
	}

	public void update(int index, int incVal) {
		// incVal: new val - old val
		int next = index + 1;
		while(next<BITArray.length) {
			BITArray[next] += incVal;
			next = getNext(next);
		}
	}

	public int getParent(int index) {
		return index - (-index & index);
	}



	public int getNext(int index) { // getNext
		return index + (-index & index);
	}


	public static void main(String[] args) {
		int[] test = new int[]{1,2,3,4,5,6,7,8,9,3,2,1};
		BIT b = new BIT(test);
		b.update(5,1);
		for(int i=0; i<test.length; i++) {
			System.out.println(b.getSum(i));
		}
	}


}