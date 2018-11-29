import java.util.*;
//Extend from decode ways, print all the decode
public class decodeways{
	public static void main(String[] args){
		List<String> res = new ArrayList<>();
		int[] nums = new int[]{1,2,3,1,8,5,1,0,7,2,1};
		//int[] nums = new int[]{1,0,7};
		decodeways sol = new decodeways();
		sol.helper(res,"",0,nums);
		for(String s: res) System.out.println(s);
	} 

	private void helper(List<String> res, String s, int pos, int[] nums){
		if(pos == nums.length){
			res.add(s);
			return;
		}
		if(nums[pos]!=0){
			char c = (char)(nums[pos]-1+'A');
			helper(res,s+c,pos+1,nums);
		}
		if(pos<nums.length-1){
			int tmp = nums[pos]*10+nums[pos+1];
			char c = (char)(tmp-1+'A');
			if(tmp<=26 && tmp>=10) helper(res,s+c,pos+2,nums);
		}
		
	}

}