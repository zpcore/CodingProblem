    /*
第二轮电话面试，一个等差数列，中间少一个数字，找出这个数字 
follow up 1: 如果是等比数列呢？. 
follow up 2: 如果给一个数列，并不知道是等差还是等比，找出这个数字
     */


public class findmissinAP{

	public static void main(String[] args){
		int[] as = new int[]{1,3,5,7,9,11,13,17,19};
		System.out.println(ap_solution(as));
		int[] gs = new int[]{1,4,8,16,32,64,128,256,512,1024};
		System.out.println(gp_solution(gs));
	}

	//arithmetic progression 
	public static int ap_solution(int[] nums){
		int lo = 0, hi = nums.length-1;
		while(lo<=hi){
			System.out.println("low:"+lo+" high:"+hi);
			int mid = lo+(hi-lo)/2;
			if(lo+1==hi) return nums[lo]+(nums[hi]-nums[lo])/2;
			if(2*nums[mid]<nums[lo]+nums[hi]){
				lo = mid;
			}else{
				hi = mid;
			}
		}
		return -1;
	}

	//geometric progression
	public static int gp_solution(int[] nums){
		int lo = 0, hi = nums.length-1;
		while(lo<=hi){
			System.out.println("low:"+lo+" high:"+hi);
			int mid = lo+(hi-lo)/2;
			if(lo+1==hi) return (int)Math.sqrt((double)nums[lo]*nums[hi]);
			if(nums[mid]*nums[mid]<nums[lo]*nums[hi]){
				lo = mid;
			}else{
				hi = mid;
			}
		}
		return -1;
	}


	public static int gap_solution(int nums[]){
		// decide ap or gp
		int lo = 0, hi = nums.length-1;
		
		return 0;
	}

}