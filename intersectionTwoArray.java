import java.util.*;

public class intersectionTwoArray{
	public static void main(String[] args){
		int[] nums1 = new int[]{0,0,0,1,1,3,4,4,5,7};
		int[] nums2 = new int[]{0,1,1,1,2,4,4,5,6};
		intersectionTwoArray sol = new intersectionTwoArray();
		List<Integer> res = sol.solution(nums1,nums2);
		for(int n:res) System.out.format("%4d",n);
	}

//sorted version
	private List<Integer> solution(int[] nums1, int[] nums2){
		int p1=0,p2=0;
		List<Integer> res = new ArrayList<>();
		while(p1<nums1.length&&p2<nums2.length){
			while(p1<nums1.length&&nums1[p1]<nums2[p2]) p1++;
			while(p2<nums2.length&&nums1[p1]>nums2[p2]) p2++;
			if(p1<nums1.length&&p2<nums2.length&&nums1[p1]==nums2[p2]){
				res.add(nums1[p1]);
				p1++;
				p2++;
			}
		}
		return res;
	}
//unsorted


}