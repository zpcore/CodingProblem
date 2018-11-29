
// write a quick sort
// find the kth largested number (there are three solutions, here I use partiton to slove)
public class partition{


	public static void main(String[] args){
		int[] nums = new int[]{4,7,2,1,8,33,21,0};
		partition sol = new partition();
		System.out.println(sol.findKMaximum(nums,4));
		sol.quicksort(nums);
		for(int n:nums) System.out.format("%4d",n);
			System.out.println();
	}

	private int findKMaximum(int[] nums, int k){
		int lo=0, hi=nums.length-1;
		while(lo<=hi){
			int part = partition(nums,lo,hi);
			if(part==k-1) return nums[part];
			else if(part<k-1){
				lo=part+1;
			}else if(part>k-1){
				hi=part-1;
			}
		}
		return -1;
	}
	
	private int partition (int[] nums, int lo, int hi){
	    // pivot (Element to be placed at right position)
	    int pivot = nums[hi];
	    int i = lo-1;  // Index of smaller element
	    for (int j=lo; j<hi; j++){
	        if (nums[j] <= pivot){
	            i++;    // increment index of smaller element
	            swap(nums,i,j);
	        }
	    }
	    swap(nums,i+1,hi);
	    return i+1;
	}

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

	private void quicksort(int[] nums){
		helper(nums,0,nums.length-1);
		return;
	}

	private void helper(int[] nums, int i, int j){
		if(i>=j) return;
		int part=partition(nums,i,j);
		helper(nums,i,part-1);
		helper(nums,part+1,j);
	}




}