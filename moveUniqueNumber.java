public class moveUniqueNumber{

	public static void main(String[] args){
		int[] nums = new int[]{1,1,2,2,2,3,4,5,5,6,10};
		moveUniqueNumber sol = new moveUniqueNumber();
		System.out.println(sol.solution(nums));
		for(int n:nums) System.out.format("%4d",n);
	}



	public int solution(int[] nums){
		if(nums.length==0) return 0;
		int pre=nums[0];
		int cnt=1;
		int j=1;
		for(int i=1;i<nums.length;i++){
			if(nums[i]!=pre){
				pre = nums[i];
				cnt++;
				int tmp = nums[j];
				nums[j] = nums[i];
				nums[i] = tmp;
				j++;
			}
		}
		return cnt;

	}
}