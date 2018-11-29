import java.util.*;
//A: 题目: 一个排好序的array，找出所有满足的最大值和最小值相加为定值k的subset的数量。
//B: follow-up: 找出max+min <= k 的子集的数量。
//C: follow-up: 如果这个array非常长的时候，怎么用多线程来实现算法
class MinMaxSubset {
// 1 2 3 4 5 6 7    k = 7
// 1               6
// 2               5
// 3               4

	public static void main(String[] args) {
		MinMaxSubset sol = new MinMaxSubset();
		int[] in = new int[]{4};
		sol.B(in,7);
	}


	public int A(int[] nums, int k) {
		int i = 0, j = nums.length-1, sum = 0;
		// num[i] + nums[j] == k
		while(i<j) {
			while(i<j && nums[i]+nums[j]<k) i++;
			if(i==j) break;
			if(nums[i]+nums[j]==k) {
				sum += Math.pow(2,i);
			}
			j--;
		}
		return sum;
	}

	public int B(int[] nums, int k) {
		int i = -1, j = nums.length-1, sum = 0;
		// i:   find biggest i that: num[0:i] + nums[j] <= k && i<=j
		while(i<=j) {
			while(i+1<=j && nums[i+1]+nums[j]<=k) i++;
			if(i==-1) {
				j--;
				continue;
			}
			if(i==j) sum+=1;
			else sum += Math.pow(2,j-i-1);
			System.out.println(i+" "+j);
			j--;
		}
		return sum;
	}


}