 /*
    一个array, [1,3,5,7,4,8,2], 一个 target k, 找出这个array里所有子集的个数，满足：子集里最小和最大的数相加小于等于k.. more info on 1point3acres.com
*/

 /*
	Pei: extend this question to print all the subarrays
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class findsubarraywithlimitation{

	public static void main(String[] args){
		int[] nums = new int[]{4,7,1,3,55,9,6,2};
		List<List<Integer>> lls = solution(nums,10);
		for(List<Integer> ls: lls){
			System.out.println(ls);
		}
	}

	public static List<List<Integer>> solution(int[] nums, int k){
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		int ptr1 = 0, ptr2 = nums.length-1;
		while(ptr1<ptr2){
			if(nums[ptr1]+nums[ptr2]>k){
				ptr2--;
			}else{
				List<List<Integer>> lls = getAllSubarray(nums,ptr1+1,ptr2);
				for(List<Integer> ls:lls){
					ls.add(0,nums[ptr1]);
					res.add(ls);
				}				
				ptr1++;
			}
		}
		return res;

	}

	// get all the subarray
	public static List<List<Integer>> getAllSubarray(int[] nums, int i, int j){
		List<List<Integer>> lls = new ArrayList<>();
		helper(lls,new ArrayList<>(),i,nums,i,j);
		return lls;
	}

	public static void helper(List<List<Integer>> lls, List<Integer> ls, int pos, int[] nums, int st, int ed){
		if(pos > ed){
			lls.add(new ArrayList<Integer>(ls));
			return;
		}
		ls.add(nums[pos]);
		helper(lls,ls,pos+1,nums,st,ed);
		ls.remove(ls.size()-1);
		helper(lls,ls,pos+1,nums,st,ed);
	}

}
