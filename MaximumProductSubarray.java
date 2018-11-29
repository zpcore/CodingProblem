
// 152. Maximum Product Subarray, return the range of the subarray of the maximum product
// suppose there's only one solution
public class MaximumProductSubarray{

	public static void main(String[] args){
		int[] nums = new int[]{3,5,-1,3,2,-2,5,7,-1,2};
		MaximumProductSubarray sol = new MaximumProductSubarray();
		int[] res = sol.findRange(nums);
		for(int n:res) System.out.format("%10d",n);
		System.out.println();
	}

	public int[] findRange(int[] nums){
		int min=0,max=0;
		int minPos=0,maxPos=0;
		int[] res = new int[3];
		int maxProduct = 0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]<0){
				int tmp = min;
				min = max;
				max = tmp;
				tmp = minPos;
				minPos = maxPos;
				maxPos = tmp;
			}

			//max = Math.max(max*nums[i],nums[i]);
			if(max*nums[i]>nums[i]){
				max *= nums[i];
			}else{
				max = nums[i];
				maxPos = i;
			}

			//min = Math.min(min*nums[i],nums[i]);
			if(min*nums[i]<nums[i]){
				min *= nums[i];
			}else{
				min = nums[i];
				minPos = i;
			}

			if(maxProduct<max){
				maxProduct = max;
				res[0] = maxPos; //start posotion
				res[1] = i;	//end position
				res[2] = maxProduct; //max product
			}
		}
		return res;
	}


}